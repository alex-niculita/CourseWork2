package pro.sky.coursework2.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursework2.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private QuestionService out;

    @BeforeEach
    public void setup(){
        out = new JavaQuestionService();
    }

    // Add new question
    @Test
    void add_testQuestion() {
        Question expected = new Question("Question 111?", "Answer 111");
        int sizeExpected = out.getAll().size() + 1;
        Assertions.assertThat(out.add(new Question("Question 111?", "Answer 111"))).isEqualTo(expected);
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    // Add new String question String answer
    @Test
    void add_testStrings() {
        Question expected = new Question("Question 555?", "Answer 555");
        int sizeExpected = out.getAll().size() + 1;
        Assertions.assertThat(out.add("Question 555?", "Answer 555")).isEqualTo(expected);
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    // Add existing question
    @Test
    void add_testExistingQuestion() {
        int sizeExpected = out.getAll().size();
        assertNull(out.add(new Question("Question 2?", "Answer 2")));
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    // Add existing String question String answer
    @Test
    void add_testExistingStrings() {
        int sizeExpected = out.getAll().size();
        assertNull(out.add("Question 7?", "Answer 7"));
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    // Remove question
    @Test
    void remove_testQuestion() {
        Question expected = new Question("Question 3?", "Answer 3");
        int sizeExpected = out.getAll().size() - 1;
        Assertions.assertThat(out.remove(new Question("Question 3?", "Answer 3"))).isEqualTo(expected);
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    // Remove non-existing question
    @Test
    void remove_testNonExisting() {
        int sizeExpected = out.getAll().size();
        assertNull(out.remove(new Question("Question 117?", "Answer 117")));
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    @Test
    void getAll() {
        Set<Question> expected = new HashSet<>();
        Question question = new Question("Question 1?", "Answer 1");
        expected.add(question);
        question = new Question("Question 2?", "Answer 2");
        expected.add(question);
        question = new Question("Question 3?", "Answer 3");
        expected.add(question);
        question = new Question("Question 4?", "Answer 3");
        expected.add(question);
        question = new Question("Question 5?", "Answer 5");
        expected.add(question);
        question = new Question("Question 6?", "Answer 6");
        expected.add(question);
        question = new Question("Question 7?", "Answer 7");
        expected.add(question);
        question = new Question("Question 8?", "Answer 8");
        expected.add(question);
        question = new Question("Question 9?", "Answer 9");
        expected.add(question);
        question = new Question("Question 10?", "Answer 10");
        expected.add(question);
        question = new Question("Question 11?", "Answer 11");
        expected.add(question);
        question = new Question("Question 12?", "Answer 12");
        expected.add(question);

        Assertions.assertThat(out.getAll()).containsExactlyInAnyOrderElementsOf(expected).hasSize(expected.size());

    }

    // Generates non-null result
    @Test
    void getRandomQuestion_testNonNull() {
        assertNotNull(out.getRandomQuestion());
    }

    // Generates Question
    @Test
    void getRandomQuestion_testQuestion() {
        Collection<Question> questionSet = out.getAll();
        Assertions.assertThat(out.getRandomQuestion()).isIn(questionSet);
    }
}