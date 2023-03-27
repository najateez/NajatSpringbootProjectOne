package com.springbootpone.NajatSpringbootProjectOne.ScheduledJobs;

import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Services.StudentService;
import com.springbootpone.NajatSpringbootProjectOne.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

// ------ Its All about CRON.. sending values from db table to slack (and choose after how many days or,.... will send these data's again to slack. as a (Remainder) ----
// CRON for student
@Component
public class ScheduleStudent {

    @Autowired
    SlackClient slackClient;  //to which channel in slack you want to send data's.

    @Autowired
    StudentService studentService;

    // -------------- for student table ----------------------------

    //getAllToSlack
    @Scheduled(cron = "* */30 * * * *")
    public List<Student> getAllStudents() {
        List<Student> theStudent = studentService.getAllStudents();

        slackClient.sendMessage("--- student data from db to slack (api). student/getAll ---");
        for (Student stu : theStudent) {
            slackClient.sendMessage("student id:" + stu.getId());
            slackClient.sendMessage("student name:" + stu.getName());
            slackClient.sendMessage("student RollNumber:" + stu.getRollNumber());
            slackClient.sendMessage("student CreatedDate:" + stu.getCreatedDate());
            slackClient.sendMessage("student isActive:" + stu.getActive());
            slackClient.sendMessage("student UpdatedDate:" + stu.getUpdatedDate());
            //    slackClient.sendMessage("school id:"+ stu.getSchool());
        }
        return theStudent;
    }

    //getByIdToSlack :-
    //exp: localhost:8080/student/getById?studentId=46
    // @Scheduled(cron = "* */15 * * * *")
    public Student getStudentById(Integer studentId) {
        Student student = studentService.getStudentById(studentId);

        slackClient.sendMessage("--- student data from db to slack (api). student/getById ---");
        slackClient.sendMessage("student id:" + student.getId());
        slackClient.sendMessage("student name:" + student.getName());
        slackClient.sendMessage("student RollNumber:" + student.getRollNumber());
        slackClient.sendMessage("student CreatedDate:" + student.getCreatedDate());
        slackClient.sendMessage("student isActive:" + student.getActive());
        slackClient.sendMessage("student UpdatedDate:" + student.getUpdatedDate());
        slackClient.sendMessage("school id:" + student.getSchool());

        return student;
    }

    //getByColumnStudentNameToSlack :-
    //   @Scheduled(cron = "* */15 * * * *")
    public Student getStudentByStudentName(String studentName) {
        Student student = studentService.getStudentByStudentName(studentName);

        slackClient.sendMessage("--- student data from db to slack (api). student/getByColumnStudentName ---");
        slackClient.sendMessage("student id:" + student.getId());
        slackClient.sendMessage("student name:" + student.getName());
        slackClient.sendMessage("student RollNumber:" + student.getRollNumber());
        slackClient.sendMessage("student CreatedDate:" + student.getCreatedDate());
        slackClient.sendMessage("student isActive:" + student.getActive());
        slackClient.sendMessage("student UpdatedDate:" + student.getUpdatedDate());
        //   slackClient.sendMessage("school id:"+ student.getSchool());

        return student;
    }

    // getAllActiveStudentsToSlack :-
    @Scheduled(cron = "* */35 * * * *")
    public List<Student> getAllActiveStudents() {
        List<Student> activeStudentsList = studentService.getAllActiveStudents();

        slackClient.sendMessage("--- student data from db to slack (api). getAllStudentsByIsActive ---");
        for (Student stu : activeStudentsList) {
            slackClient.sendMessage("--- student data from db to slack (api). getAllStudentsByIsActive ---");
            slackClient.sendMessage("student id:" + stu.getId());
            slackClient.sendMessage("student name:" + stu.getName());
            slackClient.sendMessage("student RollNumber:" + stu.getRollNumber());
            slackClient.sendMessage("student CreatedDate:" + stu.getCreatedDate());
            slackClient.sendMessage("student isActive:" + stu.getActive());
            slackClient.sendMessage("student UpdatedDate:" + stu.getUpdatedDate());
            //   slackClient.sendMessage("school id:"+ stu.getSchool());
        }

        return activeStudentsList;
    }

