package pro.sky.coursework2.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.exceptions.AmountOutOfSizeException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    Set<Question> testSet1;
    Set<Question> testSet2;

    @Mock
    private QuestionService javaQuestionService;

    @Mock
    private QuestionService mathQuestionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    public void setUp() {
        out = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);

        testSet1 = new HashSet<>();
        testSet2 = new HashSet<>();

        Question question = new Question("Java Question 1?", "Java Answer 1");
        testSet1.add(question);
        question = new Question("Java Question 2?", "Java Answer 2");
        testSet1.add(question);
        question = new Question("Java Question 3?", "Java Answer 3");
        testSet1.add(question);
        question = new Question("Java Question 4?", "Java Answer 4");
        testSet1.add(question);
        question = new Question("Java Question 5?", "Java Answer 5");
        testSet1.add(question);

        question = new Question("Math Question 6?", "Math Answer 6");
        testSet2.add(question);
        question = new Question("Math Question 7?", "Math Answer 7");
        testSet2.add(question);
        question = new Question("Math Question 8?", "Math Answer 8");
        testSet2.add(question);
        question = new Question("Math Question 9?", "Math Answer 9");
        testSet2.add(question);
        question = new Question("Math Question 10?", "Math Answer 10");
        testSet2.add(question);

        when(javaQuestionService.getAll()).thenReturn(testSet1);
        when(mathQuestionService.getAll()).thenReturn(testSet2);

    }

    @Test
    void getQuestions() {
        when(javaQuestionService.getRandomQuestion()).thenReturn(new Question("Java Question 1?", "Java Answer 1"))
                .thenReturn(new Question("Java Question 2?", "Java Answer 2"))
                .thenReturn(new Question("Java Question 3?", "Java Answer 3"))
                .thenReturn(new Question("Java Question 4?", "Java Answer 4"))
                .thenReturn(new Question("Java Question 5?", "Java Answer 5"))
                .thenReturn(new Question("Math Question 6?", "Math Answer 6"))
                .thenReturn(new Question("Math Question 7?", "Math Answer 7"))
                .thenReturn(new Question("Math Question 8?", "Math Answer 8"))
                .thenReturn(new Question("Math Question 9?", "Math Answer 9"))
                .thenReturn(new Question("Math Question 10?", "Math Answer 10"));
        Assertions.assertThat(out.getQuestions(5)).hasSize(5);
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