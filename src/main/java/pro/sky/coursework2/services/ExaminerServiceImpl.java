package pro.sky.coursework2.services;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.exceptions.AmountOutOfSizeException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final Set<Question> randomQuestions = new HashSet<>();

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getAll().size();
        if (amount > size || amount < 1) throw new AmountOutOfSizeException();

        if (amount == size) return questionService.getAll();

        while (randomQuestions.size() < amount){
            randomQuestions.add(questionService.getRandomQuestion());
        }

        return Collections.unmodifiableSet(randomQuestions);
    }
}
