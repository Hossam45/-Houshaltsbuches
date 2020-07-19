package com.impleco.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Transaction {

    private String date;
    private Map<String, String> paymentMap = new LinkedHashMap<String, String>();
    public List<Deposit> deposits = new ArrayList<Deposit>();
    

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

	public List<Deposit> getDeposits() {
		return deposits;
	}

	public void setDeposits(List<Deposit> deposits) {
		this.deposits = deposits;
	}

	public Map<String, String> getPaymentMap() {
		return paymentMap;
	}

	public void setPaymentMap(Map<String, String> paymentMap) {
		this.paymentMap = paymentMap;
	}

	

    

   
}
