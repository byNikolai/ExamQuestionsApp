package com.example.exam.app.service.impl;

import com.example.exam.app.model.Question;

import java.util.Collection;
import java.util.Set;

public class ConstantsForTest {

    public static final Question QUESTION1 = new Question("Q1", "A1");
    public static final Question QUESTION2 = new Question("Q2", "A2");
    public static final Question QUESTION3 = new Question("Q3", "A3");
    public static final Question QUESTION4 = new Question("Q4", "A4");
    public static final Question QUESTION5 = new Question("Q5", "A5");

    public static final Collection<Question> MOCK_QUESTIONS = Set.of(
            QUESTION1,
            QUESTION2,
            QUESTION3,
            QUESTION5
    );
}
