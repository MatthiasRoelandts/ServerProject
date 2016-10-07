package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by matth on 7/10/2016.
 */
public class MenuitemEntityPK implements Serializable {
    private int id;
    private int itemCategoryId;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "ItemCategory_id")
    @Id
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

        MenuitemEntityPK that = (MenuitemEntityPK) o;

        if (id != that.id) return false;
        if (itemCategoryId != that.itemCategoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + itemCategoryId;
        return result;
    }
}
