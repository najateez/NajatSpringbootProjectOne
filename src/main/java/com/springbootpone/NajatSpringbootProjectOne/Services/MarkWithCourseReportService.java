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

    public static final String pathToReports = "C:\\Users\\Acer\\Downloads\\Reports";

    public String generateMarkWithCourseJasperReport() throws FileNotFoundException, JRException {
        List<Mark> markList = markRepository.getAllMarks();  // to take data from db
        List<MarkDTO> markDTOData = new ArrayList<>();  //to store data from db table to (StudentDTO list of jaspersoft list).

        for(Mark m:markList){
            String courseName = m.getCourse().getName();
            Integer obtainedMarks = m.getObtainedMarks();
            String grade = m.getGrade();
            Double averageMark = m.getObtainedMarks().doubleValue();

            MarkDTO markDTOListObj=new MarkDTO(courseName,obtainedMarks,grade,averageMark);
            markDTOData.add(markDTOListObj);
        }

        File file = ResourceUtils.getFile("classpath:MarkWithCourseReport_Jaspersoft.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(markDTOData);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Najat Tech Mahindra");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\MarkWithCourseJasperReport.pdf");
        return "Report generated : " + pathToReports+"\\MarkWithCourseJasperReport.pdf";
    }
}
