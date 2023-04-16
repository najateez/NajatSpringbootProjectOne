package com.springbootpone.NajatSpringbootProjectOne.Services;

import com.springbootpone.NajatSpringbootProjectOne.DTO.MarkDTO;
import com.springbootpone.NajatSpringbootProjectOne.DTO.StudentDTO;
import com.springbootpone.NajatSpringbootProjectOne.DTO.TopPerformingStudentDTO;
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
public class JasperReportService {

    //Solutions jasper report for all task questions

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    MarkRepository markRepository;

    //Question 1:

    //  public static final String pathToReports = "C:\\Users\\Acer\\Downloads\\Reports";

    // the path that the jasper report which generated will be saved in.
    public static final String pathToReports = "C:\\Users\\Acer\\intellijIdea-workspace\\NajatSpringbootProjectOne\\Reports";

    public String generateStudentWithSchoolJasperReport() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudents();  // to take data from db
        List<StudentDTO> studentDTOData = new ArrayList<>();  //to store data from db table to (StudentDTO list of jaspersoft list).

        //to get all values from db
        for(Student s:studentList){
            String schoolName = s.getSchool().getName(); //because in table student there is school_id, so it can take school information also from school table. .getSchool()-> means it will go inside school table from student table by school id.
            String studentName = s.getName();
            String rollNumber = s.getRollNumber();

            //define object of contracture for property of DTO
            StudentDTO StudentDTOListObj=new StudentDTO(schoolName,studentName,rollNumber);
            //add this values from database to list of jasper report.
            studentDTOData.add(StudentDTOListObj);
        }

