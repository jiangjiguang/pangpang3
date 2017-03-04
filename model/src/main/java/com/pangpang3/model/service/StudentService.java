package com.pangpang3.model.service;

import com.pangpang3.dao.mongodb.entity.Student;
import com.pangpang3.dao.mongodb.entity.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by root on 17-3-4.
 */
@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert(Student student){
        mongoTemplate.insert(student);
    }

    public void save(Student student){
        mongoTemplate.save(student);
    }

    public List<Student> findAll(){
        return mongoTemplate.findAll(Student.class);
    }
}
