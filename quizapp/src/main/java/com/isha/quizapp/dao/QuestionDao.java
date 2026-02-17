package com.isha.quizapp.dao;

import com.isha.quizapp.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// We extend JpaRepository because:
// saves time
// no SQL needed
// no implementation needed
// Spring handles everything


// Question → Entity class
// Integer → Primary key type

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>
{
}