    // getAllNotActiveStudentsToSlack :-
    @Scheduled(cron = "* */40 * * * *")
    public List<Student> getAllInActiveStudents() {
        List<Student> notActiveStudentsList = studentService.getAllInActiveStudents();

        slackClient.sendMessage("--- student data from db to slack (api). getAllStudentsByIsActiveFalse ---");
        for (Student stu : notActiveStudentsList) {
            slackClient.sendMessage("student id:" + stu.getId());
            slackClient.sendMessage("student name:" + stu.getName());
            slackClient.sendMessage("student RollNumber:" + stu.getRollNumber());
            slackClient.sendMessage("student CreatedDate:" + stu.getCreatedDate());
            slackClient.sendMessage("student isActive:" + stu.getActive());
            slackClient.sendMessage("student UpdatedDate:" + stu.getUpdatedDate());
            //   slackClient.sendMessage("school id:"+ stu.getSchool());
        }
        return notActiveStudentsList;
    }

    //getLatestRowToSlack :-
    @Scheduled(cron = "* */45 * * * *")
    public Student getLatestRowStudent() {
        Student student = studentService.getLatestRowStudent();

        slackClient.sendMessage("--- student data from db to slack (api). student/getLatestRowStudent ---");
        slackClient.sendMessage("student id:" + student.getId());
        slackClient.sendMessage("student name:" + student.getName());
        slackClient.sendMessage("student RollNumber:" + student.getRollNumber());
        slackClient.sendMessage("student CreatedDate:" + student.getCreatedDate());
        slackClient.sendMessage("student isActive:" + student.getActive());
        slackClient.sendMessage("student UpdatedDate:" + student.getUpdatedDate());
        //   slackClient.sendMessage("school id:"+ student.getSchool());

        return student;
    }

    //getLatestUpdatedToSlack
    @Scheduled(cron = "* */50 * * * *")
    public Student getLatestUpdatedStudent() {
        Student student = studentService.getLatestUpdatedStudent();

        slackClient.sendMessage("--- student data from db to slack (api). student/getLatestUpdatedStudent ---");
        slackClient.sendMessage("student id:" + student.getId());
        slackClient.sendMessage("student name:" + student.getName());
        slackClient.sendMessage("student RollNumber:" + student.getRollNumber());
        slackClient.sendMessage("student CreatedDate:" + student.getCreatedDate());
        slackClient.sendMessage("student isActive:" + student.getActive());
        slackClient.sendMessage("student UpdatedDate:" + student.getUpdatedDate());
        //   slackClient.sendMessage("school id:"+ student.getSchool());

        return student;
    }

    //getCreatedAfterDateToSlack
    //  @Scheduled(cron = "* */15 * * * *")
    public List<Student> getCreatedAfterDateStudent(String createdDate) throws ParseException {
        List<Student> createdAfterDate = studentService.getCreatedAfterDateStudent(createdDate);

        slackClient.sendMessage("--- student data from db to slack (api). student/getStudentCreatedAfterDate ---");
        for (Student stu : createdAfterDate) {
            slackClient.sendMessage("student id:" + stu.getId());
            slackClient.sendMessage("student name:" + stu.getName());
            slackClient.sendMessage("student RollNumber:" + stu.getRollNumber());
            slackClient.sendMessage("student CreatedDate:" + stu.getCreatedDate());
            slackClient.sendMessage("student isActive:" + stu.getActive());
            slackClient.sendMessage("student UpdatedDate:" + stu.getUpdatedDate());
            //   slackClient.sendMessage("school id:"+ stu.getSchool());
        }
        return createdAfterDate;
    }

    //getStudentByCreatedDate :-
    // @Scheduled(cron = "* */15 * * * *")
    public List<Student> getStudentByCreatedDate(String createdDate) throws ParseException {
        List<Student> student = studentService.getStudentByCreatedDate(createdDate);

        slackClient.sendMessage("--- student data from db to slack (api). student/getStudentCreatedAfterDate ---");
        for (Student stu : student) {
            slackClient.sendMessage("student id:" + stu.getId());
            slackClient.sendMessage("student name:" + stu.getName());
            slackClient.sendMessage("student RollNumber:" + stu.getRollNumber());
            slackClient.sendMessage("student CreatedDate:" + stu.getCreatedDate());
            slackClient.sendMessage("student isActive:" + stu.getActive());
            slackClient.sendMessage("student UpdatedDate:" + stu.getUpdatedDate());
            //   slackClient.sendMessage("school id:"+ stu.getSchool());
        }

        return student;
    }
}
