package com.example.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by matth on 10/10/2016.
 */
@Entity
@Table(name = "categoryrestaurant", schema = "mydb", catalog = "")
public class CategoryrestaurantEntity {
    private int id;
    private String name;
    private List<RestaurantEntity> businessCategories;

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

    @OneToMany
    @JoinColumn(name="category_restaurant_id", referencedColumnName="id")
    public List<RestaurantEntity> getBusinessCategories(){
        return businessCategories;
    }
    public void setBusinessCategories(List<RestaurantEntity> businessCategories){

        this.businessCategories = businessCategories;
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
