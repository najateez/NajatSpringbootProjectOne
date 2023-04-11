package com.springbootpone.NajatSpringbootProjectOne.Services;

import com.springbootpone.NajatSpringbootProjectOne.DTO.StudentDTO;
import com.springbootpone.NajatSpringbootProjectOne.DTO.StudentPerformanceDTO;
import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.MarkRepository;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.SchoolRepository;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentReportService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MarkRepository markRepository;

    public static final String pathToReports = "C:\\Users\\Acer\\intellijIdea-workspace\\NajatSpringbootProjectOne\\Reports";

   public String generateStudentPerformanceReportQuestion5() throws FileNotFoundException, JRException {
       List<Student> studentList = studentRepository.getAllStudents();
        List<StudentPerformanceDTO> studentPerformanceDTOList = new ArrayList<>();  //to store data from db table to (StudentDTO list of jaspersoft list).


       for (Student student : studentList) {
           String studentName = student.getName();
           String rollNumber = student.getRollNumber();
           List<Mark> marks = markRepository.getMarksByCourseId(student.getId());

           double totalObtainedMarks = 0;
           for (Mark mark : marks) {
               totalObtainedMarks += mark.getObtainedMarks();
           }
           double averageMarkOfObtainedMarks = marks.isEmpty() ? 0 : totalObtainedMarks / marks.size();
           StudentPerformanceDTO studentPerformanceDTO = new StudentPerformanceDTO(studentName, rollNumber, averageMarkOfObtainedMarks);
           studentPerformanceDTOList.add(studentPerformanceDTO);
       }


        File file = new File("C:\\Users\\Acer\\intellijIdea-workspace\\NajatSpringbootProjectOne\\src\\main\\resources\\StudentPerformanceReportQuestion5_Jaspersoft.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Najat Tech Mahindra");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\StudentPerformanceReportQuestion5.pdf");
        return "Report generated : " + pathToReports+"\\StudentPerformanceReportQuestion5.pdf";
    }
}
