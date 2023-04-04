package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Services.MarkWithCourseReportService;
import com.springbootpone.NajatSpringbootProjectOne.Services.StudentService;
import com.springbootpone.NajatSpringbootProjectOne.Services.StudentWithSchoolReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
public class JasperReportController {

    @Autowired
    StudentWithSchoolReportService studentWithSchoolReportService;
    @Autowired
    MarkWithCourseReportService markWithCourseReportService;

    @RequestMapping(value="jasper/getAllDataFromStudentandSchoolTableindb", method = RequestMethod.GET)
    public void generateStudentWithSchoolJasperReport() throws Exception{
         studentWithSchoolReportService.generateStudentWithSchoolJasperReport();
    }

    @RequestMapping(value="jasper/getAllDataFromMarkandCourseTableindb", method = RequestMethod.GET)
    public void generateMarkWithCourseJasperReport() throws Exception {
        markWithCourseReportService.generateMarkWithCourseJasperReport();
    }
}
