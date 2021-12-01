package open.trivia.api.service;

import open.trivia.api.model.OpenTriviaItem;
import open.trivia.api.repository.OpenTriviaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpenTriviaService {

    @Autowired
    private OpenTriviaRepository openTriviaRepository;


//    private final OpenTriviaRepository openTriviaRepository;
//
//    @Autowired
//    public OpenTriviaService(OpenTriviaRepository openTriviaRepository) {
//        this.openTriviaRepository = openTriviaRepository;
//
//    }


    public List<String> getCategories() {
        List<OpenTriviaItem> list = openTriviaRepository.getData();

        final List<String> categoriesTemp = new ArrayList<>();
        list.forEach(openTriviaItem -> categoriesTemp.add(openTriviaItem.getCategory()));

        List<String> categories = categoriesTemp
                .stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        return categories;
    }

    public List<OpenTriviaItem> getQuiz(String category) {
        List<OpenTriviaItem> list = openTriviaRepository.getData();

        List<OpenTriviaItem> categoryList = list
                .stream()
                .filter(item -> item.getCategory().equals(category))
                .collect(Collectors.toList());

        Collections.shuffle(categoryList);

        List<OpenTriviaItem> quiz = categoryList
                .stream()
                .limit(10)
                .collect(Collectors.toList());

        return quiz;
    }


}
