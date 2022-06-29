package com.example.demo.Service;

import com.example.demo.Model.Lot;
import com.example.demo.Repository.LotRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LotService<LotRepositry> {

    public void  saveProductToDB(String img, String name, String description
            , int price, String topic, String endDate)
    {
        Lot p = new Lot();
        //String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //if(fileName.contains(".."))
        /*{
            System.out.println("not a a valid file");
        }
        try {
            p.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        p.setImg(img);
        p.setDescription(description);
        p.setName(name);
        p.setPrice(price);
        //p.setSeller(seller);
        p.setTopic(topic);
        p.setEndDate(endDate);

        lotRepository.save(p);
    }
    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Lot> getAllUserLots(String username){

        List<Lot> lots = new ArrayList<>();
        lotRepository.findBySellerUsername(username)
                .forEach(lots::add);
        return lots;

    }
    public Lot addLot(Lot lot) {


        // Check buyer if exist in DB (findByUser(buyer.username))
        //User buyer = userRepository.findByUsername(lotDTO.getBuyerUsername());
        // TODO: if not exist throw not found exception
        // Check seller if exist in DB (findByUser(seller.username))
        //User seller = userRepository.findByUsername(lotDTO.getSellerUsername());
        // TODO: if not exist throw not found exception
        //Lot lot = new Lot(lotDTO.getName(),lotDTO.getPrice(),lotDTO.getTopic(),lotDTO.getDescription(),lotDTO.getEndDate());
         // lotDTO.getImageId();
        //lot.setBuyer(buyer);
        //lot.setSeller((seller));

        return lotRepository.save(lot);
    }


    public List<Lot> getAllLots(){

        List<Lot> lots = new ArrayList<>();
        lotRepository.findAll()
                .forEach(lots::add);
        return lots;

    }


    public List<Lot> getAllSortedLots(){

        List<Lot> lots = new ArrayList<>();
        lotRepository.findAll()
                .forEach(lots::add);
        lots.sort((Lot l1, Lot l2)
                ->
                Double.compare(l1.getPrice(),l2.getPrice())
        );
        return lots;

    }

    public List<Lot> getAllLotsByTopic(String topicName){
        List<Lot> lots = new ArrayList<>();
        lotRepository.findByTopic(topicName)
                .forEach(lots::add);
        return lots;
    }





    public Lot getLot(String id){

        return lotRepository.findOne(id);
    }

    public void addLot(Lot lot, String username) {

        lot.setSeller(userRepository.findByUsername(username));
        lotRepository.save(lot);
    }

    public void updateLot(Lot lot) {

        lot.setBuyer(lotRepository.findById(lot.getId()).getBuyer());
        lotRepository.save(lot);
    }


    public void deleteLot(String name) {
        lotRepository.deleteByName(name);
    }

    public void changeProductPrice(Long id,double price)
    {
        Lot p = new Lot();
        p = lotRepository.findById(id).get();
        p.setPrice(price);
        lotRepository.save(p);
    }

    public void deleteLotById(Long id)
    {
        lotRepository.deleteById(id);
    }
}
