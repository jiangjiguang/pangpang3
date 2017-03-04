package com.pangpang3.model.service;

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
public class TeacherService {
    private static final Logger logger = LoggerFactory.getLogger(TeacherService.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert(Teacher teacher){
        mongoTemplate.insert(teacher);
    }

    public void save(Teacher teacher){
        mongoTemplate.save(teacher);
    }

    public List<Teacher> findAll(){
        return mongoTemplate.findAll(Teacher.class);
    }
}
