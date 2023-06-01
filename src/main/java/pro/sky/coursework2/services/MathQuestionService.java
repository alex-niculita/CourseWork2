package pro.sky.coursework2.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.exceptions.MethodNotAllowedException;
import pro.sky.coursework2.repositories.QuestionRepository;

import java.util.*;

@Component("mathQuestionService")
public class MathQuestionService implements QuestionService {
    private Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException();
    }

    //For Mastermind difficulty
    @Override
    public Question getRandomQuestion() {
        Random random = new Random();

        StringBuilder questionStr = new StringBuilder("Сколько будет: ");
        String answerStr = null;

        //рандомные числа, для примера от -100 до 100
        int a = random.nextInt(201) - 100;
        int b = random.nextInt(201) - 100;

        questionStr.append(a).append(" ");

        // рандомная математическая операция, 0 плюс, 1 минус, 2 умножение, 3 деление
        int operation = random.nextInt(4);
        //проверяем если операция деление то генерируем второе число отличное от нуля
        if (operation == 3 && b == 0){
            b++;
        }
        switch (operation){
            case 0 -> {
                questionStr.append("+ ").append(b);
                answerStr = "Ответ: " + (a + b);
            }
            case 1 -> {
                questionStr.append("- ").append(b);
                answerStr = "Ответ: " + (a - b);
            }
            case 2 -> {
                questionStr.append("* ").append(b);
                answerStr = "Ответ: " + (a * b);
            }
            case 3 -> {
                questionStr.append("/ ").append(b);
                answerStr = "Ответ: " + String.format("%.2f", ((double)a / b));
            }
        }

        questionStr.append(" ?");

        return new Question(questionStr.toString(),answerStr);
    }
}
