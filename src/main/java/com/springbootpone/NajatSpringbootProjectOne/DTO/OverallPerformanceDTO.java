package com.springbootpone.NajatSpringbootProjectOne.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class OverallPerformanceDTO {

    //for question 10:
    //for DTO no need to add access modifier
     String schoolName;
     Double averageMark;

    public OverallPerformanceDTO(String schoolName, Double averageMark) {
        this.schoolName = schoolName;
        this.averageMark = averageMark;
    }
}
