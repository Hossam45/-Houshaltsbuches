package com.impleco.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Deposit {
    private String type;
    private double amount;
    private String date;

    public Deposit(){}

    public Deposit(String type, double amount){
        this.type = type;
        this.amount = amount;
        this.setDate(date);
    }

    public String getType() {
        return type;
    }


    public String getDate() {
        return date;
    }
    public void setType(String type) {
    	this.type = type;
    }

    public void setDate(String date) {
            DateFormat df = new SimpleDateFormat("dd.MM.YYYY");
            Date d = Calendar.getInstance().getTime();
            date = df.format(d);
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
