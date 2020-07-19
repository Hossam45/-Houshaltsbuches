package com.impleco.service;

import org.springframework.stereotype.Service;

import com.impleco.model.Category;
import com.impleco.model.Deposit;
import com.impleco.model.Kassen;
import com.impleco.model.Payment;
import com.impleco.model.Transaction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HaushaltService {
	private Transaction teransaction;
	private List<Payment> payments = new ArrayList<Payment>();
	private List<Category> categorys = new ArrayList<Category>();
	private static final String[] monatsname = new String[]
	{ "", "Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember" };
    
    public List<Payment> getAllPayments(){
    	return payments;
    }
    
    public Map<String ,String> getDepositMap(){
    	Map<String,String> mapDeposit = new LinkedHashMap<String, String>();
    	Deposit deposit = new Deposit();
    	if(payments.size() == 0) {
    		deposit = new Deposit("Einzahlung", 0.00);
    	}else {
    		for(Payment payment : payments) {
    			double amount = deposit.getAmount();
    			amount += payment.getAmount();
    			 deposit = new Deposit("Einzahlung", amount);
    		}
    		String amountString = String.valueOf(deposit.getAmount());
    		mapDeposit.put("type",deposit.getType());
    		mapDeposit.put("amount", amountString);
    		
    	}
    	return mapDeposit;
    }

    
    private String getMonatname(int month) {
    	return monatsname[month];
    }
    
    public List<Category> getcategory(){
    	Set<String> categoryNames= payments.stream().map(Payment::getCategoryname).collect(Collectors.toSet());
    	return categoryNames.stream().map(name -> new Category(
    			name,
				payments.stream().filter(payment -> payment.getCategoryname().equals(name)).mapToDouble(Payment::getAmount).sum())
		).collect(Collectors.toList());
    }
	public void addPayment(Payment payment) {
		if(payment.getDate() == null) {
			String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
			payment.setDate(date);
		}
		payments.add(payment);

	}
	private String dateFormating(String string) {
		DateFormat dateFormat = new SimpleDateFormat();
		String stringDate = dateFormat.format(string);
		return stringDate;
	}
	
	public Kassen getKassen(int month, int year) {
		Deposit deposit = new Deposit();
		double kassenbestand = deposit.getAmount();
		
		Kassen kassen = new Kassen(kassenbestand);
		Transaction transaction = getTransaction(month, year);
		
		kassen.setTransaction(transaction);
		
		return kassen;
		
	}
    
    private Transaction getTransaction(int month, int year) {
    	String yearString = Integer.toString(year); 
    	String date = getMonatname(month) + yearString;
    	Transaction transaction = new Transaction();
    	
    	transaction.setDate(date);
    	transaction.setPaymentMap(getPaymentTransaction(month, year));
    	
    	
    	return transaction;
    }
    private Map<String, String> getPaymentTransaction(int month,int year) {
    	Map<String, String> paymentMap = new LinkedHashMap<String, String>();
    	for(Payment payment: payments) {
    		if(payment.getDate().substring(2,4).equals(Integer.toString(month))) {
    			if(payment.getDate().substring(4).equals(Integer.toString(year))) {
    				paymentMap.put("Category",payment.getCategoryname() );
    				for(Category category: categorys) {
    					if(payment.getCategoryname().equals(category.getCategoryname())) {
    						paymentMap.put("category", category.getCategoryname());
    						paymentMap.put("Amount", String.valueOf(category.getSumme()));
    					}
    				}
    			}
    		}
    	}
    	return paymentMap;
    }
	public void getPayment(String date) {
		for(Payment payment : payments) {
			if(payment.getDate().substring(2).equals(date)) {
//				payment.getCategory();
			}
		}
	}
    
    
	
    
}
