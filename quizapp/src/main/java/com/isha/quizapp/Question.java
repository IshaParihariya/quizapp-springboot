package com.isha.quizapp;

import jakarta.persistence.*;
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

    // writing this because in SQL we using snake_case
    // and in Jave camelCase so need to tell jpa that this is the column name in SQL
    @Column(name = "question_title")
    private String questionTitle;
    private String category;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    @Column(name = "right_answer")
    private String rightAnswer;

    @Column(name = "difficulty_level")
    private String difficultyLevel;
}
