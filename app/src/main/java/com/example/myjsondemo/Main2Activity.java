package com.example.myjsondemo;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main2Activity extends Activity {

    EditText Name, designation, pay, landline, mobile;
    Button Save;
    File file;
    String name, desi, Pay, Lanline, Mobile;
    private ArrayList<Employee> emplist;

    JSONObject allEmps;
    JSONArray empArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Name = (EditText) findViewById(R.id.Name);
        designation = (EditText) findViewById(R.id.Designation);
        pay = (EditText) findViewById(R.id.pay);
        landline = (EditText) findViewById(R.id.LandLine);
        mobile = (EditText) findViewById(R.id.Mobile);
        Save = (Button) findViewById(R.id.Save);

        String dir = Environment.getExternalStorageDirectory() + File.separator + "Myjsonfolder";
        //create folder
        File folder = new File(dir); //folder name
        folder.mkdirs();

        //create file
        file = new File(dir, "Myjson.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = Name.getText().toString().trim();
                desi = designation.getText().toString().trim();
                Pay = pay.getText().toString().trim();
                Lanline = landline.getText().toString().trim();
                Mobile = mobile.getText().toString().trim();

              //  Employee emp = new Employee(name,desi,Pay,Lanline,Mobile);
                Employee emp = new Employee("mayur", "maihit", "Pay", "Lanline", "Mobile");
                Employee emp1 = new Employee("name", "desi", "Pay", "Lanline", "Mobile1");
                Employee emp2 = new Employee("n55ame", "des888i", "Pay500", "Lanl80ine", "Mobil800e");
                emplist = new ArrayList<Employee>();
                emplist.add(emp);
                emplist.add(emp1);
                emplist.add(emp2);

                allEmps = new JSONObject();
                empArray = new JSONArray();
                JSONObject empObj;
                JSONArray phoneNumbers = null;
                JSONObject phoneObj;

                if (null != emplist) {
                    for (int i = 0; i < emplist.size(); i++) {
                        String name = emplist.get(i).getName().toString();
                        String de = emplist.get(i).getDestination().toString();
                        String pay = emplist.get(i).getPay().toString();
                        String lan = emplist.get(i).getLanline().toString();
                        String mobile = emplist.get(i).getMobile().toString();
                        empObj = new JSONObject();
                        try {
                            empObj.put("Name", name);
                            empObj.put("Designation", de);
                            empObj.put("Pay", "Rs. " + pay);

                            phoneNumbers = new JSONArray();
                            phoneObj = new JSONObject();
                            phoneObj.put("LandLine", lan);
                            phoneObj.put("Mobile", mobile);
                            phoneNumbers.put(phoneObj);

                            empObj.put("PhoneNumbers", phoneNumbers);

                            empArray.put(empObj);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                try {
                    allEmps.put("Employees", empArray);

                    // Writing to a file
                    FileWriter file1 = new FileWriter(file);
                    file1.write(allEmps.toString());
                    file1.flush();
                    file1.close();

                    /*OutputStreamWriter writer = new OutputStreamWriter(
                            new FileOutputStream(file, true), "UTF-8");
                    BufferedWriter fbw = new BufferedWriter(writer);
                    fbw.write(allEmps.toString());
                    fbw.newLine();
                    fbw.close();*/

                    /*
                    FileWriter fstream = new FileWriter(file, true);
                    BufferedWriter fbw = new BufferedWriter(fstream);
                    fbw.write(allEmps.toString());
                    fbw.close();*/

                    System.out.println("JSon file created");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });


    }
}
