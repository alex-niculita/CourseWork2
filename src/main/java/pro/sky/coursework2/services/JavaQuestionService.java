package pro.sky.coursework2.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.repositories.QuestionRepository;

import java.util.*;

@Service
@Primary
public class JavaQuestionService implements QuestionService {

    private Random random = new Random();

    private final QuestionRepository javaQuestionRepository;

    public JavaQuestionService(QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question,answer);
        return add(q);
    }

    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Question[] arrTemp = javaQuestionRepository.getAll().toArray(new Question[0]);
        return arrTemp[random.nextInt(arrTemp.length)];
    }
}
