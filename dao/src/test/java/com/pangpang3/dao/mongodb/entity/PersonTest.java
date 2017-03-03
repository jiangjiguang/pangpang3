package com.pangpang3.dao.mongodb.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by root on 17-3-2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mongodb.xml")
public class PersonTest {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
   public  void test(){
        Person person = new Person();
        person.setFirstName("jiangjg");
        mongoTemplate.insert(person);
    }
}
