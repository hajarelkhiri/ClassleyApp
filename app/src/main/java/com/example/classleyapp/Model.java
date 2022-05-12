package com.example.classleyapp;
// Pour la gestion de Prof
public class Model {
    String name,course,email,purl;
    String Email_institutionnel,surl;
    int codeApogee;
    Model()
    {

    }
    public Model(String name, String course, String email, String purl) {
        this.name = name;
        this.course = course;
        this.email = email;
        this.purl = purl;
    }

    public Model(String name , int codeApogee, String email_institutionnel, String surl) {
        this.name = name;
        this.codeApogee = codeApogee;
        Email_institutionnel = email_institutionnel;
        this.surl = surl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
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

    public int getCodeApogee() {
        return codeApogee;
    }

    public void setCodeApogee(int codeApogee) {
        this.codeApogee = codeApogee;
    }
}
