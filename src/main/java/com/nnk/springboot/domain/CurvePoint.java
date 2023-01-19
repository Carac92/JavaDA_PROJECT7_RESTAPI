package com.nnk.springboot.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Objects;


/**
 * The Entity Curve point.
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "curve_point")
public class CurvePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Min(value = 1, message = "CurveId must be positive")
    private Integer curveId;
    private Timestamp asOfDate;

    @DecimalMin(value = "0.01", inclusive = false, message = "Term must be positive")
    private Double term;

    @DecimalMin(value = "0.01", inclusive = false, message = "Term must be positive")
    private Double value;
    private Timestamp creationDate;


    public CurvePoint(){}

    public CurvePoint(Integer curveId, Double term, Double value){
        this.curveId = curveId;
        this.term = term;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CurvePoint that = (CurvePoint) o;
        return id != null && Objects.equals(id, that.id);
    }
}
