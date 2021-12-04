package open.trivia.api.controller;

import open.trivia.api.model.OpenTriviaItem;
import open.trivia.api.service.OpenTriviaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OpenTriviaController {

    @Autowired
    private OpenTriviaService openTriviaService;

    @GetMapping("/categories")
    public List<String> getCategories() {
        return openTriviaService.getCategories();
    }

    @GetMapping("/quiz")
    public List<OpenTriviaItem> getQuiz(@RequestParam String category) {
        return openTriviaService.getQuiz(category);
    }

}
