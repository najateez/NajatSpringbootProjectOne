package com.springbootpone.NajatSpringbootProjectOne.ScheduledJobs;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Models.Student;
import com.springbootpone.NajatSpringbootProjectOne.Services.CourseService;
import com.springbootpone.NajatSpringbootProjectOne.Services.MarkService;
import com.springbootpone.NajatSpringbootProjectOne.Services.SchoolService;
import com.springbootpone.NajatSpringbootProjectOne.Services.StudentService;
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
// CRON for all classes will be here
@Component
public class Schedule {

    @Autowired
    SlackClient slackClient;  //to which channel in slack you want to send data's.

    @Autowired
    SchoolService schoolService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    @Autowired
    MarkService markService;

    //should send data's to slack every 5 minutes.
    //second,minute,hour,day of the month, month, day of the week.
    @Scheduled (cron="* */5 * * * *")

 //   public void alertSlack(){
        //Get functions for school,student,course,mark.

    // Same code as firstController
        @RequestMapping(value = "school/getAll", method = RequestMethod.GET)
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
    //exp: localhost:8080/school/getById?schoolId=2
    @RequestMapping(value = "school/getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
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
    //exp: localhost:8080/school/getByColumnSchoolName?schoolName=biryani
    @RequestMapping(value = "school/getByColumnSchoolName", method = RequestMethod.GET)
    public School getSchoolBySchoolName(@RequestParam String schoolName) {
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
    //exp: localhost:8080/getAllSchoolsByIsActive
    @RequestMapping(value = "getAllSchoolsByIsActive")
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
    @RequestMapping(value = "getAllSchoolsByIsActiveFalse")
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
    // exp: localhost:8080/school/getLatestRowSchool
    @RequestMapping(value = "school/getLatestRowSchool")
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
    //exp: localhost:8080/school/getLatestUpdatedSchool
    @RequestMapping(value = "school/getLatestUpdatedSchool", method = RequestMethod.GET)
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
    //exp: localhost:8080/school/getSchoolCreatedAfterDate?createdDate=1111-12-12 00:00:00.0000000
    @RequestMapping(value = "school/getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public List<School> getCreatedAfterDateSchool(@RequestParam String createdDate) throws ParseException {
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
    //exp: localhost:8080/school/getSchoolByNumberOfStudent?numberOfStudent=4
    @RequestMapping(value = "school/getSchoolByNumberOfStudent", method = RequestMethod.POST)
    public List<School> getSchoolByNumberOfStudent(@RequestParam Integer numberOfStudent) {

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
    //exp: localhost:8080/school/getSchoolByCreatedDate?createdDate=7575-12-11 00:00:00.0000000
    @RequestMapping(value = "school/getSchoolByCreatedDate", method = RequestMethod.GET)
    public List<School> getSchoolByCreatedDate(@RequestParam String createdDate) throws ParseException {
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

    // -------------- for student table ----------------------------

    //getAllToSlack
    //exp: localhost:8080/student/getAll
    @RequestMapping(value = "student/getAll", method = RequestMethod.GET)
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
    @RequestMapping(value = "student/getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer studentId) {
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
    //exp: localhost:8080/student/getByColumnStudentName?studentName=pppp
    @RequestMapping(value = "student/getByColumnStudentName", method = RequestMethod.GET)
    public Student getStudentByStudentName(@RequestParam String studentName) {
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
    @RequestMapping(value = "getAllStudentsByIsActive")
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
    //exp: localhost:8080/getAllStudentsByIsActiveFalse
    @RequestMapping(value = "getAllStudentsByIsActiveFalse")
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
    // exp: localhost:8080/student/getLatestRowStudent
    @RequestMapping(value = "student/getLatestRowStudent")
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
    @RequestMapping(value = "student/getLatestUpdatedStudent", method = RequestMethod.GET)
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
    @RequestMapping(value = "student/getStudentCreatedAfterDate", method = RequestMethod.GET)
    public List<Student> getCreatedAfterDateStudent(@RequestParam String createdDate) throws ParseException {
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
    //exp: localhost:8080/student/getStudentByCreatedDate?createdDate=2012-06-02 00:00:00.0000000
    @RequestMapping(value = "student/getStudentByCreatedDate", method = RequestMethod.GET)
    public List<Student> getStudentByCreatedDate(@RequestParam String createdDate) throws ParseException {
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

    // -------------- for course table ----------------------------

    //getAllToSlack
    //exp: localhost:8080/course/getAll
    @RequestMapping(value = "course/getAll", method = RequestMethod.GET)
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
    //localhost:8080/course/getById?courseId=6
    @RequestMapping(value = "course/getById", method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer courseId) {
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
    //exp: localhost:8080/course/getByColumnCourseName?courseName=java ee
    @RequestMapping(value = "course/getByColumnCourseName", method = RequestMethod.GET)
    public Course getCourseByCourseName(@RequestParam String courseName) {
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
    @RequestMapping(value = "getAllCoursesByIsActive")
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
    @RequestMapping(value = "getAllCoursesByIsActiveFalse")
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
    // exp: localhost:8080/course/getLatestRowCourse
    @RequestMapping(value = "course/getLatestRowCourse")
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
    //exp: localhost:8080/course/getLatestUpdatedCourse
    @RequestMapping(value = "course/getLatestUpdatedCourse", method = RequestMethod.GET)
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
    //exp: localhost:8080/course/getCourseByCreatedDate?createdDate=1111-04-03 00:00:00.0000000
    @RequestMapping(value = "course/getCourseByCreatedDate", method = RequestMethod.GET)
    public List<Course> getCourseByCreatedDate(@RequestParam String createdDate) throws ParseException {
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

    // -------------- for mark table ----------------------------

    //getAllToSlack :-
    @RequestMapping(value = "mark/getAll", method = RequestMethod.GET)
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
    @RequestMapping(value = "mark/getById", method = RequestMethod.GET)
    public Mark getMarkById(@RequestParam Integer markId) {
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
    //exp: localhost:8080/mark/getByColumnObtainedMarks?obtainedMarks=82
    @RequestMapping(value = "mark/getByColumnObtainedMarks", method = RequestMethod.GET)
    public Mark getCourseByCourseName(@RequestParam Integer obtainedMarks) {
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
    //exp: localhost:8080/getAllMarksByIsActive
    @RequestMapping(value = "getAllMarksByIsActive")
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
    // localhost:8080/getAllMarksByIsActiveFalse
    @RequestMapping(value = "getAllMarksByIsActiveFalse")
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
    // exp: localhost:8080/mark/getLatestRowMark
    @RequestMapping(value = "mark/getLatestRowMark")
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
    @RequestMapping(value = "mark/getLatestUpdatedMark", method = RequestMethod.GET)
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
    @RequestMapping(value = "mark/getMarkCreatedAfterDate", method = RequestMethod.GET)
    public List<Mark> getCreatedAfterDateMark(@RequestParam String createdDate) throws ParseException {
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
    //exp: localhost:8080/mark/getMarkByCreatedDate?createdDate=1234-05-06 00:00:00.0000000
    @RequestMapping(value = "mark/getMarkByCreatedDate", method = RequestMethod.GET)
    public List<Mark> getMarkByCreatedDate(@RequestParam String createdDate) throws ParseException {
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


  //  }
}
