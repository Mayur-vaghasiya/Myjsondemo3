package com.example.myjsondemo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MycomlexjsonintextActivity extends AppCompatActivity {
    File file;
    JSONObject mybullet;
    JSONArray clientArray;
    JSONObject  projinfo;
    private ArrayList<Complexjson> emplist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycomlexjsonintext);
        String dir = Environment.getExternalStorageDirectory() + File.separator + "Myjsonfolder";
        //create folder
        File folder = new File(dir); //folder name
        folder.mkdirs();

        //create file
        file = new File(dir, "Myjson1.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Complexjson comjson=new Complexjson("my-bulletin-1114", "15289510316", "My Bulletin",
                "1:15289510316:android:d28b292c8a5cd64c","android:peacocktech.in.mybulletin", "1","peacocktech.in.mybulletin",
                "15289510316-6invur0lmrkctos04raof0gf9csicitp.apps.googleusercontent.com","1" ,"peacocktech.in.mybulletin" ,"C54F2958287D89E21D16CE1089279A82BC616E7B",
                "15289510316-a4bri9ppielr31fu1je2is2v67vaib6k.apps.googleusercontent.com","3",
                "1","1" ,"1" ,"2" ,"1" ,
                "1"
                );
        emplist = new ArrayList<Complexjson>();
        emplist.add(comjson);
        mybullet = new JSONObject();





        if (null != emplist) {
            for (int i = 0; i < emplist.size(); i++) {
                String project_id = emplist.get(i).getProjectid().toString();
                String project_number = emplist.get(i).getProjnumber().toString();
                String name = emplist.get(i).getName().toString();

                String mobilesdk_app_id= emplist.get(i).getMobilesdk_app_id().toString();
                String client_id=emplist.get(i).getClient_id().toString();
                String client_type =emplist.get(i).getClient_type().toString();
                String package_name=emplist.get(i).getPackage_name().toString();

                String client_id1= emplist.get(i).getClient_id1().toString();
                String client_type1=emplist.get(i).getClient_type1().toString();

                String package_name1 =emplist.get(i).getPackage_name1().toString();
                String certificate_hash=emplist.get(i).getCertificate_hash().toString();

                String client_id2 =emplist.get(i).getClient_id3().toString();
                String client_type2=emplist.get(i).getClient_type3().toString();


                JSONObject  projinfo = new JSONObject();
                try {
                    projinfo.put("project_id", project_id);
                    projinfo.put("project_number", project_number);
                    projinfo.put("name",name);
                    mybullet.put("project_info",projinfo);

                    clientArray = new JSONArray();
                    JSONObject client=new JSONObject();
                    JSONObject clientinfo=new JSONObject();

                    clientinfo.put("mobilesdk_app_id",mobilesdk_app_id);
                    clientinfo.put("client_id",client_id);
                    clientinfo.put("client_type",client_type);

                    JSONObject android_client_info=new JSONObject();
                    android_client_info.put("package_name",package_name);

                    clientinfo.put("android_client_info",android_client_info);
                    client.put("client_info",clientinfo);

                    JSONArray oauth_clientarry=new JSONArray();
                    JSONObject oauth_client=new JSONObject();

                    oauth_client.put("client_id",client_id1);
                    oauth_client.put("client_type",client_type1);

                    JSONObject android_info=new JSONObject();

                    android_info.put("package_name",package_name1);
                    android_info.put("certificate_hash",certificate_hash);

                    oauth_client.put("android_info",android_info);
                    oauth_clientarry.put(oauth_client);

                    JSONObject oauth_client1=new JSONObject();

                    oauth_client1.put("client_id",client_id1);
                    oauth_client1.put("client_type",client_type2);

                    oauth_clientarry.put(oauth_client1);

                    client.put("oauth_client",oauth_clientarry);


                    clientArray.put(client);

                    mybullet.put("client",clientArray);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }


        try {

            // Writing to a file
            FileWriter file1 = new FileWriter(file);
            file1.write(mybullet.toString());
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
        }

    }
}
