package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class LotDto {
    private Long id;
    private String name;
    private String topic;
    private String description;
    private double price;
    private String endDate;
    private String sellerUsername;
    private String buyerUsername;


}

