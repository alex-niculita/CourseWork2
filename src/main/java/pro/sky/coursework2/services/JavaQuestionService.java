package pro.sky.coursework2.services;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

//    {
//        Question question = new Question("Question 1?", "Answer 1");
//        questions.add(question);
//        question = new Question("Question 2?", "Answer 2");
//        questions.add(question);
//        question = new Question("Question 3?", "Answer 3");
//        questions.add(question);
//        question = new Question("Question 4?", "Answer 3");
//        questions.add(question);
//        question = new Question("Question 5?", "Answer 5");
//        questions.add(question);
//        question = new Question("Question 6?", "Answer 6");
//        questions.add(question);
//        question = new Question("Question 7?", "Answer 7");
//        questions.add(question);
//        question = new Question("Question 8?", "Answer 8");
//        questions.add(question);
//        question = new Question("Question 9?", "Answer 9");
//        questions.add(question);
//        question = new Question("Question 10?", "Answer 10");
//        questions.add(question);
//        question = new Question("Question 11?", "Answer 11");
//        questions.add(question);
//        question = new Question("Question 12?", "Answer 12");
//        questions.add(question);
//    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question,answer);
        return add(q);
    }

    @Override
    public Question add(Question question) {
        return questions.add(question)?question:null;
    }

    @Override
    public Question remove(Question question) {
        return questions.remove(question)?question:null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Question[] arrTemp = questions.toArray(new Question[0]);
        Random random = new Random();
        return arrTemp[random.nextInt(arrTemp.length)];
    }
}
