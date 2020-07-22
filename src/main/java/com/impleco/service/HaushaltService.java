package com.impleco.service;


import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.impleco.model.Category;
import com.impleco.model.Deposit;
import com.impleco.model.Kassen;
import com.impleco.model.Payment;
import com.impleco.model.Transaction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author hossam
 *
 */
@Service
public class HaushaltService {
	private List<Payment> payments = new ArrayList<Payment>();
	private List<Deposit> deposits = new ArrayList<Deposit>();
	private static final String[] monthsname = new String[] { "", "Januar", "Februar", "März", "April", "Mai", "Juni",
			"Juli", "August", "September", "Oktober", "November", "Dezember" };
	public List<Payment> getAllPayments() {
		return payments;
	}
	public List<Deposit> getAllDeposits() {
		return deposits;
	}


	public List<Category> getcategory() {
		Set<String> categoryNames = payments.stream().map(Payment::getCategoryname).collect(Collectors.toSet());
		return categoryNames.stream().map(name -> new Category(name, payments.stream()
				.filter(payment -> payment.getCategoryname().equals(name)).mapToDouble(Payment::getAmount).sum()))
				.collect(Collectors.toList());
	}
	private Transaction getTransaction(int month, int year){
		Transaction transaction = new Transaction();

		transaction.setDate(getMonthname(month) + " " + year);
		transaction.setpaymentTransactionList(getCategoryByDate(getSearchDate(month, year)));
		transaction.setDeposits(getDepositByDate(getSearchDate(month, year)));
		

		return transaction;
	}
	public Kassen getKassen(int month, int year) {
		double paymentAmount = payments.stream().mapToDouble(Payment::getAmount).sum();
		double depositAmount = deposits.stream().mapToDouble(Deposit:: getAmount).sum();
		double kassenbestand = depositAmount - paymentAmount;
		return new Kassen(kassenbestand, getTransaction(month, year));

	}

	private List<Category> getCategoryByDate(String date) {
		Set<String> categoryNames = payments.stream().filter(payment -> payment.getDate().contains(date))
				.map(Payment::getCategoryname).collect(Collectors.toSet());
		return categoryNames.stream()
				.map(name -> new Category(name, payments.stream()
						.filter(payment -> payment.getCategoryname().equals(name) && payment.getDate().contains(date))
						.mapToDouble(Payment::getAmount).sum()))
				.collect(Collectors.toList());
	}
	private Map<String, Object> getDepositByDate(String date) {
		DateFormat df = new SimpleDateFormat("dd.MM.YYYY");
		Map<String, Object> mapDeposit = new LinkedHashMap<>();
		if (CollectionUtils.isEmpty(deposits)) {
			mapDeposit.put("date", df.format(new Date()));
			mapDeposit.put("amount", 0.00);
		} else {
			mapDeposit.put("date", deposits.stream().filter(deposit -> deposit.getDate().contains(date)).map(deposit -> deposit.getDate()));
			mapDeposit.put("amount", deposits.stream().filter(deposit -> deposit.getDate().contains(date))
					.mapToDouble(Deposit::getAmount).sum());
		}
		return mapDeposit;
	}
	
	private String getSearchDate(int month, int year) {
		return (month < 10 ? "0" + month : month) + "." + year;
	}

	private String getMonthname(int month){
		if(month >= monthsname.length) {
			return monthsname[1];
		}
		return monthsname[month];
	}

	public void addPayment(Payment payment) {
		if (payment.getDate() == null) {
			String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
			payment.setDate(date);
		}
		payments.add(payment);

	}
	public void addDeposit(Deposit deposit) {
		
		if(deposit.getDate() == null) {
			String date = new SimpleDateFormat().format(new Date());
			deposit.setDate(date);
		}
		deposits.add(deposit);
		
	}


}
