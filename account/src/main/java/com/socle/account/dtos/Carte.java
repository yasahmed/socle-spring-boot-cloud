package com.socle.account.dtos;

public class Carte {

    private long id;
    private String numCard;
    private String type;
    private Long plafond;


    public long getId() {
        return id;
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
