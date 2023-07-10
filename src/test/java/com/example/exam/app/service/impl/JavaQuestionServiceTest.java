package com.example.exam.app.service.impl;

import com.example.exam.app.exceptions.QuestionNotFoundException;
import com.example.exam.app.model.Question;
import com.example.exam.app.service.QuestionService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.exam.app.service.impl.ConstantsForTest.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void addConstants() {
        questionService.add(QUESTION1);
        questionService.add(QUESTION2);
        questionService.add(QUESTION3);
    }

    @Test
    public void shouldAddQuestions() {
        int beforeAdding = questionService.getAll().size();

        assertThat(questionService.add(QUESTION4))
                .isEqualTo(QUESTION4)
                .isIn(questionService.getAll());

        assertThat(questionService.getAll()).hasSize(beforeAdding + 1);
    }
    @Test
    public void shouldRemoveQuestions() {

        int beforeAdding = questionService.getAll().size();

        assertThat(questionService.remove(QUESTION1))
                .isEqualTo(QUESTION1)
                .isNotIn(questionService.getAll());

        assertThat(questionService.getAll()).hasSize(beforeAdding - 1);
    }

    @Test
    public void shouldThrowQuestionNotFoundException() {

        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> questionService.remove(new Question("INCORRECT", "INCORRECT")));
    }

    @Test
    public void shouldReturnAll() {

        assertThat(questionService.getAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        QUESTION1,
                        QUESTION2,
                        QUESTION3
                );
    }

    @Test
    public void shouldReturnRandomQuestion() {
        assertThat(questionService.getRandomQuestion())
                .isNotNull()
                .isIn(questionService.getAll());
    }

}