package pro.sky.coursework2.repositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursework2.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {

    private QuestionRepository out;

    @BeforeEach
    public void setup(){
        out = new MathQuestionRepository();
        out.add("Math Question 1?", "Math Answer 1");
        out.add("Math Question 2?", "Math Answer 2");
        out.add("Math Question 3?", "Math Answer 3");
        out.add("Math Question 4?", "Math Answer 3");
        out.add("Math Question 5?", "Math Answer 5");
        out.add("Math Question 6?", "Math Answer 6");
        out.add("Math Question 7?", "Math Answer 7");
        out.add("Math Question 8?", "Math Answer 8");
        out.add("Math Question 9?", "Math Answer 9");
        out.add("Math Question 10?", "Math Answer 10");
        out.add("Math Question 11?", "Math Answer 11");
        out.add("Math Question 12?", "Math Answer 12");
    }

    // Add new question
    @Test
    void add_testQuestion() {
        Question expected = new Question("Math Question 111?", "Math Answer 111");
        int sizeExpected = out.getAll().size() + 1;
        Assertions.assertThat(out.add(new Question("Math Question 111?", "Math Answer 111"))).isEqualTo(expected);
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    // Add new String question String answer
    @Test
    void add_testStrings() {
        Question expected = new Question("Math Question 555?", "Math Answer 555");
        int sizeExpected = out.getAll().size() + 1;
        Assertions.assertThat(out.add("Math Question 555?", "Math Answer 555")).isEqualTo(expected);
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    // Add existing question
    @Test
    void add_testExistingQuestion() {
        int sizeExpected = out.getAll().size();
        assertNull(out.add(new Question("Math Question 2?", "Math Answer 2")));
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    // Add existing String question String answer
    @Test
    void add_testExistingStrings() {
        int sizeExpected = out.getAll().size();
        assertNull(out.add("Math Question 7?", "Math Answer 7"));
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    // Remove question
    @Test
    void remove_testQuestion() {
        Question expected = new Question("Math Question 3?", "Math Answer 3");
        int sizeExpected = out.getAll().size() - 1;
        Assertions.assertThat(out.remove(new Question("Math Question 3?", "Math Answer 3"))).isEqualTo(expected);
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    // Remove non-existing question
    @Test
    void remove_testNonExisting() {
        int sizeExpected = out.getAll().size();
        assertNull(out.remove(new Question("Math Question117?", "Math Answer 117")));
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    @Test
    void getAll() {
        Set<Question> expected = new HashSet<>();
        Question question = new Question("Math Question 1?", "Math Answer 1");
        expected.add(question);
        question = new Question("Math Question 2?", "Math Answer 2");
        expected.add(question);
        question = new Question("Math Question 3?", "Math Answer 3");
        expected.add(question);
        question = new Question("Math Question 4?", "Math Answer 3");
        expected.add(question);
        question = new Question("Math Question 5?", "Math Answer 5");
        expected.add(question);
        question = new Question("Math Question 6?", "Math Answer 6");
        expected.add(question);
        question = new Question("Math Question 7?", "Math Answer 7");
        expected.add(question);
        question = new Question("Math Question 8?", "Math Answer 8");
        expected.add(question);
        question = new Question("Math Question 9?", "Math Answer 9");
        expected.add(question);
        question = new Question("Math Question 10?", "Math Answer 10");
        expected.add(question);
        question = new Question("Math Question 11?", "Math Answer 11");
        expected.add(question);
        question = new Question("Math Question 12?", "Math Answer 12");
        expected.add(question);

        Assertions.assertThat(out.getAll()).containsExactlyInAnyOrderElementsOf(expected).hasSize(expected.size());
    }
}