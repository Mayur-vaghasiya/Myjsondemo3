package com.example.myjsondemo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class PostdatatojsonActivity extends AppCompatActivity {
    FileOutputStream fOut = null;
    OutputStreamWriter osw = null;
    EditText Name, designation, pay, landline, mobile;
    Button Save;
    File file;
    String name,desi,Pay,Lanline,Mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postdatatojson);

        Name=(EditText)findViewById(R.id.Name);
        designation=(EditText)findViewById(R.id.Designation);
        pay=(EditText)findViewById(R.id.pay);
        landline=(EditText)findViewById(R.id.LandLine);
        mobile=(EditText)findViewById(R.id.Mobile);
        Save=(Button)findViewById(R.id.Save);

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

                name=Name.getText().toString().trim();
                desi=designation.getText().toString().trim();
                Pay=pay.getText().toString().trim();
                Lanline=landline.getText().toString().trim();
                Mobile=mobile.getText().toString().trim();

                JSONObject allEmps = new JSONObject();

                JSONArray empArray = new JSONArray();
                JSONObject empObj;
                JSONArray phoneNumbers = null;
                JSONObject phoneObj;


                try {



                    empObj = new JSONObject();
                    empObj.put("Name", "ABC");
                    empObj.put("Designation", "Sr.Manager");
                    empObj.put("Pay", "Rs. 60000");

                    phoneNumbers = new JSONArray();
                    phoneObj = new JSONObject();
                    phoneObj.put("LandLine", "12-2xxxx129");
                    phoneObj.put("Mobile", "45xxxxxx11");
                    phoneNumbers.put(phoneObj);

                    empObj.put("PhoneNumbers", phoneNumbers);
                    empArray.put(empObj);

                    empObj = new JSONObject();
                    empObj.put("Name", "ABC");
                    empObj.put("Designation", "Manager");
                    empObj.put("Pay", "Rs. 60000");

                    phoneNumbers = new JSONArray();
                    phoneObj = new JSONObject();
                    phoneObj.put("LandLine", "11-2xxxx99");
                    phoneObj.put("Mobile", "99xxxxxx11");
                    phoneNumbers.put(phoneObj);

                    empObj.put("PhoneNumbers", phoneNumbers);
                    empArray.put(empObj);


                    empObj = new JSONObject();
                    empObj.put("Name", "ABC");
                    empObj.put("Designation", "Sr.Manager");
                    empObj.put("Pay", "Rs. 60000");

                    phoneNumbers = new JSONArray();
                    phoneObj = new JSONObject();
                    phoneObj.put("LandLine", "12-2xxxx129");
                    phoneObj.put("Mobile", "45xxxxxx11");
                    phoneNumbers.put(phoneObj);

                    empObj.put("PhoneNumbers", phoneNumbers);
                    empArray.put(empObj);

                    allEmps.put("Employees", empArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {

                    // Writing to a file
                    FileWriter file1 = new FileWriter(file);
                    file1.write(allEmps.toString());
                    file1.flush();
                    file1.close();

                    System.out.println("JSon file created");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Name.getText().clear();
                designation.getText().clear();
                pay.getText().clear();
                landline.getText().clear();
                mobile.getText().clear();
            }
        });


    }

}
