package pro.sky.coursework2.repositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursework2.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {
    private QuestionRepository out;

    @BeforeEach
    public void setup(){
        out = new JavaQuestionRepository();
        out.add("Java Question 1?", "Java Answer 1");
        out.add("Java Question 2?", "Java Answer 2");
        out.add("Java Question 3?", "Java Answer 3");
        out.add("Java Question 4?", "Java Answer 3");
        out.add("Java Question 5?", "Java Answer 5");
        out.add("Java Question 6?", "Java Answer 6");
        out.add("Java Question 7?", "Java Answer 7");
        out.add("Java Question 8?", "Java Answer 8");
        out.add("Java Question 9?", "Java Answer 9");
        out.add("Java Question 10?", "Java Answer 10");
        out.add("Java Question 11?", "Java Answer 11");
        out.add("Java Question 12?", "Java Answer 12");
    }

    // Add new question
    @Test
    void add_testQuestion() {
        Question expected = new Question("Java Question 111?", "Java Answer 111");
        int sizeExpected = out.getAll().size() + 1;
        Assertions.assertThat(out.add(new Question("Java Question 111?", "Java Answer 111"))).isEqualTo(expected);
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    // Add new String question String answer
    @Test
    void add_testStrings() {
        Question expected = new Question("Java Question 555?", "Java Answer 555");
        int sizeExpected = out.getAll().size() + 1;
        Assertions.assertThat(out.add("Java Question 555?", "Java Answer 555")).isEqualTo(expected);
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    // Add existing question
    @Test
    void add_testExistingQuestion() {
        int sizeExpected = out.getAll().size();
        assertNull(out.add(new Question("Java Question 2?", "Java Answer 2")));
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    // Add existing String question String answer
    @Test
    void add_testExistingStrings() {
        int sizeExpected = out.getAll().size();
        assertNull(out.add("Java Question 7?", "Java Answer 7"));
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    // Remove question
    @Test
    void remove_testQuestion() {
        Question expected = new Question("Java Question 3?", "Java Answer 3");
        int sizeExpected = out.getAll().size() - 1;
        Assertions.assertThat(out.remove(new Question("Java Question 3?", "Java Answer 3"))).isEqualTo(expected);
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    // Remove non-existing question
    @Test
    void remove_testNonExisting() {
        int sizeExpected = out.getAll().size();
        assertNull(out.remove(new Question("Java Question117?", "Java Answer 117")));
        Assertions.assertThat(out.getAll()).hasSize(sizeExpected);
    }

    @Test
    void getAll() {
        Set<Question> expected = new HashSet<>();
        Question question = new Question("Java Question 1?", "Java Answer 1");
        expected.add(question);
        question = new Question("Java Question 2?", "Java Answer 2");
        expected.add(question);
        question = new Question("Java Question 3?", "Java Answer 3");
        expected.add(question);
        question = new Question("Java Question 4?", "Java Answer 3");
        expected.add(question);
        question = new Question("Java Question 5?", "Java Answer 5");
        expected.add(question);
        question = new Question("Java Question 6?", "Java Answer 6");
        expected.add(question);
        question = new Question("Java Question 7?", "Java Answer 7");
        expected.add(question);
        question = new Question("Java Question 8?", "Java Answer 8");
        expected.add(question);
        question = new Question("Java Question 9?", "Java Answer 9");
        expected.add(question);
        question = new Question("Java Question 10?", "Java Answer 10");
        expected.add(question);
        question = new Question("Java Question 11?", "Java Answer 11");
        expected.add(question);
        question = new Question("Java Question 12?", "Java Answer 12");
        expected.add(question);

        Assertions.assertThat(out.getAll()).containsExactlyInAnyOrderElementsOf(expected).hasSize(expected.size());

    }
}