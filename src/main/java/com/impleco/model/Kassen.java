package com.impleco.model;

public class Kassen {
	
	private double kassenbestand;
	private Transaction transaction;
	
	
	public Kassen() {
		super();
	}

	public Kassen(double kassenbestand, Transaction transaction) {
		this.kassenbestand = kassenbestand;
		this.transaction = transaction;
	}
	
	public Kassen(double kassenbestand) {
		this.kassenbestand = kassenbestand;
	}
	public double getKassenbestand() {
		return kassenbestand;
	}
	public void setKassenbestand(double kassenbestand) {
		this.kassenbestand = kassenbestand;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	
	
	
	

}
