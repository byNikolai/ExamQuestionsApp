package com.example.exam.app.service.impl;

import com.example.exam.app.exceptions.IncorrectAmountOfQuestionsException;
import com.example.exam.app.service.ExaminerService;
import com.example.exam.app.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.exam.app.service.impl.ConstantsForTest.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void shouldThrowIncorrectAmountOfQuestionsException() {
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);

        assertThatExceptionOfType(IncorrectAmountOfQuestionsException.class)
                .isThrownBy(() -> examinerService.getQuestions(-2));
        assertThatExceptionOfType(IncorrectAmountOfQuestionsException.class)
                .isThrownBy(() -> examinerService.getQuestions(MOCK_QUESTIONS.size() + 1));
    }

    @Test
    public void shouldReturnQuestions() {
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);
        when(questionService.getRandomQuestion()).thenReturn(
                QUESTION1,
                QUESTION2,
                QUESTION3,
                QUESTION5
        );

        int questionAmount = MOCK_QUESTIONS.size() - 2;

        assertThat(examinerService.getQuestions(questionAmount))
                .hasSize(questionAmount);

    }

}