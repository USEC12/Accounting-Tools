package com.example.AccountingTools.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;



@Entity
@Data
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Unit is mandatory")
    private String unit;

    private String article;

    private String description;

    private BigDecimal defaultSellingPrice;

    private Integer initialStockQuantity;

}
