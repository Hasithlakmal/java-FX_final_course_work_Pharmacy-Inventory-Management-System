package edu.icet.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Order {

    private String bill_No;
    private LocalDate date;
    private double netTotalPrice;

}
