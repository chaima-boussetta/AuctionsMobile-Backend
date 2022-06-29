package com.example.demo.Model;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    private String topic;
    private String description;
    private String endDate;
    //@Lob
    //@Column(columnDefinition = "MEDIUMBLOB")
    private String img;
    //@ManyToOne
    //private FileDb file;
    @ManyToOne
    private User seller;

    @ManyToOne
    private User buyer;
    public Lot(String name, String topic, String description, double price, String endDate) {
    }

    public Lot(Long id, String name, double price, String topic, String description, String endDate, String img, User seller) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.topic = topic;
        this.description = description;
        this.endDate = endDate;
        this.img = img;
        this.seller = seller;
    }

    public Lot(String name, double price, String topic, String description, String endDate, String img) {
        this.name = name;
        this.price = price;
        this.topic = topic;
        this.description = description;
        this.endDate = endDate;
        this.img = img;
    }

    //public Lot(String name, double price, String topic, String description, String endDate) {
   // }


    public Lot(String name, double price, String topic, String description, String endDate) {
        this.name = name;
        this.price = price;
        this.topic = topic;
        this.description = description;
        this.endDate = endDate;
    }

    public boolean hasBuyer(){
        if(this.buyer!=null)
            return true;
        else return false;
    }

    public Lot(Long id, String name, String topic, String description, double price, String endDate,String img,  User seller, User buyer) {
        this.id = id;
        this.name = name;
        this.topic = topic;
        this.description = description;
        this.price = price;
        this.endDate = endDate;
        this.seller = seller;
        this.buyer = buyer;
        this.img=img;
        //this.file=file;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

    public String getEndDate() {
        return endDate;
    }

    public User getSeller() {
        return seller;
    }

    public User getBuyer() {
        return buyer;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }



    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Lot get() {
        return this;
    }
}
