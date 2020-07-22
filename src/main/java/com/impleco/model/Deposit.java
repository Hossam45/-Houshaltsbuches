package com.impleco.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

public class Deposit {
    private String type;
    private double amount;
    private String date = initialDate();

    public Deposit(){}

    public Deposit(String type, double amount, String date){
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
    	if(StringUtils.isEmpty(date)) {
    		date = initialDate();
    	}
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String initialDate() {
        DateFormat df = new SimpleDateFormat("dd.MM.YYYY");
        return df.format(new Date());
    }
}
