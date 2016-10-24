package com.example.entity;

import javax.persistence.*;

/**
 * Created by matth on 10/10/2016.
 */
@Entity
@NamedQuery(name = "findByRestaurantId", query = "SELECT e FROM ItemcategoryEntity e WHERE e.restaurantId = ?1")
@Table(name = "itemcategory", schema = "mydb")
public class ItemcategoryEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    private String name;

    @Column(name = "restaurant_id")
    private int restaurantId;

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

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurant_id) {
        this.restaurantId = restaurant_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemcategoryEntity that = (ItemcategoryEntity) o;

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
