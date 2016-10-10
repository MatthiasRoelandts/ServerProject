package com.example.entity;

import javax.persistence.*;

/**
 * Created by matth on 10/10/2016.
 */
@Entity
@Table(name = "reservation_has_table", schema = "mydb", catalog = "")
@IdClass(ReservationHasTableEntityPK.class)
public class ReservationHasTableEntity {
    private int reservationId;
    private int tableId;

    @Id
    @Column(name = "reservation_id")
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    @Id
    @Column(name = "table_id")
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

        ReservationHasTableEntity that = (ReservationHasTableEntity) o;

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
