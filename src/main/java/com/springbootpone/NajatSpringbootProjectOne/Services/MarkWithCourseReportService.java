package com.springbootpone.NajatSpringbootProjectOne.Services;

import com.springbootpone.NajatSpringbootProjectOne.DTO.MarkDTO;
import com.springbootpone.NajatSpringbootProjectOne.DTO.StudentDTO;
import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MarkWithCourseReportService {

    @Autowired
    MarkRepository markRepository;

   // public static final String pathToReports = "C:\\Users\\Acer\\Downloads\\Reports";
   public static final String pathToReports = "C:\\Users\\Acer\\intellijIdea-workspace\\NajatSpringbootProjectOne\\Reports";

    public String generateMarkWithCourseJasperReportQuestion2() throws FileNotFoundException, JRException {
        List<Mark> markList = markRepository.getAllMarks();  // to take data from db
        List<MarkDTO> markDTOData = new ArrayList<>();  //to store data from db table to (StudentDTO list of jaspersoft list).

        for(Mark m:markList){
            String courseName = m.getCourse().getName();
            Integer obtainedMarks = m.getObtainedMarks();
            String grade = m.getGrade();
      //      Double averageMark = m.getObtainedMarks().doubleValue();

            MarkDTO markDTOListObj=new MarkDTO(courseName,obtainedMarks,grade);
            markDTOData.add(markDTOListObj);
        }

        File file = ResourceUtils.getFile("classpath:MarkWithCourseReport_Jaspersoft.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(markDTOData);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Najat Tech Mahindra");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\MarkWithCourseJasperReportQuestion2.pdf");
        return "Report generated : " + pathToReports+"\\MarkWithCourseJasperReportQuestion2.pdf";
    }




  //  public static final String pathToReports2 = "C:\\Users\\Acer\\Downloads\\Reports";
  public static final String pathToReports2 = "C:\\Users\\Acer\\intellijIdea-workspace\\NajatSpringbootProjectOne\\Reports";

    public String generateMarkWithCourseJasperReport2Question3() throws FileNotFoundException, JRException {
        List<Mark> markList = markRepository.getAllMarks();  // to take data from db
        List<MarkDTO> markDTOData = new ArrayList<>();  //to store data from db table to (MarkDTO list of jaspersoft list). with average mark.

        /* to calculate average mark, i will use HashMap. because for each unique course name we will make calculation.
            exp:
            adding ObtainedMarks of each unique course name and divide by its number of rows in database.
         */

        //string for course name, integer for ObtainedMarks
        Map<String, List<Integer>> courseObtainedMarksMap = new HashMap<>();
    //    Map<String, String> gradeMap = new HashMap<>();  // this HashMap grade mush be there, without it it will show error, can not define grade.

        for (Mark m : markList) {
            String courseName = m.getCourse().getName();
            Integer obtainedMarks = m.getObtainedMarks();
            String grade = m.getGrade();
            //   Double averageMark = m.getObtainedMarks().doubleValue();

            if (courseObtainedMarksMap.containsKey(courseName)) {
                courseObtainedMarksMap.get(courseName).add(obtainedMarks);
            } else {
                List<Integer> obtainedMarksList = new ArrayList<>();
                obtainedMarksList.add(obtainedMarks);
                courseObtainedMarksMap.put(courseName, obtainedMarksList);
            }

      //      gradeMap.put(courseName, grade);


        }


        // Loop through the courseObtainedMarksMap and calculate the averageMarks for each courseName
        for (String courseName : courseObtainedMarksMap.keySet()) {
            List<Integer> obtainedMarksList = courseObtainedMarksMap.get(courseName);
            Double sum = 0.0;
            for (Integer obtainedMark : obtainedMarksList) {
                sum += obtainedMark;
            }
            Double averageMark = sum / obtainedMarksList.size();

            MarkDTO markDTOListObj = new MarkDTO(courseName, averageMark);
            markDTOData.add(markDTOListObj);
        }

        File file = ResourceUtils.getFile("classpath:MarkWithCourseReport2Q3_Jaspersoft.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(markDTOData);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Najat Tech Mahindra");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\MarkWithCourseJasperReportQuestion3.pdf");

        return "Report generated : " + pathToReports + "\\MarkWithCourseJasperReportQuestion3.pdf";
    }


    // public static final String pathToReports = "C:\\Users\\Acer\\Downloads\\Reports";
  public static final String pathToReports3 = "C:\\Users\\Acer\\intellijIdea-workspace\\NajatSpringbootProjectOne\\Reports";

    public String generateMarkWithCourseJasperReportQuestion7() throws FileNotFoundException, JRException {
        List<Mark> markList = markRepository.getAllMarks();  // to take data from db
        List<MarkDTO> markDTOData = new ArrayList<>();  //to store data from db table to (StudentDTO list of jaspersoft list).

        Map<String, Integer> gradeCounts = new HashMap<>();

        for(Mark m:markList){
            String courseName = m.getCourse().getName();
            String grade = m.getGrade();

            MarkDTO markDTOListObj = new MarkDTO(courseName, grade, 1);
            if (grade.equals("good")) {
                markDTOListObj.setCountGrade(1);
            } else if (grade.equals("fail")) {
                markDTOListObj.setCountGrade(1);
            }

            boolean found = false;
            for (MarkDTO dto : markDTOData) {
                if (dto.getCourseName().equals(courseName) && dto.getGrade().equals(grade)) {
                    dto.setCountGrade(dto.getCountGrade() + 1);
                    if (grade.equals("good")) {
                        dto.setCountGrade(dto.getCountGrade() + 1);
                    } else if (grade.equals("fail")) {
                        dto.setCountGrade(dto.getCountGrade() + 1);
                    }
                    found = true;
                    break;
                }
            }

        if (!found) {
            markDTOData.add(markDTOListObj);
        }
    }


        File file = ResourceUtils.getFile("classpath:MarkWithCourseReportQuestion7_Jaspersoft.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(markDTOData);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Najat Tech Mahindra");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\MarkWithCourseJasperReportQuestion7.pdf");
        return "Report generated : " + pathToReports+"\\MarkWithCourseJasperReportQuestion7.pdf";
    }



}



