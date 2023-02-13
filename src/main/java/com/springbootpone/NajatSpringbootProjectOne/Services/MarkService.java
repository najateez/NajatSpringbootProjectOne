package com.springbootpone.NajatSpringbootProjectOne.Services;

import com.springbootpone.NajatSpringbootProjectOne.Models.Course;
import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
import com.springbootpone.NajatSpringbootProjectOne.Models.School;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.CourseRepository;
import com.springbootpone.NajatSpringbootProjectOne.Repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {

    @Autowired   // it is dependancy injection
    MarkRepository markRepository;

    public void addMark(){

        Mark markObj=new Mark();
        markObj.setObtainedMarks(82);
        markObj.setGrade("very good");
        markRepository.save(markObj);
    }

    public List<Mark> getAllMarks() {

        return markRepository.getAllMarks();
    }

    public void deleteMarkById(Integer id){
        Mark markToDelete = markRepository.findById(id).get();
        markRepository.delete(markToDelete);
    }

    //getById
    public Mark getMarkById(Integer id){
        Mark mark = markRepository.getMarkById(id);
        return mark;
    }

    //getBySchoolName :-
    public Mark getMarkByObtainedMarks(Integer obtainedMarks) {
        Mark mark = markRepository.getMarkByObtainedMarks(obtainedMarks);
        return mark;
    }
}
