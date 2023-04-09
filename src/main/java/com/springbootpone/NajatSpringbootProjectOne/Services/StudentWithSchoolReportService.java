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

    public static final String pathToReports = "C:\\Users\\Acer\\Downloads\\Reports";

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
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\StudentWithSchoolJasperReport.pdf");
        return "Report generated : " + pathToReports+"\\StudentWithSchoolJasperReport.pdf";
    }
}
