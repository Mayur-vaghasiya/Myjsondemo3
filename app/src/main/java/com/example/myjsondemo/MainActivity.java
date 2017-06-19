package com.example.myjsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView textViewname,textViewSalary,textViewmarried;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewname = (TextView) findViewById(R.id.txtname);
        textViewSalary = (TextView) findViewById(R.id.txtsalary);
        textViewmarried = (TextView) findViewById(R.id.txtmarried);
        try {

            StringBuilder buf = new StringBuilder();
            InputStream json = getAssets().open("jsonsingle.json");

            BufferedReader in =new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;

            while ((str = in.readLine()) != null) {
                buf.append(str);
            }
            in.close();

            JSONObject jsonObject=new JSONObject(buf.toString());
            JSONObject emp=jsonObject.getJSONObject("employee");

            String name=emp.getString("name");
            int salary=emp.getInt("salary");
            Boolean married=emp.getBoolean("married");
            textViewname.setText(name);
            textViewSalary.setText(String.valueOf(salary));
            textViewmarried.setText(String.valueOf(married));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
