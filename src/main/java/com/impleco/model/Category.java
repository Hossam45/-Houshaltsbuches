package com.impleco.model;



public class Category {
	
    private String categoryname;
    private double summe;

    public Category(){}
    public Category(String categoryname){
        this.categoryname = categoryname;
    }
    public Category(String categoryname, double summe){
        this.categoryname = categoryname;
        this.summe = summe;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public double getSumme() {
        return summe;
    }

    public void setSumme(double summe) {
        this.summe = summe;
    }
}
