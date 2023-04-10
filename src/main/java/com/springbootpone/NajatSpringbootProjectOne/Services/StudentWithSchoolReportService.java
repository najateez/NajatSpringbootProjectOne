package com.springbootpone.NajatSpringbootProjectOne.Services;


import com.springbootpone.NajatSpringbootProjectOne.DTO.StudentDTO;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class StudentWithSchoolReportService {

    @Autowired
    StudentRepository studentRepository;

  //  public static final String pathToReports = "C:\\Users\\Acer\\Downloads\\Reports";
    public static final String pathToReports = "C:\\Users\\Acer\\intellijIdea-workspace\\NajatSpringbootProjectOne\\Reports";

    public String generateStudentWithSchoolJasperReport() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudents();  // to take data from db
        List<StudentDTO> studentDTOData = new ArrayList<>();  //to store data from db table to (StudentDTO list of jaspersoft list).

        for(Student s:studentList){
            String schoolName = s.getSchool().getName();
            String studentName = s.getName();
            String rollNumber = s.getRollNumber();
            StudentDTO StudentDTOListObj=new StudentDTO(schoolName,studentName,rollNumber);
            studentDTOData.add(StudentDTOListObj);
        }

        File file = ResourceUtils.getFile("classpath:StrudentWithSchoolReport_Jaspersoft.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentDTOData);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Najat Tech Mahindra");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\StudentWithSchoolJasperReportQuestion1.pdf");
        return "Report generated : " + pathToReports+"\\StudentWithSchoolJasperReportQuestion1.pdf";
    }


    //  public static final String pathToReports = "C:\\Users\\Acer\\Downloads\\Reports";
    public static final String pathToReports2 = "C:\\Users\\Acer\\intellijIdea-workspace\\NajatSpringbootProjectOne\\Reports";

    public String generateStudentReportQ6() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudents();  // to take data from db
   //     List<StudentDTO> studentDTOData = new ArrayList<>();  //to store data from db table to (StudentDTO list of jaspersoft list).

        //should use HashMap,to store and count how many students in each school.
        Map<String, Integer> schoolCountMap = new HashMap<>();

        for(Student s:studentList) {
            String schoolName = s.getSchool().getName();
            schoolCountMap.put(schoolName, schoolCountMap.getOrDefault(schoolName, 0) + 1);
        }

        List<StudentDTO> studentDTOData = new ArrayList<>();  //to store data from db table to (StudentDTO list of jaspersoft list).
        for (String schoolName : schoolCountMap.keySet()) {
            int count = schoolCountMap.get(schoolName);
            StudentDTO studentDTO = new StudentDTO(schoolName, count);
            studentDTOData.add(studentDTO);
        }
      //      StudentDTO StudentDTOListObj=new StudentDTO(schoolName);
      //      studentDTOData.add(StudentDTOListObj);


        File file = ResourceUtils.getFile("classpath:StudentReportQuestion6_Jaspersoft.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentDTOData);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Najat Tech Mahindra");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\StudentReportQuestion6.pdf");
        return "Report generated : " + pathToReports+"\\StudentReportQuestion6.pdf";
    }


}