        //add name of (jrxml) file.
        File file = ResourceUtils.getFile("classpath:StrudentWithSchoolReport_Jaspersoft.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentDTOData);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Najat Tech Mahindra"); //created by any company name
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        // name given for pdf file when jasper report created.
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\StudentWithSchoolJasperReportQuestion1.pdf");
        return "Report generated : " + pathToReports+"\\StudentWithSchoolJasperReportQuestion1.pdf";
    }

    //--------------------------------------------------------------------------------

    //Question 2:

    public static final String pathToReports2 = "C:\\Users\\Acer\\intellijIdea-workspace\\NajatSpringbootProjectOne\\Reports";

    //same way solution as Q1:-
    public String generateMarkWithCourseJasperReportQuestion2() throws FileNotFoundException, JRException {
        List<Mark> markList = markRepository.getAllMarks();  // to take data from db
        List<MarkDTO> markDTOData = new ArrayList<>();  //to store data from db table to (StudentDTO list of jaspersoft list).

        for(Mark m:markList){
            String courseName = m.getCourse().getName();
            Integer obtainedMarks = m.getObtainedMarks();
            String grade = m.getGrade();


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

//-----------------------------------------------------------------------------

    /* Question 3:
         To calculate average mark, i will use HashMap. because for each unique course name we will make calculation.
            exp:
           - add ObtainedMarks of each course name(one course at a time. as all java) and divide by No.of java used in database table mark:
              id of java is 12 (from course table), this id 12 is used in mark table 2 times. so will
              Sum(ObtainedMarks)/2 -> will give average mark.
     */

    public static final String pathToReports3 = "C:\\Users\\Acer\\intellijIdea-workspace\\NajatSpringbootProjectOne\\Reports";

    public String generateMarkWithCourseJasperReport2Question3() throws FileNotFoundException, JRException {
        List<Mark> markList = markRepository.getAllMarks();  // to take data from db
        List<MarkDTO> markDTOData = new ArrayList<>();  //to store data from db table to (MarkDTO list of jaspersoft list). with average mark.

        //string for course name, integer for ObtainedMarks
        Map<String, List<Integer>> courseObtainedMarksMap = new HashMap<>();
        //    Map<String, String> gradeMap = new HashMap<>(); // this HashMap grade mush be there, without it it will show error, can not define grade.


        for (Mark m : markList) {
            String courseName = m.getCourse().getName();
            Integer obtainedMarks = m.getObtainedMarks();
            //        String grade = m.getGrade();

            if (courseObtainedMarksMap.containsKey(courseName)) {
                courseObtainedMarksMap.get(courseName).add(obtainedMarks);
            } else {
                List<Integer> obtainedMarksList = new ArrayList<>(); //used ArrayList also to divide by its size of obtainedMarks. for(average mark).
                obtainedMarksList.add(obtainedMarks);
                courseObtainedMarksMap.put(courseName, obtainedMarksList);
            }

            //      gradeMap.put(courseName, grade);

        }

        // Loop through the courseObtainedMarksMap (HashMap). because all obtainedMarks which are in list, get it course name from db.
        for (String courseName : courseObtainedMarksMap.keySet()) {
            List<Integer> obtainedMarksList = courseObtainedMarksMap.get(courseName);

            // calculate the averageMarks for each courseName:
            Double sum = 0.0;
            //to display all obtainedMarks which are in obtainedMarksList and add them together of that course.
            for (Integer obtainedMark : obtainedMarksList) {
                sum += obtainedMark;
            }
            Double averageMark = sum / obtainedMarksList.size(); // sum/size of obatinedMarks in list.

            //add course name and average mark to jasper report pdf.
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

    //-----------------------------------------------------

    //Question 6:
    public static final String pathToReports4 = "C:\\Users\\Acer\\intellijIdea-workspace\\NajatSpringbootProjectOne\\Reports";

    public String generateStudentReportQ6() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudents();  // to take data from db
        List<StudentDTO> studentDTOList = new ArrayList<>();  //to store data from db table to (StudentDTO list of jaspersoft list). or i can say DTO Constructor in this class name (StudentDTO.java) has these properties required in question. inside package DTO.

        //should use HashMap,to store and count how many students in each school. (school name, No.of students in that school)
        Map<String, Integer> schoolNoOfStudentsMap = new HashMap<>();


        for(Student s:studentList) {
            String schoolName = s.getSchool().getName();
            //if no students in that school put 0 otherwise add 1
            schoolNoOfStudentsMap.put(schoolName, schoolNoOfStudentsMap.getOrDefault(schoolName, 0) + 1);
        }

        for (String schoolName : schoolNoOfStudentsMap.keySet()) {
            int countStudents = schoolNoOfStudentsMap.get(schoolName);

            StudentDTO studentDTOObj = new StudentDTO(schoolName, countStudents);
            studentDTOList.add(studentDTOObj);
        }

        File file = ResourceUtils.getFile("classpath:StudentReportQuestion6_Jaspersoft.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentDTOList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Najat Tech Mahindra");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\StudentReportQuestion6.pdf");
        return "Report generated : " + pathToReports+"\\StudentReportQuestion6.pdf";
    }

    //-----------------------------------------------------

    /* Question 7:
       - Should display course name with grade, and   count mark of each grade(count grade).
       exp:
       how many very good in that course, how many good?, and how many fail ?. because if you know how many good
       you will know how many mark in that grade...
    */
    public static final String pathToReports5 = "C:\\Users\\Acer\\intellijIdea-workspace\\NajatSpringbootProjectOne\\Reports";

    public String generateMarkWithCourseJasperReportQuestion7() throws FileNotFoundException, JRException {
        List<Mark> markList = markRepository.getAllMarks();  // to take data from db
        List<MarkDTO> markDTOData = new ArrayList<>();  //to store data from db table to (StudentDTO list of jaspersoft list).

        for(Mark m:markList){
            String courseName = m.getCourse().getName();
            String grade = m.getGrade();

            MarkDTO markDTOListObj = new MarkDTO(courseName, grade, 1);

            boolean found = false;
            for (MarkDTO dto : markDTOData) {
                if (dto.getCourseName().equals(courseName) && dto.getGrade().equals(grade)) {
                    dto.setCountGrade(dto.getCountGrade() + 1);

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

    //-----------------------------------------------------

    /* Top-Performing Student Report (Solution Question 4):
     explaination how i did:
    its all about foreign key from school table to mark table.
    first it will check school table and student table which students in that school. then it will take
    only students which have foreign key with course. then will check that course table and mark table,
    that prevoius student has which course, then will go to mark table, will Sum Total of (ObtainedMarks) of that student
    and show result in ascending order.
     */

    public static final String pathToReports6 = "C:\\Users\\Acer\\intellijIdea-workspace\\NajatSpringbootProjectOne\\Reports";

    public String generateTopPerformingStudentReportQuestion4() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudents(); //has foreign key of school table
        List<Mark> markList = markRepository.getAllMarks(); //has foreign key of course table

        //   List<TopPerformingStudentDTO> topPerformingStudentDTOList = new ArrayList<>();

        //Student because there is school_id foreign key of School table. can use both table information. exp: school name, student name.  , Integer for obtainedMarks. (HashMap).
        Map<Student, Integer> studentObtainedMarksMap = new HashMap<>();

        // calculate total marks obtained by each student, depend on what student have course.
        for (Mark m : markList) {
            Integer obtainedMarks = studentObtainedMarksMap.getOrDefault(m.getCourse().getStudent(), 0);
            obtainedMarks += m.getObtainedMarks();
            studentObtainedMarksMap.put(m.getCourse().getStudent(), obtainedMarks);
        }

        //after adding obtainedMarks of that student, will sort total of obtainedMarks in ascending order with that student.
        // sort the students by obtained marks
        List<Map.Entry<Student, Integer>> sortedList = new ArrayList<>(studentObtainedMarksMap.entrySet());
        sortedList.sort(Map.Entry.comparingByValue());

        // create DTO objects for top-performing students. to store in jasper report as list in pdf.
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
