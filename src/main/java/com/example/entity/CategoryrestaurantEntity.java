package com.example.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

/**
 * Created by matth on 10/10/2016.
 */
@Entity
@Table(name = "categoryrestaurant", schema = "mydb")
public class CategoryrestaurantEntity {
    private int id;
    private String name;
    private boolean tables;
    private boolean reservations;
    private boolean personnel;
    private boolean kitchen;
    private List<RestaurantEntity> businesses;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    @Column(name = "personnel",columnDefinition = "BIT")
    public boolean isPersonnel() {
        return personnel;
    }

    public void setPersonnel(boolean personnel) {
        this.personnel = personnel;
    }


    @Column(name = "kitchen",columnDefinition = "BIT")
    public boolean isKitchen() {
        return kitchen;
    }

    public void setKitchen(boolean kitchen) {
        this.kitchen = kitchen;
    }

    @Basic
    @Column(name = "reservations",columnDefinition = "BIT")
    public boolean isReservations() {
        return reservations;
    }

    public void setReservations(boolean reservations) {
        this.reservations = reservations;
    }

    @Basic
    @Column(name = "tables",columnDefinition = "BIT")
    public boolean isTables() {
        return tables;
    }

    public void setTables(boolean tables) {
        this.tables = tables;
    }

    @OneToMany
    @JoinColumn(name="category_restaurant_id", referencedColumnName="id")
    public List<RestaurantEntity> getBusinessCategories(){
        return businesses;
    }

    public void setBusinessCategories(List<RestaurantEntity> businesses){

        this.businesses = businesses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryrestaurantEntity that = (CategoryrestaurantEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
