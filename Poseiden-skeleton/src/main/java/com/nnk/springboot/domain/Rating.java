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
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String moodysRating;
    private String sandPRating;
    private String fitchRating;
    private Integer orderNumber;

    public Rating() {
    }
    public Rating(String moodysRating, String sandPRating, String fitchRating, int orderNumber) {
        this.moodysRating = moodysRating;
        this.sandPRating = sandPRating;
        this.fitchRating = fitchRating;
        this.orderNumber = orderNumber;
    }


// TODO: Map columns in data table RATING with corresponding java fields
}
