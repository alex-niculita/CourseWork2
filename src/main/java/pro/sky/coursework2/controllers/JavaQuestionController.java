package pro.sky.coursework2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.services.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

//    Добавить: “/exam/java/add?question=QuestionText&answer=QuestionAnswer”
    @GetMapping("/add")
    public Question add(@RequestParam("question") String questionText, @RequestParam("answer") String questionAnswer){
        return questionService.add(questionText,questionAnswer);
    }

//    Удалить: “/exam/java/remove?question=QuestionText&answer=QuestionAnswer”
    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String questionText, @RequestParam("answer") String questionAnswer) {
        return questionService.remove(new Question(questionText,questionAnswer));
    }

//    Получить все вопросы: “/exam/java”
    @GetMapping("")
    public Collection<Question> getAll() {
        return questionService.getAll();
    }


}
