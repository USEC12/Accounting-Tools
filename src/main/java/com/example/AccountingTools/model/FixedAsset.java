package com.example.AccountingTools.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fixed_assets")
public class FixedAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "service_life_months")
    private Integer serviceLifeMonths;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "accounting_department")
    private String accountingDepartment;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @Column(name = "include_vat")
    private Boolean includeVat;


}