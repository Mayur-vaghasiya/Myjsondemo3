package com.example.myjsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ComplexActivity extends AppCompatActivity {
    ListView lsvemp;
    String projid, projnum, projname, mobileid, clientid, clienttype, packname, clientid1, clienttype1, packagename1, certificatehash1, clientid2, clienttype2, status, status1, status2, status3, status4, artifect;
    //   ArrayList<String> proid = new ArrayList<String>();
    //  ArrayList<String> pronumber = new ArrayList<String>();
    //   ArrayList<String> name = new ArrayList<String>();
    // public JSONObject jsonObject, project_info, jsonobjclient, jsonObject1, oauthclient1, android_client_info, android_info, jsonservices, jsonanalyservice,cloudmessagingservice, appinviteservice, googlesigninservice, adsservice;
    // public JSONArray client, oauthclient;

    ArrayList<Complexjson> getjson = new ArrayList<Complexjson>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex);
        lsvemp = (ListView) findViewById(R.id.listemp);
        try {
            StringBuilder buf = new StringBuilder();
            InputStream json = getAssets().open("mybulettin.Json");

            BufferedReader in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;

            while ((str = in.readLine()) != null) {
                buf.append(str);
            }
            in.close();

            JSONObject jsonObject = new JSONObject(buf.toString());
            {
                {
                    JSONObject project_info = jsonObject.getJSONObject("project_info");

                    projid = project_info.getString("project_id").toString();
                    projnum = project_info.getString("project_number").toString();
                    projname = project_info.getString("name").toString();

                    Log.d("Id ==== ", projid);
                    Log.d("name ==== ", projnum);
                    Log.d("sala ==== ", projname);
                }
                {
                    JSONArray client = jsonObject.getJSONArray("client");
                    {
                        for (int i = 0; i < client.length(); i++) {
                            JSONObject jsonobjclient = client.getJSONObject(i);
                            {
                                JSONObject jsonObject1 = jsonobjclient.getJSONObject("client_info");

                                mobileid = jsonObject1.getString("mobilesdk_app_id").toString();
                                clientid = jsonObject1.getString("client_id").toString();
                                clienttype = jsonObject1.getString("client_type").toString();

                                Log.d("mobileid ==== ", mobileid);
                                Log.d("clientid ==== ", clientid);
                                Log.d("clienttype === ", clienttype);

                                JSONObject android_client_info = jsonObject1.getJSONObject("android_client_info");
                                {
                                    packname = android_client_info.getString("package_name").toString();
                                    Log.d("packname ==== ", packname);
                                }
                            }
                            {
                                JSONArray oauthclient = jsonobjclient.getJSONArray("oauth_client");

                                for (int j = 0; j < oauthclient.length(); j++) {
                                    JSONObject oauthclient1 = oauthclient.getJSONObject(j);

                                    clientid1 = oauthclient1.getString("client_id").toString();
                                    clienttype1 = oauthclient1.getString("client_type").toString();

                                    Log.d("client_id 1 === ", clientid1);
                                    Log.d("client_type 1 === ", clienttype1);


                                    if (oauthclient1.has("android_info")) {
                                        JSONObject android_info = oauthclient1.getJSONObject("android_info");
                                        {
                                            packagename1 = android_info.getString("package_name").toString();
                                            Log.d("packname === ", packagename1);
                                            certificatehash1 = android_info.getString("certificate_hash").toString();
                                            Log.d("certificate_hash === ", certificatehash1);
                                        }
                                    }
                                }
                                clientid2 = clientid1;
                                clienttype2 = clienttype1;
                            }
                            JSONObject jsonservices = jsonobjclient.getJSONObject("services");
                            if (jsonservices.has("analytics_service")) {

                                JSONObject jsonanalyservice = jsonservices.getJSONObject("analytics_service");
                                status = jsonanalyservice.getString("status").toString();
                                Log.d("status === ", status);
                            }
                            if (jsonservices.has("cloud_messaging_service")) ;
                            {
                                JSONObject cloudmessagingservice = jsonservices.getJSONObject("cloud_messaging_service");
                                status1 = cloudmessagingservice.getString("status").toString();
                                String apnsconfig = cloudmessagingservice.getString("apns_config").toString();
                                Log.d("status1 === ", status1);
                                Log.d("apnsconfig === ", apnsconfig);
                            }
                            if (jsonservices.has("appinvite_service")) {
                                JSONObject appinviteservice = jsonservices.getJSONObject("appinvite_service");
                                status2 = appinviteservice.getString("status").toString();
                                String otherplatform = appinviteservice.getString("other_platform_oauth_client").toString();
                                Log.d("status2 === ", status2);
                                Log.d("otherplatform === ", otherplatform);
                            }

                            if (jsonservices.has("google_signin_service")) {
                                JSONObject googlesigninservice = jsonservices.getJSONObject("google_signin_service");
                                status3 = googlesigninservice.getString("status").toString();
                                Log.d("status3 === ", status3);
                            }

                            if (jsonservices.has("ads_service")) {
                                JSONObject adsservice = jsonservices.getJSONObject("ads_service");
                                status4 = adsservice.getString("status").toString();
                                Log.d("status4 === ", status4);
                            }
                        }
                    }
                }
                artifect = jsonObject.getString("ARTIFACT_VERSION");
                Log.d("artifect === ", artifect);
            }
            Complexjson comjson = new Complexjson(projid, projnum, projname,
                    mobileid, clientid, clienttype, packname,
                    clientid1, clienttype1, packagename1, certificatehash1,
                    clientid2, clienttype2,
                    status, status1, status2, status3, status4,
                    artifect);
            getjson.add(comjson);

            Lstadpater adapter = new Lstadpater(ComplexActivity.this, getjson);
            lsvemp.setAdapter(adapter);


        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (JSONException e)
        {
            e.printStackTrace();
        }

    }
}
