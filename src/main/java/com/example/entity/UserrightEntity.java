package com.example.entity;

import javax.persistence.*;

/**
 * Created by matth on 10/10/2016.
 */
@Entity
@Table(name = "userright", schema = "mydb", catalog = "")
public class UserrightEntity {
    private int id;
    private byte customer;
    private byte basic;
    private byte advanced;
    private byte ultimate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "customer")
    public byte getCustomer() {
        return customer;
    }

    public void setCustomer(byte customer) {
        this.customer = customer;
    }

    @Basic
    @Column(name = "basic")
    public byte getBasic() {
        return basic;
    }

    public void setBasic(byte basic) {
        this.basic = basic;
    }

    @Basic
    @Column(name = "advanced")
    public byte getAdvanced() {
        return advanced;
    }

    public void setAdvanced(byte advanced) {
        this.advanced = advanced;
    }

    @Basic
    @Column(name = "ultimate")
    public byte getUltimate() {
        return ultimate;
    }

    public void setUltimate(byte ultimate) {
        this.ultimate = ultimate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserrightEntity that = (UserrightEntity) o;

        if (id != that.id) return false;
        if (customer != that.customer) return false;
        if (basic != that.basic) return false;
        if (advanced != that.advanced) return false;
        if (ultimate != that.ultimate) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) customer;
        result = 31 * result + (int) basic;
        result = 31 * result + (int) advanced;
        result = 31 * result + (int) ultimate;
        return result;
    }
}
