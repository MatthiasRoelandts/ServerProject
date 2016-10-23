package com.example.entity;

import org.apache.tomcat.jni.User;
import org.springframework.data.rest.webmvc.BasePathAwareController;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;

/**
 * Created by matth on 10/10/2016.
 */
@Entity
@Table(name = "waiter")
@PrimaryKeyJoinColumn(name ="user_id",referencedColumnName = "id")
public class WaiterEntity extends UserEntity{

    private BigDecimal hourly_salary;
    private Time hours_worked;
    private String address;
    private String city;
    private Integer postal;
    private int restaurant_id;
    private String job_description;


    @Basic
    @Column(name = "hourly_salary")
    public BigDecimal getHourly_salary() {
        return hourly_salary;
    }

    public void setHourly_salary(BigDecimal hourly_salary) {
        this.hourly_salary = hourly_salary;
    }
    @Basic
    @Column(name = "hours_worked")
    public Time getHours_worked() {
        return hours_worked;
    }

    public void setHours_worked(Time hours_worked) {
        this.hours_worked = hours_worked;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "postal")
    public Integer getPostal() {
        return postal;
    }

    public void setPostal(Integer postal) {
        this.postal = postal;
    }

    @Basic
    @Column(name = "job_description")
    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    @Basic
    @Column(name = "restaurant_id")
    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
