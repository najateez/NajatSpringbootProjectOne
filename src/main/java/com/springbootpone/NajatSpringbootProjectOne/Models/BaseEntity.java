package com.springbootpone.NajatSpringbootProjectOne.Models;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

/*  This class we will not using it now.. this just if there is common properties for all classes, we can write in that
class extends BaseEntity.  instead of writing same properties in all classes , and already common.

 */

 /*   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id; */

    /* put extends in all classes in (package models) as school class, student class, course class,mark class.
     then run program, this properties below will be created in all tables in db as columns.
     */

    @CreatedDate
    Date createdDate;
    @UpdateTimestamp
    Date updatedDate;
    Boolean isActive;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
