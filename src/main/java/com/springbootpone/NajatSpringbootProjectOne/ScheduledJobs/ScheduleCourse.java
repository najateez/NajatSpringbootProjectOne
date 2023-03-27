package com.springbootpone.NajatSpringbootProjectOne.ScheduledJobs;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Services.CourseService;
import com.springbootpone.NajatSpringbootProjectOne.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

// ------ Its All about CRON.. sending values from db table to slack (and choose after how many days or,.... will send these data's again to slack. as a (Remainder) ----
// CRON for course

//@Component
public class ScheduleCourse {

    @Autowired
    SlackClient slackClient;  //to which channel in slack you want to send data's.

    @Autowired
    CourseService courseService;

    // -------------- for course table ----------------------------

    //getAllToSlack
    @Scheduled(cron = "* */55 * * * *")
    public List<Course> getAllCourses() {
        List<Course> theCourse = courseService.getAllCourses();

        slackClient.sendMessage("--- course data from db to slack (api). course/getAll ---");
        for (Course c : theCourse) {
            slackClient.sendMessage("course id:" + c.getId());
            slackClient.sendMessage("course name:" + c.getName());
            slackClient.sendMessage("course CreatedDate:" + c.getCreatedDate());
            slackClient.sendMessage("course isActive:" + c.getActive());
            slackClient.sendMessage("course UpdatedDate:" + c.getUpdatedDate());
            //   slackClient.sendMessage("student id:"+ stu.getStudent());
        }

        return theCourse;
    }

    //getByIdToSlack :-
    // @Scheduled(cron = "* */15 * * * *")
    public Course getCourseById(Integer courseId) {
        Course course = courseService.getCourseById(courseId);

        slackClient.sendMessage("--- course data from db to slack (api). course/getById ---");
        slackClient.sendMessage("course id:" + course.getId());
        slackClient.sendMessage("course name:" + course.getName());
        slackClient.sendMessage("course CreatedDate:" + course.getCreatedDate());
        slackClient.sendMessage("course isActive:" + course.getActive());
        slackClient.sendMessage("course UpdatedDate:" + course.getUpdatedDate());
        //   slackClient.sendMessage("student id:"+ stu.getStudent());

        return course;
    }

    //getByColumnCourseNameToSlack :-
    // @Scheduled(cron = "* */15 * * * *")
    public Course getCourseByCourseName(String courseName) {
        Course course = courseService.getCourseByCourseName(courseName);

        slackClient.sendMessage("--- course data from db to slack (api). course/getByColumnCourseName ---");
        slackClient.sendMessage("course id:" + course.getId());
        slackClient.sendMessage("course name:" + course.getName());
        slackClient.sendMessage("course CreatedDate:" + course.getCreatedDate());
        slackClient.sendMessage("course isActive:" + course.getActive());
        slackClient.sendMessage("course UpdatedDate:" + course.getUpdatedDate());
        //   slackClient.sendMessage("student id:"+ stu.getStudent());

        return course;
    }

    // getAllActiveCoursesToSlack :-
    @Scheduled(cron = "* * */1 * * *")
    public List<Course> getAllActiveCourses() {
        List<Course> activeCoursesList = courseService.getAllActiveCourses();

        slackClient.sendMessage("--- course data from db to slack (api). course/getAll ---");
        for (Course c : activeCoursesList) {
            slackClient.sendMessage("course id:" + c.getId());
            slackClient.sendMessage("course name:" + c.getName());
            slackClient.sendMessage("course CreatedDate:" + c.getCreatedDate());
            slackClient.sendMessage("course isActive:" + c.getActive());
            slackClient.sendMessage("course UpdatedDate:" + c.getUpdatedDate());
            //   slackClient.sendMessage("student id:"+ stu.getStudent());
        }
        return activeCoursesList;
    }

    // getAllNotActiveCoursesToSlack :-
    @Scheduled(cron = "* * */2 * * *")
    public List<Course> getAllInActiveCourses() {
        List<Course> notActiveCoursesList = courseService.getAllInActiveCourses();

        slackClient.sendMessage("--- course data from db to slack (api). getAllCoursesByIsActiveFalse ---");
        for (Course c : notActiveCoursesList) {
            slackClient.sendMessage("course id:" + c.getId());
            slackClient.sendMessage("course name:" + c.getName());
            slackClient.sendMessage("course CreatedDate:" + c.getCreatedDate());
            slackClient.sendMessage("course isActive:" + c.getActive());
            slackClient.sendMessage("course UpdatedDate:" + c.getUpdatedDate());
            //   slackClient.sendMessage("student id:"+ stu.getStudent());
        }
        return notActiveCoursesList;
    }

    //getLatestRowToSlack :-
    @Scheduled(cron = "* * */3 * * *")
    public Course getLatestRowCourse() {
        Course course = courseService.getLatestRowCourse();

        slackClient.sendMessage("--- course data from db to slack (api). course/getLatestRowCourse ---");
        slackClient.sendMessage("course id:" + course.getId());
        slackClient.sendMessage("course name:" + course.getName());
        slackClient.sendMessage("course CreatedDate:" + course.getCreatedDate());
        slackClient.sendMessage("course isActive:" + course.getActive());
        slackClient.sendMessage("course UpdatedDate:" + course.getUpdatedDate());
        //   slackClient.sendMessage("student id:"+ stu.getStudent());
        return course;
    }

    //getLatestUpdatedToSlack :-
    @Scheduled(cron = "* * */4 * * *")
    public Course getLatestUpdatedCourse() {
        Course course = courseService.getLatestUpdatedCourse();

        slackClient.sendMessage("--- course data from db to slack (api). course/getLatestUpdatedCourse ---");
        slackClient.sendMessage("course id:" + course.getId());
        slackClient.sendMessage("course name:" + course.getName());
        slackClient.sendMessage("course CreatedDate:" + course.getCreatedDate());
        slackClient.sendMessage("course isActive:" + course.getActive());
        slackClient.sendMessage("course UpdatedDate:" + course.getUpdatedDate());
        //   slackClient.sendMessage("student id:"+ stu.getStudent());

        return course;
    }

    //getCourseByCreatedDate :-
    // @Scheduled(cron = "* */15 * * * *")
    public List<Course> getCourseByCreatedDate(String createdDate) throws ParseException {
        List<Course> course = courseService.getCourseByCreatedDate(createdDate);

        slackClient.sendMessage("--- course data from db to slack (api). getAllCoursesByIsActiveFalse ---");
        for (Course c : course) {
            slackClient.sendMessage("course id:" + c.getId());
            slackClient.sendMessage("course name:" + c.getName());
            slackClient.sendMessage("course CreatedDate:" + c.getCreatedDate());
            slackClient.sendMessage("course isActive:" + c.getActive());
            slackClient.sendMessage("course UpdatedDate:" + c.getUpdatedDate());
            //   slackClient.sendMessage("student id:"+ stu.getStudent());
        }

        return course;
    }
}
