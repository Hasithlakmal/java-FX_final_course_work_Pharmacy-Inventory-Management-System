package edu.icet.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Join_suplyerAndAdditem {

    private String barcode;
    private String name;
    private String brand;
    private LocalDate date;
    private int quantity;
    private double price;
    private double sealing;

    private  String sumlyer;
    private  String tel_no;



}
