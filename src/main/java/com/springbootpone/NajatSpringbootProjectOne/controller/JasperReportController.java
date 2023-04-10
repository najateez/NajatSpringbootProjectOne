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

    //created .jrxml file -> StudentDTO -> Service -> Controller.
    //will create report in this location as pdf file. C:\Users\Acer\intellijIdea-workspace\NajatSpringbootProjectOne\Reports
    //localhost:8080/jasper/getAllDataFromStudentandSchoolTableindbQuestion1
    @RequestMapping(value="jasper/getAllDataFromStudentandSchoolTableindbQuestion1", method = RequestMethod.GET)
    public void generateStudentWithSchoolJasperReport() throws Exception{
         studentWithSchoolReportService.generateStudentWithSchoolJasperReport();
    }

    //localhost:8080/jasper/getAllDataFromMarkandCourseTableindbQuestion2
    @RequestMapping(value="jasper/getAllDataFromMarkandCourseTableindbQuestion2", method = RequestMethod.GET)
    public void generateMarkWithCourseJasperReportQuestion2() throws Exception {
        markWithCourseReportService.generateMarkWithCourseJasperReportQuestion2();
    }

    //localhost:8080/jasper/getAllDataFromMarkandCourseTableindbQuestion3
    @RequestMapping(value="jasper/getAllDataFromMarkandCourseTableindbQuestion3", method = RequestMethod.GET)
    public void generateMarkWithCourseJasperReport2Question3() throws Exception {
        markWithCourseReportService.generateMarkWithCourseJasperReport2Question3();
    }

    @RequestMapping(value="jasper/generateStudentReportQ6", method = RequestMethod.GET)
    public void generateStudentReportQ6() throws Exception {
        studentWithSchoolReportService.generateStudentReportQ6();
    }

    @RequestMapping(value="jasper/generateMarkWithCourseReportQ7", method = RequestMethod.GET)
    public void generateMarkWithCourseJasperReportQuestion7() throws Exception {
        markWithCourseReportService.generateMarkWithCourseJasperReportQuestion7();
    }
}
