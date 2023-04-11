package com.springbootpone.NajatSpringbootProjectOne.Services;


import com.springbootpone.NajatSpringbootProjectOne.DTO.StudentDTO;
import com.springbootpone.NajatSpringbootProjectOne.DTO.TopPerformingStudentDTO;
import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.MarkRepository;
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
    @Autowired
    MarkRepository markRepository;

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

    //----------------------------------------------------------------------------------

//Top-Performing Student Report

    /* explaination how i did:
    its all about foreign key from school table to mark table.
    first it will check school table and student table which students in that school. then it will take
    only students which have foreign key with course. then will check that course table and mark table,
    that prevoius student has which course, then will go to mark table, will Sum Total of (ObtainedMarks) of that student
    and show result in ascending order.
     */

    public static final String pathToReports3 = "C:\\Users\\Acer\\intellijIdea-workspace\\NajatSpringbootProjectOne\\Reports";

    public String generateTopPerformingStudentReportQuestion4() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudents();
        List<Mark> markList = markRepository.getAllMarks();

     //   List<TopPerformingStudentDTO> topPerformingStudentDTOList = new ArrayList<>();

        Map<Student, Integer> studentMarks = new HashMap<>();

        // calculate total marks obtained by each student, depend on what student have course.
        for (Mark mark : markList) {
            Integer obtainedMarks = studentMarks.getOrDefault(mark.getCourse().getStudent(), 0);
            obtainedMarks += mark.getObtainedMarks();
            studentMarks.put(mark.getCourse().getStudent(), obtainedMarks);
        }

        // sort the students by obtained marks
        List<Map.Entry<Student, Integer>> sortedList = new ArrayList<>(studentMarks.entrySet());
        sortedList.sort(Map.Entry.comparingByValue());

        // create DTO objects for top-performing students
        List<TopPerformingStudentDTO> topPerformingStudents = new ArrayList<>();
        for (int i = sortedList.size() - 1; i >= 0 && i >= sortedList.size() - 10; i--) {
            Map.Entry<Student, Integer> entry = sortedList.get(i);
            topPerformingStudents.add(new TopPerformingStudentDTO(
                    entry.getKey().getSchool().getName(),
                    entry.getKey().getName(),
                    entry.getValue()));
        }


        File file = ResourceUtils.getFile("classpath:TopPerformingStudentReportQuestion4_Jaspersoft.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(topPerformingStudents);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Najat Tech Mahindra");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\TopPerformingStudentReportQuestion4.pdf");
        return "Report generated : " + pathToReports+"\\TopPerformingStudentReportQuestion4.pdf";
    }




}
