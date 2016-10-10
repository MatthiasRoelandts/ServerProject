package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by matth on 10/10/2016.
 */
public class OrderHasMenuitemEntityPK implements Serializable {
    private int orderId;
    private int makerId;
    private int menuItemId;

    @Column(name = "order_id")
    @Id
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Column(name = "maker_id")
    @Id
    public int getMakerId() {
        return makerId;
    }

    public void setMakerId(int makerId) {
        this.makerId = makerId;
    }

    @Column(name = "menu_item_id")
    @Id
    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderHasMenuitemEntityPK that = (OrderHasMenuitemEntityPK) o;

        if (orderId != that.orderId) return false;
        if (makerId != that.makerId) return false;
        if (menuItemId != that.menuItemId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + makerId;
        result = 31 * result + menuItemId;
        return result;
    }
}
