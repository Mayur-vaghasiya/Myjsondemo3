package com.example.myjsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonExamplActivity extends AppCompatActivity {
    TextView textViewname, textViewauth, textViewcompany, txtviewcom1;
    String com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_exampl);

        textViewname = (TextView) findViewById(R.id.txtname);
        textViewauth = (TextView) findViewById(R.id.txtauther);
        textViewcompany = (TextView) findViewById(R.id.txtcompnyname);
        txtviewcom1 = (TextView) findViewById(R.id.txtcompnyname1);

        try {

            StringBuilder buf = new StringBuilder();
            InputStream json = getAssets().open("jsonexample.json");

            BufferedReader in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;

            while ((str = in.readLine()) != null) {
                buf.append(str);
            }
            in.close();
            JSONObject jsonObject = new JSONObject(buf.toString());

            String name = jsonObject.getString("Name").toString();
            String auther = jsonObject.getString("Author").toString();

            textViewname.setText(name);
            textViewauth.setText(auther);
            JSONArray jarry = jsonObject.getJSONArray("Company List");
            for (int i = 0; i < jarry.length(); i++) {
                jarry.getString(i);
                textViewcompany.setText( jarry.getString(0));
                txtviewcom1.setText( jarry.getString(1));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
