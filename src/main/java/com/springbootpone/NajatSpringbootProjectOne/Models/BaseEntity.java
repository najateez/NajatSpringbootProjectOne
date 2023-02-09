package com.springbootpone.NajatSpringbootProjectOne.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class BaseEntity {

/*  This class we will not using it now.. this just if there is common properties for all classes, we can write in that
class extends BaseEntity.  instead of writing same properties in all classes , and already common.

 */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Date createdDate;
    Date updateDate;

}
