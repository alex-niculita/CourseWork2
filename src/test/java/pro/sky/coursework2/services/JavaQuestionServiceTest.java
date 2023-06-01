package pro.sky.coursework2.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.repositories.QuestionRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    Set<Question> testSet;

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private JavaQuestionService out;

    @BeforeEach
    public void setup(){
        out = new JavaQuestionService(questionRepository);

        testSet = new HashSet<>();

        Question question = new Question("Java Question 1?", "Java Answer 1");
        testSet.add(question);
        question = new Question("Java Question 2?", "Java Answer 2");
        testSet.add(question);
        question = new Question("Java Question 3?", "Java Answer 3");
        testSet.add(question);
        question = new Question("Java Question 4?", "Java Answer 4");
        testSet.add(question);
        question = new Question("Java Question 5?", "Java Answer 5");
        testSet.add(question);

    }

    // Add new question
    @Test
    void add_testQuestion() {
        Question testQuestion = new Question("Java Question 111?", "Java Answer 111");
        when(questionRepository.add(testQuestion)).thenReturn(new Question("Java Question 111?", "Java Answer 111"));

        Question expected = new Question("Java Question 111?", "Java Answer 111");

        Assertions.assertThat(out.add(new Question("Java Question 111?", "Java Answer 111"))).isEqualTo(expected);

    }

    // Add new String question String answer
    @Test
    void add_testStrings() {
        Question testQuestion = new Question("Java Question 111?", "Java Answer 111");
        when(questionRepository.add(testQuestion)).thenReturn(new Question("Java Question 111?", "Java Answer 111"));

        Question expected = new Question("Java Question 111?", "Java Answer 111");

        Assertions.assertThat(out.add("Java Question 111?", "Java Answer 111")).isEqualTo(expected);
    }

    // Add existing question
    @Test
    void add_testExistingQuestion() {
        Question testQuestion = new Question("Java Question 2?", "Java Answer 2");
        when(questionRepository.add(testQuestion)).thenReturn(null);

        assertNull(out.add(new Question("Java Question 2?", "Java Answer 2")));

    }

    // Add existing String question String answer
    @Test
    void add_testExistingStrings() {
        Question testQuestion = new Question("Java Question 2?", "Java Answer 2");
        when(questionRepository.add(testQuestion)).thenReturn(null);

        assertNull(out.add("Java Question 2?", "Java Answer 2"));
    }

    // Remove question
    @Test
    void remove_testQuestion() {
        Question testQuestion = new Question("Java Question 3?", "Java Answer 3");
        when(questionRepository.remove(testQuestion)).thenReturn(new Question("Java Question 3?", "Java Answer 3"));

        Question expected = new Question("Java Question 3?", "Java Answer 3");

        Assertions.assertThat(out.remove(new Question("Java Question 3?", "Java Answer 3"))).isEqualTo(expected);

    }

    // Remove non-existing question
    @Test
    void remove_testNonExisting() {
        Question testQuestion = new Question("Java Question 13?", "Java Answer 13");
        when(questionRepository.remove(testQuestion)).thenReturn(null);

        assertNull(out.remove(new Question("Java Question 13?", "Java Answer 13")));
    }

    @Test
    void getAll() {
        when(questionRepository.getAll()).thenReturn(testSet);

        Set<Question> expectedSet = new HashSet<>();

        Question question = new Question("Java Question 1?", "Java Answer 1");
        expectedSet.add(question);
        question = new Question("Java Question 2?", "Java Answer 2");
        expectedSet.add(question);
        question = new Question("Java Question 3?", "Java Answer 3");
        expectedSet.add(question);
        question = new Question("Java Question 4?", "Java Answer 4");
        expectedSet.add(question);
        question = new Question("Java Question 5?", "Java Answer 5");
        expectedSet.add(question);

        Assertions.assertThat(out.getAll()).containsExactlyInAnyOrderElementsOf(expectedSet).hasSize(expectedSet.size());

    }

    // Generates non-null result
    @Test
    void getRandomQuestion_testNonNull() {
        when(questionRepository.getAll()).thenReturn(testSet);
        assertNotNull(out.getRandomQuestion());
    }

    // Generates Question
    @Test
    void getRandomQuestion_testQuestion() {
        when(questionRepository.getAll()).thenReturn(testSet);

        Set<Question> expectedSet = new HashSet<>();

        Question question = new Question("Java Question 1?", "Java Answer 1");
        expectedSet.add(question);
        question = new Question("Java Question 2?", "Java Answer 2");
        expectedSet.add(question);
        question = new Question("Java Question 3?", "Java Answer 3");
        expectedSet.add(question);
        question = new Question("Java Question 4?", "Java Answer 4");
        expectedSet.add(question);
        question = new Question("Java Question 5?", "Java Answer 5");
        expectedSet.add(question);

        Assertions.assertThat(out.getRandomQuestion()).isIn(expectedSet);
    }
}