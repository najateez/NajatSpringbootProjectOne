package com.springbootpone.NajatSpringbootProjectOne.ScheduledJobs;

import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Services.SchoolService;
import com.springbootpone.NajatSpringbootProjectOne.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;


// ------ Its All about CRON.. sending values from db table to slack (and choose after how many days or,.... will send these data's again to slack. as a (Remainder) ----
// CRON for school

//@Component
public class ScheduleSchool {

    @Autowired
    SlackClient slackClient;  //to which channel in slack you want to send data's.

    @Autowired
    SchoolService schoolService;

    //should send data's to slack every 5 minutes.
    //second,minute,hour,day of the month, month, day of the week.


    //   public void alertSlack(){
    //Get functions for school,student,course,mark.

    /* Same code as firstController, but should remove all @RequestParam from code, and full of @RequestMapping
     because it is not controller. Also remove full of @Scheduled to the function which has parameter.
     */

    // No need for postman here, because not controller
    @Scheduled(cron = "* */5 * * * *")
    public List<School> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();

        //run in postman, it will take data's from db, will send data as api's to slack.
        slackClient.sendMessage("--- school data from db to slack (api). school/getAll  ---");
        for (School s : schools) {
            slackClient.sendMessage("school id:" + s.getId());
            slackClient.sendMessage("school name:" + s.getName());
            slackClient.sendMessage("school CreatedDate:" + s.getCreatedDate());
            slackClient.sendMessage("school isActive:" + s.getActive());
            slackClient.sendMessage("school UpdatedDate:" + s.getUpdatedDate());
        }
        return schools;
    }

    //getByIdToSlack
    // @Scheduled(cron = "* */5 * * * *")
    public School getSchoolById(Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);

        slackClient.sendMessage("--- school data from db to slack (api). school/getById  ---");
        slackClient.sendMessage("school id:" + school.getId());
        slackClient.sendMessage("school name:" + school.getName());
        slackClient.sendMessage("school CreatedDate:" + school.getCreatedDate());
        slackClient.sendMessage("school isActive:" + school.getActive());
        slackClient.sendMessage("school UpdatedDate:" + school.getUpdatedDate());

        return school;
    }

    //getByColumnNameToSlack:-
    //  @Scheduled(cron = "* */5 * * * *")
    public School getSchoolBySchoolName(String schoolName) {
        School school = schoolService.getSchoolBySchoolName(schoolName);

        slackClient.sendMessage("--- school data from db to slack (api). school/getByColumnSchoolName ---");
        slackClient.sendMessage("school id:" + school.getId());
        slackClient.sendMessage("school name:" + school.getName());
        slackClient.sendMessage("school CreatedDate:" + school.getCreatedDate());
        slackClient.sendMessage("school isActive:" + school.getActive());
        slackClient.sendMessage("school UpdatedDate:" + school.getUpdatedDate());

        return school;
    }

    // getAllActiveSchoolsToSlack :-
    @Scheduled(cron = "* */10 * * * *")
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();

        slackClient.sendMessage("--- school data from db to slack (api). getAllSchoolsByIsActive  ---");
        for (School s : activeSchoolsList) {
            slackClient.sendMessage("school id:" + s.getId());
            slackClient.sendMessage("school name:" + s.getName());
            slackClient.sendMessage("school CreatedDate:" + s.getCreatedDate());
            slackClient.sendMessage("school isActive:" + s.getActive());
            slackClient.sendMessage("school UpdatedDate:" + s.getUpdatedDate());
        }

        return activeSchoolsList;
    }

    // getAllNotActiveSchools :-
    @Scheduled(cron = "* */15 * * * *")
    public List<School> getAllInActiveSchools() {
        List<School> notActiveSchoolsList = schoolService.getAllInActiveSchools();

        slackClient.sendMessage("--- school data from db to slack (api). getAllSchoolsByIsActiveFalse  ---");
        for (School s : notActiveSchoolsList) {
            slackClient.sendMessage("school id:" + s.getId());
            slackClient.sendMessage("school name:" + s.getName());
            slackClient.sendMessage("school CreatedDate:" + s.getCreatedDate());
            slackClient.sendMessage("school isActive:" + s.getActive());
            slackClient.sendMessage("school UpdatedDate:" + s.getUpdatedDate());
        }

        return notActiveSchoolsList;
    }

    //getLatestRowToSlack :-
    @Scheduled(cron = "* */20 * * * *")
    public School getLatestRowSchool() {
        School school = schoolService.getLatestRowSchool();

        slackClient.sendMessage("--- school data from db to slack (api). school/getLatestRowSchool ---");
        slackClient.sendMessage("school id:" + school.getId());
        slackClient.sendMessage("school name:" + school.getName());
        slackClient.sendMessage("school CreatedDate:" + school.getCreatedDate());
        slackClient.sendMessage("school isActive:" + school.getActive());
        slackClient.sendMessage("school UpdatedDate:" + school.getUpdatedDate());

        return school;
    }

    //getLatestUpdatedToSlack :-
    @Scheduled(cron = "* */25 * * * *")
    public School getLatestUpdatedSchool() {
        School school = schoolService.getLatestUpdatedSchool();

        slackClient.sendMessage("--- school data from db to slack (api). school/getLatestUpdatedSchool ---");
        slackClient.sendMessage("school id:" + school.getId());
        slackClient.sendMessage("school name:" + school.getName());
        slackClient.sendMessage("school CreatedDate:" + school.getCreatedDate());
        slackClient.sendMessage("school isActive:" + school.getActive());
        slackClient.sendMessage("school UpdatedDate:" + school.getUpdatedDate());

        return school;
    }

    //getCreatedAfterDateToSlack:-
