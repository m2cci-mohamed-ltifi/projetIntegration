/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ltifi
 */
public class PaymentServices {
    private static final String CLIENT_ID="AbZWVtlrh8mcAHmq4_uiWP01wmWBOioaGexu-BbXidQEimtbuAxqQBhCd7MSpexs9uE7M3JX00RLL3wG";
    private static final String CLIENT_SECRET="ECkUo0zfWIQH2rk-A5uD13djkDhpBgbYNDn-tI2KWj6TrjGKua5JkU6EdLCcmvn_wsEEXmdU1PRzNAgn";
    private static final String MODE="sandbox";
    public String authorizePayment(OrderDetail orderDetail){
        Payer payer=getPayerInformation();
        RedirectUrls redirectUrls =getRedirectURLS();
        
        return null;
        
    }
    private List<Transaction> getTransactionInfromation(OrderDetail orderDetail){
        Amount amount =new Amount();
        amount.setCurrency("EUR");
        amount.setTotal(orderDetail.getPrice());
        
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(orderDetail.getProductName());
        
        ItemList itemList =new ItemList();
        List<Item> items = new ArrayList<Item>();
        Item item =new Item();
        item.setCurrency("EUR").setName(orderDetail.getProductName())
                .setPrice(orderDetail.getPrice());
        items.add(item);
        itemList.setItems(items);
        transaction.setItemList(itemList);
        
        List<Transaction> listTransaction =new ArrayList<Transaction>();
        listTransaction.add(transaction);
        
        return listTransaction;
    }
    private RedirectUrls getRedirectURLS (){
        RedirectUrls redirectUrls=new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhose/CyberTheatre/cancel.html");
        redirectUrls.setReturnUrl("http://localhose/CyberTheatre/return.html");
        return redirectUrls;
    }
    private Payer getPayerInformation(){
        Payer payer =new Payer();
        payer.setPaymentMethod("paypal");
        PayerInfo payerInfo=new PayerInfo();
        payerInfo.setFirstName("Ayoub")
                .setLastName("Ltifi")
                .setEmail("ayoub.ltifi1@gmail.com");
        payer.setPayerInfo(payerInfo);
        return payer;
    }
}
