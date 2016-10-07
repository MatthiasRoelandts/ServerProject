package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by matth on 7/10/2016.
 */
public class UserEntityPK implements Serializable {
    private int id;
    private int userRightId;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "userRightId")
    @Id
    public int getUserRightId() {
        return userRightId;
    }

    public void setUserRightId(int userRightId) {
        this.userRightId = userRightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntityPK that = (UserEntityPK) o;

        if (id != that.id) return false;
        if (userRightId != that.userRightId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userRightId;
        return result;
    }
}
