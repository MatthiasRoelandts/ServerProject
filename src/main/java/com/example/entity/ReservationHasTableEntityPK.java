package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by matth on 10/10/2016.
 */
public class ReservationHasTableEntityPK implements Serializable {
    private int reservationId;
    private int tableId;

    @Column(name = "reservation_id")
    @Id
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    @Column(name = "table_id")
    @Id
    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationHasTableEntityPK that = (ReservationHasTableEntityPK) o;

        if (reservationId != that.reservationId) return false;
        if (tableId != that.tableId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reservationId;
        result = 31 * result + tableId;
        return result;
    }
}
