package com.example.entity;

import javax.persistence.*;

/**
 * Created by matth on 7/10/2016.
 */
@Entity
@Table(name = "restaurant", schema = "mydb", catalog = "")
@IdClass(RestaurantEntityPK.class)
public class RestaurantEntity {
    private int id;
    private String name;
    private String info;
    private String address;
    private String city;
    private Integer postal;
    private Integer rating;
    private int categoryRestaurantId;
    private int ownerId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "postal")
    public Integer getPostal() {
        return postal;
    }

    public void setPostal(Integer postal) {
        this.postal = postal;
    }

    @Basic
    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Id
    @Column(name = "categoryRestaurantId")
    public int getCategoryRestaurantId() {
        return categoryRestaurantId;
    }

    public void setCategoryRestaurantId(int categoryRestaurantId) {
        this.categoryRestaurantId = categoryRestaurantId;
    }

    @Id
    @Column(name = "ownerId")
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantEntity that = (RestaurantEntity) o;

        if (id != that.id) return false;
        if (categoryRestaurantId != that.categoryRestaurantId) return false;
        if (ownerId != that.ownerId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (info != null ? !info.equals(that.info) : that.info != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (postal != null ? !postal.equals(that.postal) : that.postal != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (postal != null ? postal.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + categoryRestaurantId;
        result = 31 * result + ownerId;
        return result;
    }
}
