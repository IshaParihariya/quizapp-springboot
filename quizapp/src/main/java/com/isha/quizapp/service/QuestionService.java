package com.isha.quizapp.service;

import com.isha.quizapp.Question;
import com.isha.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service layer fetches data from DAO layer
//(DAO layer in Spring Boot is usually called the Repository layer)
@Service
public class QuestionService
{
    @Autowired
    QuestionDao questionDao; // object of class QuestionDao

    public List<Question> getAllQuestions()
    {
        return questionDao.findAll(); // finnd all method will get the list of questions
    }
}
