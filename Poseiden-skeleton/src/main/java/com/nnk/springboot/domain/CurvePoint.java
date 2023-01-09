package com.nnk.springboot.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Entity
@Data
@Table(name = "curve_point")
public class CurvePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull(message = "must not be null")
    private Integer id;
    private Integer curveId;
    private Timestamp asOfDate;
    private Double term;
    private Double value;
    private Timestamp creationDate;

// TODO: Map columns in data table CURVEPOINT with corresponding java fields

    public CurvePoint(){}
    public CurvePoint(Integer curveId, Double term, Double value){
        this.curveId = curveId;
        this.term = term;
        this.value = value;
    }
}
