package com.example.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by matth on 7/10/2016.
 */
@Entity
@Table(name = "order", schema = "mydb", catalog = "")
@IdClass(OrderEntityPK.class)
public class OrderEntity {
    private int id;
    private byte done;
    private byte payed;
    private Timestamp time;
    private int userId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "done")
    public byte getDone() {
        return done;
    }

    public void setDone(byte done) {
        this.done = done;
    }

    @Basic
    @Column(name = "payed")
    public byte getPayed() {
        return payed;
    }

    public void setPayed(byte payed) {
        this.payed = payed;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Id
    @Column(name = "User_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (id != that.id) return false;
        if (done != that.done) return false;
        if (payed != that.payed) return false;
        if (userId != that.userId) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) done;
        result = 31 * result + (int) payed;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
