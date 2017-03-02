package com.pangpang3.dao.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by root on 17-3-2.
 */
@Document
public class Person {

    @Id
    private String id;

    @Indexed
    private Integer ssn;

    private String firstName;

    @Indexed
    private String lastName;
}
