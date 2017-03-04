package com.pangpang3.model.service;

import com.pangpang3.dao.mongodb.entity.Person;
import com.pangpang3.dao.mongodb.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by root on 17-3-4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mongodb.xml")
public class TeacherServiceTest {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    public  void test(){
        Teacher teacher = new Teacher();
        teacher.setTeachId("1");
        teacher.setTeacherName("jiangjg");
        mongoTemplate.insert(teacher);
    }
}
