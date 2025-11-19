package edu.icet.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Billing_info {

    private String barcode;
    private String name;
    private String brand;
    private LocalDate date;
    private int quantity;
    private double price;


}
