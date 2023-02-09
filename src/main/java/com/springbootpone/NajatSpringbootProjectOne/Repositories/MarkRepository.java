package com.springbootpone.NajatSpringbootProjectOne.Repositories;


import com.springbootpone.NajatSpringbootProjectOne.Models.Mark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends CrudRepository<Mark,Integer> {
}
