package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by matth on 10/10/2016.
 */
public class RestaurantEntityPK implements Serializable {
    private int id;
    private int categoryRestaurantId;
    private int ownerId;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*@Column(name = "category_restaurant_id")
    @Id
    public int getCategoryRestaurantId() {
        return categoryRestaurantId;
    }

    public void setCategoryRestaurantId(int categoryRestaurantId) {
        this.categoryRestaurantId = categoryRestaurantId;
    }

    */
    /*
    @Column(name = "owner_id")
    @Id
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantEntityPK that = (RestaurantEntityPK) o;

        if (id != that.id) return false;
        //if (categoryRestaurantId != that.categoryRestaurantId) return false;
        if (ownerId != that.ownerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        //result = 31 * result + categoryRestaurantId;
        //result = 31 * result + ownerId;
        return result;
    }
}
