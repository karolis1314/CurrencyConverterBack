package com.sebproject.currency.restfulservice.dto;

import javax.persistence.*;

@Entity
@Table(name = "PERIOD")
public class CurrencyPeriod {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    public CurrencyPeriod() {
    }

    public CurrencyPeriod(String name, String value) {
        this.name = name;
        this.value = value;
    }
    public void setId(Long id) {
        this.id = id;
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
        return "CurrencyPeriod{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
