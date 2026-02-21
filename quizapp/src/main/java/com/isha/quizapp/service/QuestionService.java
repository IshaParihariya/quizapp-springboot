package com.isha.quizapp.service;

import com.isha.quizapp.Question;
import com.isha.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        try {
            return questionDao.findAll(); // findAll method will get the list of questions
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        // if exception
        return new ArrayList<>();
    }

    public List<Question> getAllQuestionsByCategory(String category)
    {
        try
        {
            return questionDao.findByCategory(category);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // for question based on the difficulty level
    public List<Question> getAllQuestionsByDifficultyLevel(String difficultyLevel)
    {
        return questionDao.findAll(); // find all the questions with the same level of difficulty
    }

    public String addQuestion(Question question)
    {
        questionDao.save(question);
        return "success";
    }
}
