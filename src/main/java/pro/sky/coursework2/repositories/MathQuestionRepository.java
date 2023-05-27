package pro.sky.coursework2.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pro.sky.coursework2.Question;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
@Component("mathQuestionRepository")
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> mathQuestions = new HashSet<>();

    @PostConstruct
    private void init() {
        Question question = new Question("Math Question 1?", "Math Answer 1");
        mathQuestions.add(question);
        question = new Question("Math Question 2?", "Math Answer 2");
        mathQuestions.add(question);
        question = new Question("Math Question 3?", "Math Answer 3");
        mathQuestions.add(question);
        question = new Question("Math Question 4?", "Math Answer 3");
        mathQuestions.add(question);
        question = new Question("Math Question 5?", "Math Answer 5");
        mathQuestions.add(question);
        question = new Question("Math Question 6?", "Math Answer 6");
        mathQuestions.add(question);
        question = new Question("Math Question 7?", "Math Answer 7");
        mathQuestions.add(question);
        question = new Question("Math Question 8?", "Math Answer 8");
        mathQuestions.add(question);
        question = new Question("Math Question 9?", "Math Answer 9");
        mathQuestions.add(question);
        question = new Question("Math Question 10?", "Math Answer 10");
        mathQuestions.add(question);
        question = new Question("Math Question 11?", "Math Answer 11");
        mathQuestions.add(question);
        question = new Question("Math Question 12?", "Math Answer 12");
        mathQuestions.add(question);
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question,answer);
        return add(q);
    }

    @Override
    public Question add(Question question) {
        return mathQuestions.add(question)?question:null;
    }

    @Override
    public Question remove(Question question) {
        return mathQuestions.remove(question)?question:null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(mathQuestions);
    }
}
