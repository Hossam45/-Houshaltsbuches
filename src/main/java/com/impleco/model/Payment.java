package com.impleco.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.util.StringUtils;


public class Payment {
	

    private String type ;
    private double amount;
    private String categoryname;
    private String memo;
    private String date = initialDate() ;

    public Payment(){}
    public Payment(String type, double amount, String categoryname,String memo, String date ) {
        this.type = type;
        this.amount = amount;
        this.categoryname = categoryname;
        this.memo = memo;
        this.setDate(date);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getDate() { return date; }

    
    public void setDate(String date) {
    	if(StringUtils.isEmpty(date)) {
    		date = initialDate();
    	}
        this.date = date;
    }
    public String initialDate() {
        DateFormat df = new SimpleDateFormat("dd.MM.YYYY");
        return df.format(new Date());
    }
}
