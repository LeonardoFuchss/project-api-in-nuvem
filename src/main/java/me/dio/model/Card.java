package me.dio.model;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.handler.NoUnboundElementsBindHandler;

@Entity(name = "tb_card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    @Column(name = "tb_limit_card", precision = 13, scale = 2)
    private Number limit;

    public Card(Integer id, String number, Number limit) {
        this.id = id;
        this.number = number;
        this.limit = limit;
    }

    public Card() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Number getLimit() {
        return limit;
    }

    public void setLimit(Float limit) {
        this.limit = limit;
    }
}
