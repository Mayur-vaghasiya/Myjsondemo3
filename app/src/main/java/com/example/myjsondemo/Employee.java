package com.example.myjsondemo;

/**
 * Created by peacock on 5/9/16.
 */
public class Employee {

    private String name;
    private String destination;
    private String pay;
    private String Lanline;
    private String mobile;

    Employee(String name,String destination,String pay,String lanline,String mobile){
        this.name=name;
        this.destination=destination;
        this.pay=pay;
        this.Lanline=lanline;
        this.mobile=mobile;

    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getPay() {
        return pay;
    }

    public void setLanline(String lanline) {
        this.Lanline = lanline;
    }

    public String getLanline() {
        return Lanline;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }
}
