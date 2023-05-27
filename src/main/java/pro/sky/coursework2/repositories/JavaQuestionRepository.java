package pro.sky.coursework2.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pro.sky.coursework2.Question;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
@Primary
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> javaQuestions = new HashSet<>();

    @PostConstruct
    private void init() {
        Question question = new Question("Java Question 1?", "Java Answer 1");
        javaQuestions.add(question);
        question = new Question("Java Question 2?", "Java Answer 2");
        javaQuestions.add(question);
        question = new Question("Java Question 3?", "Java Answer 3");
        javaQuestions.add(question);
        question = new Question("Java Question 4?", "Java Answer 3");
        javaQuestions.add(question);
        question = new Question("Java Question 5?", "Java Answer 5");
        javaQuestions.add(question);
        question = new Question("Java Question 6?", "Java Answer 6");
        javaQuestions.add(question);
        question = new Question("Java Question 7?", "Java Answer 7");
        javaQuestions.add(question);
        question = new Question("Java Question 8?", "Java Answer 8");
        javaQuestions.add(question);
        question = new Question("Java Question 9?", "Java Answer 9");
        javaQuestions.add(question);
        question = new Question("Java Question 10?", "Java Answer 10");
        javaQuestions.add(question);
        question = new Question("Java Question 11?", "Java Answer 11");
        javaQuestions.add(question);
        question = new Question("Java Question 12?", "Java Answer 12");
        javaQuestions.add(question);
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question,answer);
        return add(q);
    }

    @Override
    public Question add(Question question) {
        return javaQuestions.add(question)?question:null;
    }

    @Override
    public Question remove(Question question) {
        return javaQuestions.remove(question)?question:null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(javaQuestions);
    }
}
