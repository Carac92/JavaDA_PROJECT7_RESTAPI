package com.nnk.springboot.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Entity
@Data
@Table(name= "trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull
    @NotBlank(message = "Account is mandatory")
    private String account;
    @NotNull
    @NotBlank(message = "Type is mandatory")
    private String type;
    private Double buyQuantity;
    private Double sellQuantity;
    private Double buyPrice;
    private Double sellPrice;
    private String benchmark;
    private Timestamp tradeDate;
    private String security;
    private String status;
    private String trader;
    private String book;
    private String creationName;
    private Timestamp creationDate;
    private String revisionName;
    private Timestamp revisionDate;
    private String dealName;
    private String dealType;
    private String sourceListId;
    private String side;

    public Trade() {
    }
    public Trade(String tradeAccount, String type) {
        this.account = tradeAccount;
        this.type = type;
    }
// TODO: Map columns in data table TRADE with corresponding java fields
}
