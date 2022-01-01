package com.example.myapplication.FirebaseExample;

public class Fast_Student {
    String Name,URL;

    public Fast_Student() {
    }

    public Fast_Student(String name, String URL) {
        Name = name;
        this.URL = URL;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
