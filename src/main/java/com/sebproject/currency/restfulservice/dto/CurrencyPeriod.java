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

    @Column(name = "date")
    private String date;



    public CurrencyPeriod() {
    }

    public CurrencyPeriod(String name, String value, String date) {
        this.name = name;
        this.value = value;
        this.date = date;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
