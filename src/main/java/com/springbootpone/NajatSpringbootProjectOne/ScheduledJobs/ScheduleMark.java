package com.springbootpone.NajatSpringbootProjectOne.ScheduledJobs;

import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
import com.springbootpone.NajatSpringbootProjectOne.Services.MarkService;
import com.springbootpone.NajatSpringbootProjectOne.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

// ------ Its All about CRON.. sending values from db table to slack (and choose after how many days or,.... will send these data's again to slack. as a (Remainder) ----
// CRON for mark

//@Component
public class ScheduleMark {

    @Autowired
    SlackClient slackClient;  //to which channel in slack you want to send data's.

    @Autowired
    MarkService markService;

    // -------------- for mark table ----------------------------

    //getAllToSlack :-
    @Scheduled(cron = "* * */5 * * *")
    public List<Mark> getAllMarks() {
        List<Mark> theMark = markService.getAllMarks();

        slackClient.sendMessage("--- mark data from db to slack (api). mark/getAll ---");
        for (Mark m : theMark) {
            slackClient.sendMessage("mark id:" + m.getId());
            slackClient.sendMessage("grade:" + m.getGrade());
            slackClient.sendMessage("obtainedMarks:" + m.getObtainedMarks());
            slackClient.sendMessage("course CreatedDate:" + m.getCreatedDate());
            slackClient.sendMessage("course isActive:" + m.getActive());
            slackClient.sendMessage("course UpdatedDate:" + m.getUpdatedDate());
            //   slackClient.sendMessage("course id:"+ stu.getCourse());
        }

        return theMark;
    }

    //getByIdToSlack :-
    // @Scheduled(cron = "* */15 * * * *")
    public Mark getMarkById(Integer markId) {
        Mark mark = markService.getMarkById(markId);

        slackClient.sendMessage("--- mark data from db to slack (api). mark/getById ---");
        slackClient.sendMessage("mark id:" + mark.getId());
        slackClient.sendMessage("grade:" + mark.getGrade());
        slackClient.sendMessage("obtainedMarks:" + mark.getObtainedMarks());
        slackClient.sendMessage("course CreatedDate:" + mark.getCreatedDate());
        slackClient.sendMessage("course isActive:" + mark.getActive());
        slackClient.sendMessage("course UpdatedDate:" + mark.getUpdatedDate());
        //   slackClient.sendMessage("course id:"+ stu.getCourse());

        return mark;
    }

    //getByColumnObtainedMarksToSlack :-
    //  @Scheduled(cron = "* */15 * * * *")
    public Mark getCourseByCourseName(Integer obtainedMarks) {
        Mark mark = markService.getMarkByObtainedMarks(obtainedMarks);

        slackClient.sendMessage("--- mark data from db to slack (api). mark/getByColumnObtainedMarks ---");
        slackClient.sendMessage("mark id:" + mark.getId());
        slackClient.sendMessage("grade:" + mark.getGrade());
        slackClient.sendMessage("obtainedMarks:" + mark.getObtainedMarks());
        slackClient.sendMessage("course CreatedDate:" + mark.getCreatedDate());
        slackClient.sendMessage("course isActive:" + mark.getActive());
        slackClient.sendMessage("course UpdatedDate:" + mark.getUpdatedDate());
        //   slackClient.sendMessage("course id:"+ stu.getCourse());

        return mark;
    }

    // getAllActiveMarksToSlack :-
    @Scheduled(cron = "* * */6 * * *")
    public List<Mark> getAllActiveMarks() {
        List<Mark> activeMarksList = markService.getAllActiveMarks();

        slackClient.sendMessage("--- mark data from db to slack (api). getAllMarksByIsActive ---");
        for (Mark m : activeMarksList) {
            slackClient.sendMessage("mark id:" + m.getId());
            slackClient.sendMessage("grade:" + m.getGrade());
            slackClient.sendMessage("obtainedMarks:" + m.getObtainedMarks());
            slackClient.sendMessage("course CreatedDate:" + m.getCreatedDate());
            slackClient.sendMessage("course isActive:" + m.getActive());
            slackClient.sendMessage("course UpdatedDate:" + m.getUpdatedDate());
            //   slackClient.sendMessage("course id:"+ stu.getCourse());
        }
        return activeMarksList;
    }

