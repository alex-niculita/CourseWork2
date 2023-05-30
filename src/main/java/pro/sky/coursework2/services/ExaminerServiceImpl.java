package pro.sky.coursework2.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.exceptions.AmountOutOfSizeException;
import pro.sky.coursework2.repositories.QuestionRepository;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random random = new Random();

    // по заданию нужно удалить поля сервисов, я это сделал
    // но попросы по джава все равно брать откуда то надо, поэтому использую репозиторий
    // а вопросы по математике генерятся на лету

    private final QuestionRepository javaQuestionRepository;

    public ExaminerServiceImpl(QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> randomQuestions = new HashSet<>();

        // вопросы по джава берутся из репозитория и поэтому их количество ограничено
        // вопросы по математике генерируются поэтому их количество не ограничено
        // если этим методом нужно получить вопросов меньше чем есть в репозитории джава то
        // метод выдаст равное количество по вопросам джава и математике
        // если же этим методом нужно получить вопросов больше чем есть в репозитории джава то
        // метод выдаст все вопросы по джава и остальное количество дополнит вопросами по математике в неограниченном количестве

        int size = javaQuestionRepository.getAll().size();
        if (amount/2 < size) {
            while (randomQuestions.size() < amount/2){
                randomQuestions.add(getJavaRandomQuestion());
            }
        } else {
            randomQuestions.addAll(javaQuestionRepository.getAll());
        }

        int sizeRequired = amount - randomQuestions.size();

        for (int i = 0; i < sizeRequired; i++) {
            randomQuestions.add(getMathRandomQuestion());
        }

        return Collections.unmodifiableSet(randomQuestions);
    }

    //Так как по заданию нужно удалить поля сервисов из ExaminerServiceImpl то мы теряем доступ к генерации случайных вопросов из сервисов
    // поэтому я перенес генерацию вопросов сюда
    private Question getJavaRandomQuestion() {
        Question[] arrTemp = javaQuestionRepository.getAll().toArray(new Question[0]);
        return arrTemp[random.nextInt(arrTemp.length)];
    }

    public Question getMathRandomQuestion() {

        StringBuilder questionStr = new StringBuilder("Сколько будет: ");
        String answerStr = null;

        //рандомные числа, для примера от -100 до 100
        int a = random.nextInt(101) * (random .nextBoolean() ? -1 : 1);
        int b = random.nextInt(101) * (random .nextBoolean() ? -1 : 1);

        questionStr.append(a).append(" ");

        // рандомная математическая операция, 0 плюс, 1 минус, 2 умножение, 3 деление
        int operation = random.nextInt(4);
        //проверяем если операция деление то генерируем второе число отличное от нуля
        if (operation == 3){
            while (b == 0) {
                b = random.nextInt(100) * (random .nextBoolean() ? -1 : 1);
            }
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
