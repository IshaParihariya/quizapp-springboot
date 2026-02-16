package com.isha.quizapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// entity class

@Data // lombok annotation : creates getter setter toString automatically
@Entity // tells this is a database without this no table is created

public class Question // this is the table name
{
    @Id // to make the id primary key(unique id)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // if not having lombok then we need to write getter and setter methods as well

    // all columns from the database
    private Integer id;
    private String questionTitle;
    private String category;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;
}
