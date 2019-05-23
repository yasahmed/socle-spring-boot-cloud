package com.socle.carte.domains;

import io.swagger.annotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cartes")
@ApiModel(description = "All details about Card. ")
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "num_card", nullable = false)
    private String numCard;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "plafond", nullable = false)
    private Long plafond;


    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Carte [id=" + id + ", num=" + numCard + ", type=" + type + ", plafond=" + plafond
                + "]";
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumCard() {
        return numCard;
    }

    public void setNumCard(String numCard) {
        this.numCard = numCard;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPlafond() {
        return plafond;
    }

    public void setPlafond(Long plafond) {
        this.plafond = plafond;
    }
}
