package com.example.entity;

import org.apache.tomcat.jni.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by matth on 10/10/2016.
 */
@Entity
@Table(name = "owner")
@PrimaryKeyJoinColumn(name ="user_id",referencedColumnName = "id")
public class OwnerEntity extends UserEntity{
    private BigDecimal total_earned;

    @OneToMany(mappedBy = "owner")
    private List<RestaurantEntity> businesses;

    @Basic
    @Column(name = "total_earned")
    public BigDecimal getTotal_earned() {
        return total_earned;
    }

    public void setTotal_earned(BigDecimal total_earned) {
        this.total_earned = total_earned;
    }


    public void addBusiness(RestaurantEntity business){
        businesses.add(business);
    }

    public List<RestaurantEntity> getBusinesses(){
        return businesses;
    }

}
