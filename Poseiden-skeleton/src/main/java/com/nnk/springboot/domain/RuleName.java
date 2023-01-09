package com.nnk.springboot.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "rule_name")
public class RuleName {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String description;
    private String json;
    private String template;
    private String sqlStr;
    private String sqlPart;

    public RuleName() {
    }
    public RuleName(String ruleName, String description, String json, String template, String sql, String sqlPart) {
        this.name = ruleName;
        this.description = description;
        this.json = json;
        this.template = template;
        this.sqlStr = sql;
        this.sqlPart = sqlPart;
    }
// TODO: Map columns in data table RULENAME with corresponding java fields
}
