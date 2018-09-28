package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data 
@Entity // This tells Hibernate to make a table out of this class

public class Blog {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String name;
    private String content;

    public Blog(String name, String content) {
        this.name = name;
        this.content = content;
    }
}