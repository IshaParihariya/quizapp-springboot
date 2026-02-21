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


/*
This line allows frontend to access backend
CORS - Cross Origin Resource Sharing
CORS allows frontend and backend running on different origins to communicate
 */
@CrossOrigin(origins = "*")

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
    public ResponseEntity<List<Question>> getAllQuestionsByCategory(@PathVariable String category)
    {
        try
        {
            return new ResponseEntity<>(questionService.getAllQuestionsByCategory(category), HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace(); // This prints error in console ; used for Debugging
                                 // example : Database connection failed
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    // for category based on level of the questions
    @GetMapping("difficultyLevel/{difficultyLevel}")
        public ResponseEntity<List<Question>> getAllQuestionsByDifficultyLevel(@PathVariable String difficultyLevel)
    {
        try
        {
            return new ResponseEntity<>(questionService.getAllQuestionsByDifficultyLevel(difficultyLevel),HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    // for adding questions i.e., the user will post questions there
    @PostMapping("add") // post mapping is used for taking data as i/p from user
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        try
        {
            //ResponseEntity here send the status code to the frontend
            //if status == 200 → success
            //if status == 400 → error
            return new ResponseEntity<>(questionService.addQuestion(question),HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error Occurred", HttpStatus.BAD_REQUEST);
    }
}
