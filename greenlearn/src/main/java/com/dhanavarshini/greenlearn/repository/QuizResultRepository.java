package com.dhanavarshini.greenlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhanavarshini.greenlearn.entity.QuizResult;

public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {

    List<QuizResult> findByUserId(Long userId);

}