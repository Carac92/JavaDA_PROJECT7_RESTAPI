package com.nnk.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "bidlist")
public class BidList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bidListId", nullable = false)
    private Integer id;
    @NotNull
    @NotBlank(message = "Account is mandatory")
    private String account;
    @NotNull
    @NotBlank(message = "Type is mandatory")
    private String type;
    private Double bidQuantity;
    private Double askQuantity;
    private Double bid;
    private Double ask;
    private String benchmark;
    private Timestamp bidListDate;
    private String commentary;
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

    public BidList() {
    }
    public BidList (String account, String type, Double bidQuantity){
        this.account = account;
        this.type = type;
        this.bidQuantity = bidQuantity;
    }
}
