package com.impleco.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Transaction {

    private String date;
    private List<Category> paymentTransactionList = new ArrayList<>();
    public Map<String ,Object> deposits = new LinkedHashMap<>();
    

    public Transaction() {
    	
    }
    public Transaction(String date) {
        this.date = date;
        
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
	public List<Category> getpaymentTransactionList() {
		return paymentTransactionList;
	}
	public void setpaymentTransactionList(List<Category> paymentTransactionList) {
		this.paymentTransactionList = paymentTransactionList;
	}
	public Map<String, Object> getDeposits() {
		return deposits;
	}
	public void setDeposits(Map<String, Object> deposits) {
		this.deposits = deposits;
	}

	
	
}
