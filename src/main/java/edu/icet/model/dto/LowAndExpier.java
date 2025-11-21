package edu.icet.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class LowAndExpier {

    private String barcode;
    private String name;
    private String brand;
    private  String spmlyer;
    private int quantity;
    private String ExpiyerStatus;
    private String Low_Stock;
    private  String tel_no;

}