//    @Scheduled(cron = "* */15 * * * *")
    public List<School> getCreatedAfterDateSchool(String createdDate) throws ParseException {
        List<School> createdAfterDate = schoolService.getCreatedAfterDateSchool(createdDate);

        slackClient.sendMessage("--- school data from db to slack (api). getAllSchoolsByIsActiveFalse  ---");
        for (School s : createdAfterDate) {
            slackClient.sendMessage("school id:" + s.getId());
            slackClient.sendMessage("school name:" + s.getName());
            slackClient.sendMessage("school CreatedDate:" + s.getCreatedDate());
            slackClient.sendMessage("school isActive:" + s.getActive());
            slackClient.sendMessage("school UpdatedDate:" + s.getUpdatedDate());
        }
        return createdAfterDate;
    }

    //getSchoolByNumberOfStudentsToSlack :-
//    @Scheduled(cron = "* */15 * * * *")
    public List<School> getSchoolByNumberOfStudent(Integer numberOfStudent) {

        List<School> schoolList = schoolService.getSchoolByNumberOfStudent(numberOfStudent);

        slackClient.sendMessage("--- school data from db to slack (api). school/getSchoolByNumberOfStudent  ---");
        for (School s : schoolList) {
            slackClient.sendMessage("school id:" + s.getId());
            slackClient.sendMessage("school name:" + s.getName());
            slackClient.sendMessage("school CreatedDate:" + s.getCreatedDate());
            slackClient.sendMessage("school isActive:" + s.getActive());
            slackClient.sendMessage("school UpdatedDate:" + s.getUpdatedDate());
        }
        return schoolList;
    }

    //getSchoolByCreatedDate :-
    //   @Scheduled(cron = "* */15 * * * *")
    public List<School> getSchoolByCreatedDate(String createdDate) throws ParseException {
        List<School> school = schoolService.getSchoolByCreatedDate(createdDate);

        slackClient.sendMessage("--- school data from db to slack (api). school/getSchoolByCreatedDate ---");
        for (School s : school) {
            slackClient.sendMessage("school id:" + s.getId());
            slackClient.sendMessage("school name:" + s.getName());
            slackClient.sendMessage("school CreatedDate:" + s.getCreatedDate());
            slackClient.sendMessage("school isActive:" + s.getActive());
            slackClient.sendMessage("school UpdatedDate:" + s.getUpdatedDate());
        }

        return school;
    }

    //getSchoolByUpdatedDate
    //   @Scheduled(cron = "* */15 * * * *")
    public List<School> getSchoolByUpdatedDate(String updatedDate) throws ParseException {
        List<School> school = schoolService.getSchoolByUpdatedDate(updatedDate);

        slackClient.sendMessage("--- school data from db to slack (api). school/getSchoolByUpdatedDate ---");
        for (School s : school) {
            slackClient.sendMessage("school id:" + s.getId());
            slackClient.sendMessage("school name:" + s.getName());
            slackClient.sendMessage("school CreatedDate:" + s.getCreatedDate());
            slackClient.sendMessage("school isActive:" + s.getActive());
            slackClient.sendMessage("school UpdatedDate:" + s.getUpdatedDate());
        }
        return school;
    }

}
