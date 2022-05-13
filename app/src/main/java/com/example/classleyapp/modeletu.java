package com.example.classleyapp;

public class modeletu
{
    String name ,codeApogee,Email_institutionnel,surl;

    public modeletu()
    {

    }
    public modeletu(String name, String codeApogee, String email_institutionnel, String surl) {
        this.name = name;
        this.codeApogee = codeApogee;
        Email_institutionnel = email_institutionnel;
        this.surl =surl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeApogee() {
        return codeApogee;
    }

    public void setCodeApogee(String codeApogee) {
        this.codeApogee = codeApogee;
    }

    public String getEmail_institutionnel() {
        return Email_institutionnel;
    }

    public void setEmail_institutionnel(String email_institutionnel) {
        Email_institutionnel = email_institutionnel;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }
}
