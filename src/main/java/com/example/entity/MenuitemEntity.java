package com.example.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by matth on 10/10/2016.
 */
@Entity
@NamedQuery(name = "findByItemCategoryId", query = "SELECT e FROM MenuitemEntity e WHERE e.itemCategoryId = ?1")
@Table(name = "menuitem", schema = "mydb")
@IdClass(MenuitemEntityPK.class)
public class MenuitemEntity {
    private int id;
    private String title;
    private String description;
    private double price;
    private Integer btw;
    private Time avrtime;
    private int itemCategoryId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "btw")
    public Integer getBtw() {
        return btw;
    }

    public void setBtw(Integer btw) {
        this.btw = btw;
    }

    @Basic
    @Column(name = "avrtime")
    public Time getAvrtime() {
        return avrtime;
    }

    public void setAvrtime(Time avrtime) {
        this.avrtime = avrtime;
    }

    @Id
    @Column(name = "item_category_id")
    public int getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(int itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuitemEntity that = (MenuitemEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (itemCategoryId != that.itemCategoryId) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (btw != null ? !btw.equals(that.btw) : that.btw != null) return false;
        if (avrtime != null ? !avrtime.equals(that.avrtime) : that.avrtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (btw != null ? btw.hashCode() : 0);
        result = 31 * result + (avrtime != null ? avrtime.hashCode() : 0);
        result = 31 * result + itemCategoryId;
        return result;
    }
}
