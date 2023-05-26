package pro.sky.coursework2.services;

import org.assertj.core.api.Assertions;
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