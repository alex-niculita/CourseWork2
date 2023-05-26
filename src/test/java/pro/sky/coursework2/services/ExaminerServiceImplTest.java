package pro.sky.coursework2.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.exceptions.AmountOutOfSizeException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Spy
    private JavaQuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    private void setUp() {
        questionService.add("Question 1", "Answer 1");
        questionService.add("Question 2", "Answer 2");
        questionService.add("Question 3", "Answer 3");
        questionService.add("Question 4", "Answer 4");
        questionService.add("Question 5", "Answer 5");
        questionService.add("Question 6", "Answer 6");
        questionService.add("Question 7", "Answer 7");
        questionService.add("Question 8", "Answer 8");
        questionService.add("Question 9", "Answer 9");
        questionService.add("Question 10", "Answer 10");
    }


    @Test
    void getQuestions() {
        Assertions.assertThat(out.getQuestions(3)).hasSize(3);
    }

    @Test
    void getQuestions_negativeAmount() {
        assertThrows(AmountOutOfSizeException.class, ()->out.getQuestions(-3));
    }

    @Test
    void getQuestions_tooLargeAmount() {
        assertThrows(AmountOutOfSizeException.class, ()->out.getQuestions(77));
    }

}