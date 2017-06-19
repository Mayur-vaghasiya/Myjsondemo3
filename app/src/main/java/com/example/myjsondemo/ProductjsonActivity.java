package com.example.myjsondemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProductjsonActivity extends AppCompatActivity {
    ListView lsvemp;
    ArrayList<product> Productlist = new ArrayList<product>();

    Databasehelper dhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productjson);
        lsvemp = (ListView) findViewById(R.id.listpro);
        dhelper=new Databasehelper(this);
        try {

            StringBuilder buf = new StringBuilder();
            InputStream json = getAssets().open("Jsonpars.json");

            BufferedReader in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;

            while ((str = in.readLine()) != null) {
                buf.append(str);
            }
            in.close();
            getSharedPreferences("MyLoginpref", MODE_PRIVATE)
                    .edit()
                    .putString("USER", buf.toString())
                    .commit();
            SharedPreferences pref = getSharedPreferences("MyLoginpref", MODE_PRIVATE);
            String USER = pref.getString("USER", null);
             JSONObject jsonObject = new JSONObject(buf.toString());
          //  JSONObject jsonObject = new JSONObject(USER);
            JSONArray jsonArray = new JSONArray();

            jsonArray = jsonObject.getJSONArray("Products");


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject emp = jsonArray.getJSONObject(i);

                String Name = emp.getString("Name");
                String ProductID=emp.getString("ProductID");
                String PackageID=emp.getString("PackageID");
                String Image = emp.getString("ImageName");
                String SKU=emp.getString("SKU");
                String LastModified=emp.getString("LastModified");
                Long Price = emp.getLong("Price");
                String CategoryIDs=emp.getString("CategoryIDs");

                product p = new product(Name,ProductID,PackageID,Image,SKU,LastModified,Price,CategoryIDs);

                 dhelper.addproduct(p);

                //Productlist.add(p);

                Log.d("Name", emp.getString("Name"));
                Log.d("Image", emp.getString("ImageName"));
                Log.d("Price", String.valueOf(emp.getLong("Price")));

            }
            Log.e("NameSize", String.valueOf(Productlist.size()));

            Productlist=dhelper.getproduct();
            Toast.makeText(this, "Sizeof Json Array" + String.valueOf(jsonArray.length()) + " " + String.valueOf(Productlist.size()), Toast.LENGTH_LONG).show();
            ProductListadapter adapter = new ProductListadapter(ProductjsonActivity.this, Productlist);
            lsvemp.setAdapter(adapter);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
