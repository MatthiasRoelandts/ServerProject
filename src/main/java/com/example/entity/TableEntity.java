package com.example.entity;

import javax.persistence.*;

/**
 * Created by matth on 7/10/2016.
 */
@Entity
@Table(name = "table", schema = "mydb", catalog = "")
@IdClass(TableEntityPK.class)
public class TableEntity {
    private int id;
    private Integer amount;
    private String code;
    private Byte available;
    private int restaurantId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "available")
    public Byte getAvailable() {
        return available;
    }

    public void setAvailable(Byte available) {
        this.available = available;
    }

    @Id
    @Column(name = "restaurantId")
    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableEntity that = (TableEntity) o;

        if (id != that.id) return false;
        if (restaurantId != that.restaurantId) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (available != null ? !available.equals(that.available) : that.available != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (available != null ? available.hashCode() : 0);
        result = 31 * result + restaurantId;
        return result;
    }
}
