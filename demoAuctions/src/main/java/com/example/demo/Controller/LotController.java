package com.example.demo.Controller;

import com.example.demo.Model.Lot;
import com.example.demo.Model.User;
import com.example.demo.Service.LotService;
import com.example.demo.Service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LotController {



    @Autowired
    private LotService lotService;
    @Autowired
    private SecurityService securityService;

    /*get all lots for one seller*/
    @RequestMapping("/myLots")
    public List<Lot> getAllUserLots(){
        User user = securityService.getAuthenticatedUser();
        return lotService.getAllUserLots(user.getUsername());
    }


    /*get all lots from DB*/
    @RequestMapping("/lots")
    public List<Lot> getAllLots(){
        return lotService.getAllLots();
    }

    /*get all lots from DB in sorted by price*/
    @RequestMapping("/lots/sort")
    public List<Lot> getAllSortedLots(){
        return lotService.getAllSortedLots();
    }



    /*get all lots from DB by topic*/
    @RequestMapping("/lots/{topicName}")
    public List<Lot> getAllLotsByTopic(@PathVariable String topicName){
        return lotService.getAllLotsByTopic(topicName);
    }

    /*get one lot for one seller*/
    @RequestMapping("myLots/{id}")
    public Lot getLot(@PathVariable String id){
        return lotService.getLot(id);
    }


    @RequestMapping(  method= RequestMethod.POST, value = "/ADDLOT")
    public <Lot> com.example.demo.Model.Lot addLot(@RequestBody com.example.demo.Model.Lot lot,@RequestParam("file") MultipartFile file) throws IOException {


        return  lotService.addLot(lot);
    }

    @RequestMapping(method= RequestMethod.PUT, value = "/lots/{id}")
    public void updateLot(@RequestBody Lot lot, @PathVariable String username,@PathVariable String id){
        lot.setSeller(new User(username,"","","", "",100,0));
        lotService.updateLot(lot);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/lots/{name}")
    public void  deleteLot(@PathVariable String name){
        lotService.deleteLot(name);
    }


    @PostMapping("/addP")
    public void saveProduct(//@RequestParam("image") String img,
                              //@RequestParam("name") String name,
                              //@RequestParam("price") double price,
                             // @RequestParam("description") String description,@RequestParam("topic") String topic,@RequestParam("endDate") String endDate,
                              //@RequestParam("seller") User seller)
            @RequestBody Lot lot)

    {

        System.out.println("hello");
         lotService.saveProductToDB(lot.getImg(), lot.getName(),lot.getDescription(), (int) lot.getPrice(),lot.getTopic(),lot.getEndDate());
    }

    @PostMapping("/changePrice")
    public void changePrice(@RequestBody Lot lot)
    {
        lotService.changeProductPrice(lot.getId(), lot.getPrice());

    }
    @GetMapping("/lots/{id}")
    public void deleteProduct(@PathVariable("id") Long id)
    {

        lotService.deleteLotById(id);

    }



}


