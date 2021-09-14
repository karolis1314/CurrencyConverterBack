package com.sebproject.currency.restfulservice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Currency")
public class LastChance {

    @Id
    private String name;

    @Column(name = "value")
    private String value;

    public LastChance() {
    }

    public LastChance(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LastChance{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
