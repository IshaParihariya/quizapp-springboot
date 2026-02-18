package com.isha.quizapp.controller;

import com.isha.quizapp.Question;
import com.isha.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.List;


//client -> Controller → Service → Repository (DAO) → Database

@RestController
@RequestMapping("question")
public class QuestionController
{

    @Autowired
    QuestionService questionService;


    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() // returning list of objects
    {
        try
        {
            return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    // for getting by category

    /*
    if the parameter and this cat are not same then..
    @GetMapping("category/{cat}"
    public List<Question> getAllQuestionsByCategory(@PathVariable("cat") String category)
     */
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getAllQuestionsByCategory(@PathVariable String category) {
        try
        {
            return new ResponseEntity<>(questionService.getAllQuestionsByCategory(category), HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace(); // This prints error in console ; used for Debugging
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    // for adding questions i.e., the user will post questions there
    @PostMapping("add") // post mapping is used for taking data as i/p from user
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        try
        {
            return new ResponseEntity<>(questionService.addQuestion(question),HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
    }
}
