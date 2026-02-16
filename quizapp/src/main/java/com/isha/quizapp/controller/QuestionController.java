package com.isha.quizapp.controller;

import com.isha.quizapp.Question;
import com.isha.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController
{

    @Autowired
    QuestionService questionService;


    @GetMapping("allQuestions")
    public List<Question> getAllQuestions()
    {
        return questionService.getAllQuestions();
    }

}
