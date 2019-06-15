package com.example.examplefinal.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ExamTeacher {
    @Id
    private int id;
    @ManyToOne
    private Exam exam;
    @ManyToOne
    private Teacher teacher;
}
