package com.example.exam.app.service;

import com.example.exam.app.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
