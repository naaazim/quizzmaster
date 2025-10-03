package com.example.RegisterLogin.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
public interface QuestionRepository extends JpaRepository<Question,Long>{
    Question findById (long id); 
    List<Question> findByExamenId (long id);
}
