package com.example.myapplication.CardViewExample;

public class My_Model {
    public String Name;
    public int total_downloads;
    public int thumbnails;

    public My_Model(){

    }

    public My_Model(String name, int total_downloads, int thumbnails) {
        Name = name;
        this.total_downloads = total_downloads;
        this.thumbnails = thumbnails;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getTotal_downloads() {
        return total_downloads;
    }

    public void setTotal_downloads(int total_downloads) {
        this.total_downloads = total_downloads;
    }

    public int getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(int thumbnails) {
        this.thumbnails = thumbnails;
    }
}
