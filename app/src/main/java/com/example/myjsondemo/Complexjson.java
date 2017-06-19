package com.example.myjsondemo;

/**
 * Created by peacock on 3/21/16.
 */
public class Complexjson {
    private String projectid, projnumber, name;
    private  String mobilesdk_app_id, client_id, client_type, package_name;
    private String package_name1, client_id1, client_type1, certificate_hash;
    private String client_id3, client_type3;
    private String status, status1, status2, status3, status4, apns_config, other_platform_oauth_client;
    private  String client_info, artifect;


    public Complexjson(String projectid, String projnumber, String name,
                       String mobilesdk_app_id, String client_id, String client_type, String package_name,
                       String package_name1, String client_id1, String client_type1, String certificate_hash,
                       String client_id3, String client_type3,
                       String status, String status1, String status2, String status3, String status4,
                       String artifect) {
        this.projectid = projectid;
        this.projnumber = projnumber;
        this.name = name;
        this.mobilesdk_app_id = mobilesdk_app_id;
        this.client_id = client_id;
        this.client_type = client_type;
        this.package_name = package_name;
        this.package_name1=package_name1;
        this.client_id1=client_id1;
        this.client_type1=client_type1;
        this.certificate_hash=certificate_hash;
        this.client_id3=client_id3;
        this.client_type3=client_type3;
        this.status=status;
        this.status1=status1;
        this.status2=status2;
        this.status3=status3;
        this.status=status4;
        this.status1=status;
        this.artifect=artifect;

    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getProjnumber() {
        return projnumber;
    }

    public void setProjnumber(String projnumber) {
        this.projnumber = projnumber;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getMobilesdk_app_id() {
        return mobilesdk_app_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_type() {
        return client_type;
    }

    public String getPackage_name() {
        return package_name;
    }

    public String getPackage_name1() {
        return package_name1;
    }

    public String getClient_id1() {
        return client_id1;
    }

    public String getClient_type1() {
        return client_type1;
    }

    public String getCertificate_hash() {
        return certificate_hash;
    }

    public String getClient_id3() {
        return client_id3;
    }

    public String getClient_type3() {
        return client_type3;
    }

    public String getStatus() {
        return status;
    }

    public String getStatus1() {
        return status1;
    }

    public String getStatus2() {
        return status2;
    }

    public String getStatus3() {
        return status3;
    }

    public String getStatus4() {
        return status4;
    }

    public String getApns_config() {
        return apns_config;
    }

    public String getOther_platform_oauth_client() {
        return other_platform_oauth_client;
    }

    public String getClient_info() {
        return client_info;
    }

    public String getArtifect() {
        return artifect;
    }
}
