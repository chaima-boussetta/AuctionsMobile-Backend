package com.example.demo.Controller;

import com.example.demo.Model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Service.PurchaseService;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;


    @RequestMapping("/users/{username}/purchases")
    public List<Purchase> getBuyerPurchases(@PathVariable String username){
        return  purchaseService.getBuyerPurchases(username);
    }

    @RequestMapping("/users/{username}/sales")
    public List<Purchase> getSellerPurchases(@PathVariable String username){
        return  purchaseService.getSellerPurchases(username);
    }

    @RequestMapping(method= RequestMethod.PUT, value = "/users/{username}/purchases/{idPurchases}/payment")
    public void paymentPurchase(@PathVariable String username,@PathVariable String idPurchases ){
        purchaseService.paymentPurchase(username,idPurchases);
    }










}
