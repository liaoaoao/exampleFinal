package com.example.examplefinal.Repository;

import com.example.examplefinal.Entity.Exam;
import com.example.examplefinal.Entity.ExamTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ExamRepository extends JpaRepository<Exam,Integer> {
}
