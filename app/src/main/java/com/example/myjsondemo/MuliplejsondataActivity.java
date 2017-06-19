package com.example.myjsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MuliplejsondataActivity extends AppCompatActivity {
    TextView textViewname,textViewSalary,textViewmarried;
    ListView lsvemp;
    String name;
    int salary;
    Boolean married;

    ArrayList<String> Id = new ArrayList<String>();
    ArrayList<String> Name = new ArrayList<String>();
    ArrayList<Integer> Salary = new ArrayList<Integer>();
    ArrayList<Boolean> Married = new ArrayList<Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muliplejsondata);
        lsvemp=(ListView)findViewById(R.id.listemp);
        try {

            StringBuilder buf = new StringBuilder();
            InputStream json = getAssets().open("jsonmuliple.json");

            BufferedReader in =new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;

            while ((str = in.readLine()) != null) {
                buf.append(str);
            }
            in.close();

            JSONObject jsonObject=new JSONObject(buf.toString());
            JSONArray jsonArray=new JSONArray();
            //jsonArray=jsonObject.optJSONArray("employee"); OR
            jsonArray=jsonObject.getJSONArray("employee");

            for(int i=0; i < jsonArray.length(); i++){
                JSONObject emp=jsonArray.getJSONObject(i);
                Id.add(emp.getString("id"));
                Name.add(emp.getString("name"));
                Salary.add(emp.getInt("salary"));
                Married.add(emp.getBoolean("married"));
                Log.d("Id", emp.getString("id"));
                Log.d("name",emp.getString("name"));
                Log.d("sala",String.valueOf(emp.getInt("salary")));
                Log.d("merid",String.valueOf(emp.getBoolean("married")));
            }
            Listadapter adapter=new Listadapter(MuliplejsondataActivity.this,Id,Name,Salary,Married);
            lsvemp.setAdapter(adapter);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