    //getAllMarksByIsActiveFalseToSlack :-
    @Scheduled(cron = "* * */7 * * *")
    public List<Mark> getAllInActiveMarks() {
        List<Mark> notInActiveMarksList = markService.getAllInActiveMarks();

        slackClient.sendMessage("--- mark data from db to slack (api). getAllMarksByIsActiveFalse ---");
        for (Mark m : notInActiveMarksList) {
            slackClient.sendMessage("mark id:" + m.getId());
            slackClient.sendMessage("grade:" + m.getGrade());
            slackClient.sendMessage("obtainedMarks:" + m.getObtainedMarks());
            slackClient.sendMessage("course CreatedDate:" + m.getCreatedDate());
            slackClient.sendMessage("course isActive:" + m.getActive());
            slackClient.sendMessage("course UpdatedDate:" + m.getUpdatedDate());
            //   slackClient.sendMessage("course id:"+ stu.getCourse());
        }
        return notInActiveMarksList;
    }

    //getLatestRowToSlack :-
    @Scheduled(cron = "* * */8 * * *")
    public Mark getLatestRowMark() {
        Mark mark = markService.getLatestRowMark();

        slackClient.sendMessage("--- mark data from db to slack (api). mark/getLatestRowMark ---");
        slackClient.sendMessage("mark id:" + mark.getId());
        slackClient.sendMessage("grade:" + mark.getGrade());
        slackClient.sendMessage("obtainedMarks:" + mark.getObtainedMarks());
        slackClient.sendMessage("course CreatedDate:" + mark.getCreatedDate());
        slackClient.sendMessage("course isActive:" + mark.getActive());
        slackClient.sendMessage("course UpdatedDate:" + mark.getUpdatedDate());
        //   slackClient.sendMessage("course id:"+ stu.getCourse());

        return mark;
    }

    //getLatestUpdatedToSlack :-
    @Scheduled(cron = "* * */9 * * *")
    public Mark getLatestUpdatedMark() {
        Mark mark = markService.getLatestUpdatedMark();

        slackClient.sendMessage("--- mark data from db to slack (api). mark/getLatestUpdatedMark ---");
        slackClient.sendMessage("mark id:" + mark.getId());
        slackClient.sendMessage("grade:" + mark.getGrade());
        slackClient.sendMessage("obtainedMarks:" + mark.getObtainedMarks());
        slackClient.sendMessage("course CreatedDate:" + mark.getCreatedDate());
        slackClient.sendMessage("course isActive:" + mark.getActive());
        slackClient.sendMessage("course UpdatedDate:" + mark.getUpdatedDate());
        //   slackClient.sendMessage("course id:"+ stu.getCourse());

        return mark;
    }


    //getCreatedAfterDateToSlack :-
    // @Scheduled(cron = "* */15 * * * *")
    public List<Mark> getCreatedAfterDateMark(String createdDate) throws ParseException {
        List<Mark> createdAfterDate = markService.getCreatedAfterDateMark(createdDate);

        slackClient.sendMessage("--- mark data from db to slack (api). getAllMarksByIsActiveFalse ---");
        for (Mark m : createdAfterDate) {
            slackClient.sendMessage("mark id:" + m.getId());
            slackClient.sendMessage("grade:" + m.getGrade());
            slackClient.sendMessage("obtainedMarks:" + m.getObtainedMarks());
            slackClient.sendMessage("course CreatedDate:" + m.getCreatedDate());
            slackClient.sendMessage("course isActive:" + m.getActive());
            slackClient.sendMessage("course UpdatedDate:" + m.getUpdatedDate());
            //   slackClient.sendMessage("course id:"+ stu.getCourse());
        }

        return createdAfterDate;
    }

    //getSchoolByCreatedDate :-
    // @Scheduled(cron = "*/5 * * * * *")
    public List<Mark> getMarkByCreatedDate(String createdDate) throws ParseException {
        List<Mark> mark = markService.getMarkByCreatedDate(createdDate);

        slackClient.sendMessage("--- mark data from db to slack (api). mark/getMarkByCreatedDate ---");
        for (Mark m : mark) {
            slackClient.sendMessage("mark id:" + m.getId());
            slackClient.sendMessage("grade:" + m.getGrade());
            slackClient.sendMessage("obtainedMarks:" + m.getObtainedMarks());
            slackClient.sendMessage("course CreatedDate:" + m.getCreatedDate());
            slackClient.sendMessage("course isActive:" + m.getActive());
            slackClient.sendMessage("course UpdatedDate:" + m.getUpdatedDate());
            //   slackClient.sendMessage("course id:"+ stu.getCourse());
        }

        return mark;
    }
}
