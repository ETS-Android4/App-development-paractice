package com.example.myapplication.RecyclerViewExample;

public class Mobiles {
    private String Name, Company, Price;

    public Mobiles(String name, String company, String price) {
        Name = name;
        Company = company;
        Price = price;
    }

    Mobiles(){
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
