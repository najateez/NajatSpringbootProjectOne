package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Services.JasperReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class JasperReportController {

    @Autowired
    JasperReportService jasperReportService;

    //created .jrxml file -> StudentDTO -> Service -> Controller.
    //will create report in this location as pdf file. C:\Users\Acer\intellijIdea-workspace\NajatSpringbootProjectOne\Reports
    //localhost:8080/jasper/getAllDataFromStudentandSchoolTableindbQuestion1
    //Jasper report: (School name, student name, roll number).
    //it will not create these columns name full record details from db as list, just will print as list student name and roll number which has foreign key with that school name.
    @RequestMapping(value="jasper/getAllDataFromStudentandSchoolTableindbQuestion1", method = RequestMethod.GET)
    public void generateStudentWithSchoolJasperReport() throws Exception{
        jasperReportService.generateStudentWithSchoolJasperReport();
    }

    //Jasper report: (Course name, obtainedMarks, grade).
    //localhost:8080/jasper/getAllDataFromMarkandCourseTableindbQuestion2
    //it will not create these columns name full record details from db as list, just will print as list grade and obtainedMarks which has foreign key with that course name.
    @RequestMapping(value="jasper/getAllDataFromMarkandCourseTableindbQuestion2", method = RequestMethod.GET)
    public void generateMarkWithCourseJasperReportQuestion2() throws Exception {
        jasperReportService.generateMarkWithCourseJasperReportQuestion2();
    }

    //Jasper report: (Course name, average marks (obtainedMarks)).
    //localhost:8080/jasper/getAllDataFromMarkandCourseTableindbQuestion3
    //it will not create these columns name full record details from db as list, just will print as list each course name from db, and its average mark. average mark (obtainedMarks) which has foreign key with that course name.
    @RequestMapping(value="jasper/getAllDataFromMarkandCourseTableindbQuestion3", method = RequestMethod.GET)
    public void generateMarkWithCourseJasperReport2Question3() throws Exception {
        jasperReportService.generateMarkWithCourseJasperReport2Question3();
    }

    //Jasper report: (School name, total number of students in each school).
    //localhost:8080/jasper/generateStudentReportQ6
    //it will not create these columns name full record details from db as list, just will print as list will count No.of students which are in that school.
    @RequestMapping(value="jasper/generateStudentReportQ6", method = RequestMethod.GET)
    public void generateStudentReportQ6() throws Exception {
        jasperReportService.generateStudentReportQ6();
    }

    //Jasper report: (Course name, count of marks for each grade (Count grade)).
    //localhost:8080/jasper/generateMarkWithCourseReportQ7
    @RequestMapping(value="jasper/generateMarkWithCourseReportQ7", method = RequestMethod.GET)
    public void generateMarkWithCourseJasperReportQuestion7() throws Exception {
        jasperReportService.generateMarkWithCourseJasperReportQuestion7();
    }

    //Jasper report: Top-performing students (School name, student name, based on their marks (add Total sum of his obtainedMarks of courses)).
    //localhost:8080/jasper/generateTopPerformingStudentReportQuestion4
    @RequestMapping(value="jasper/generateTopPerformingStudentReportQuestion4", method = RequestMethod.GET)
    public void generateTopPerformingStudentReportQuestion4() throws Exception {
        jasperReportService.generateTopPerformingStudentReportQuestion4();
    }

    @RequestMapping(value="jasper/generateStudentPerformanceReportQuestion5", method = RequestMethod.GET)
    public void generateStudentPerformanceReportQuestion5() throws Exception {
        jasperReportService.generateStudentPerformanceReportQuestion5();
    }

  /*  @RequestMapping(value="jasper/generateTopPerformingCourseReportQuestion8", method = RequestMethod.GET)
    public void generateTopPerformingCourseReportQuestion8() throws Exception {
        jasperReportService.generateTopPerformingCourseReportQuestion8();
    } */


}
