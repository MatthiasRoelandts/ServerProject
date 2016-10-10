package com.example.entity;

import javax.persistence.*;

/**
 * Created by matth on 10/10/2016.
 */
@Entity
@Table(name = "order_has_menuitem", schema = "mydb", catalog = "")
@IdClass(OrderHasMenuitemEntityPK.class)
public class OrderHasMenuitemEntity {
    private int orderId;
    private int makerId;
    private int menuItemId;
    private String remark;
    private String payed;
    private String done;
    private Integer amount;

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "maker_id")
    public int getMakerId() {
        return makerId;
    }

    public void setMakerId(int makerId) {
        this.makerId = makerId;
    }

    @Id
    @Column(name = "menu_item_id")
    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "payed")
    public String getPayed() {
        return payed;
    }

    public void setPayed(String payed) {
        this.payed = payed;
    }

    @Basic
    @Column(name = "done")
    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    @Basic
    @Column(name = "amount")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderHasMenuitemEntity that = (OrderHasMenuitemEntity) o;

        if (orderId != that.orderId) return false;
        if (makerId != that.makerId) return false;
        if (menuItemId != that.menuItemId) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (payed != null ? !payed.equals(that.payed) : that.payed != null) return false;
        if (done != null ? !done.equals(that.done) : that.done != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + makerId;
        result = 31 * result + menuItemId;
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (payed != null ? payed.hashCode() : 0);
        result = 31 * result + (done != null ? done.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
