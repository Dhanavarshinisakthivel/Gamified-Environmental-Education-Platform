package com.dhanavarshini.greenlearn.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dhanavarshini.greenlearn.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	List<Question> findByCategory(String category);
}