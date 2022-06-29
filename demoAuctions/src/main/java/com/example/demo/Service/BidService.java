package com.example.demo.Service;

import com.example.demo.Model.Lot;
import com.example.demo.Repository.LotRepository;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BidService {
    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Lot> getAllBids(String username){
        List<Lot> lots = new ArrayList<>();
        lotRepository.findByBuyerUsername(username)
                .forEach(lots::add);
        return lots;
    }

    public void addBid(Lot lot, String username, double amount) {

        Lot tempLot = lotRepository.findById(lot.getId());
        User user = userRepository.findOne(username);
        if(user.getPenalty()==0 && tempLot.getPrice()< amount ) {
            tempLot.setPrice(amount);
            lot.setSeller(lotRepository.findById(lot.getId()).getSeller());
            lot.setBuyer(new User(username,"", "", "", "",100, 0));
            lotRepository.save(lot);
        }

    }

    public Lot  getBid(String id){

        return lotRepository.findOne(id);
    }

    public void updateBid(Lot lot,  double amount) {

        Lot tempLot = lotRepository.findById(lot.getId());
        if(tempLot.getPrice()< amount ) {
            tempLot.setPrice(amount);
            lot.setSeller(tempLot.getSeller());
            lot.setBuyer(tempLot.getBuyer());
            lotRepository.save(lot);
        }
    }



}
