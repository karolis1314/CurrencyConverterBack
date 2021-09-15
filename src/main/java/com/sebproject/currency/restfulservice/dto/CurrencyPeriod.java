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
    private String range;

    public CurrencyPeriod() {
    }

    public CurrencyPeriod(String name, String range) {
        this.name = name;
        this.range = range;
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

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "CurrencyPeriod{" +
                "name='" + name + '\'' +
                ", range='" + range + '\'' +
                '}';
    }
}
