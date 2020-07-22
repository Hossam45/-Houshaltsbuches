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


import java.util.List;


@RestController
public class Controller {
    @Autowired
    private HaushaltService haushaltService;
   @RequestMapping("/payments")
    public List<Payment> payment(){
        return haushaltService.getAllPayments();
    }
   @RequestMapping("/deposits")
   public List<Deposit> deposit(){
       return haushaltService.getAllDeposits();
   }
   
    @RequestMapping(method=RequestMethod.POST, value="/payment")
    public void addPayment(@RequestBody Payment payment) {
    	 haushaltService.addPayment(payment);
    }
    @RequestMapping(method=RequestMethod.POST, value="/deposit")
    public void addDeposit(@RequestBody Deposit deposit) {
    	 haushaltService.addDeposit(deposit);
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
