package com.impleco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.impleco.model.Category;
import com.impleco.model.Deposit;
import com.impleco.model.Kassen;
import com.impleco.model.Payment;
import com.impleco.model.Transaction;

import java.util.List;
import java.util.Map;

@RestController
public class Controller {
    @Autowired
    private HaushaltService haushaltService;
   @RequestMapping("/payment")
    public List<Payment> payment(){
        return haushaltService.getAllPayments();
    }
    @RequestMapping("/deposit")
    public Map<String, String> getDeposit(){
       return haushaltService.getDepositMap();
    }
    @RequestMapping(method=RequestMethod.POST, value="/payments")
    public void addPayment(@RequestBody Payment payment) {
    	 haushaltService.addPayment(payment);
    }
    @RequestMapping("/category")
    public List<Category> getcategory() {
    	return haushaltService.getcategory();
    }
    @RequestMapping("/kassen")
    public Kassen getKassen(@RequestParam int month, @RequestParam int year) {
    	return haushaltService.getKassen(month, year);
    }

}
