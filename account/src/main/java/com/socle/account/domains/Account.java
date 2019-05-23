package com.socle.account.domains;

import io.swagger.annotations.ApiModel;

import javax.persistence.Column;
        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;
        import javax.persistence.Table;
@Entity
@Table(name = "accounts")
@ApiModel(description = "All details about the accounts. ")
public class Account {
    private long id;
    private String number;
    private String type;

    public Account() {
    }
    public Account(String number, String type) {
        this.number = number;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "number", nullable = false)
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", numberaccount=" + number + ", type=" + type + "]";
    }
}