package pro.sky.coursework2.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.exceptions.AmountOutOfSizeException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final Set<Question> randomQuestions = new HashSet<>();

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(QuestionService javaQuestionService, @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = javaQuestionService.getAll().size() + mathQuestionService.getAll().size();
        if (amount > size || amount < 1) throw new AmountOutOfSizeException();
        Collection<Question> allQuestions = new HashSet<>();
        allQuestions.addAll(javaQuestionService.getAll());
        allQuestions.addAll(mathQuestionService.getAll());
        if (amount == size) return allQuestions;

        Random random = new Random();
        while (randomQuestions.size() < amount){
            if (random.nextBoolean()) {
                randomQuestions.add(javaQuestionService.getRandomQuestion());
            } else {
                randomQuestions.add(mathQuestionService.getRandomQuestion());
            }
        }
        return Collections.unmodifiableSet(randomQuestions);
    }
}
