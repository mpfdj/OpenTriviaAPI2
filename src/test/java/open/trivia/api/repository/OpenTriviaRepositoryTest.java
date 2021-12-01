package open.trivia.api.repository;

import open.trivia.api.configuration.SpringConfig;
import open.trivia.api.model.OpenTriviaItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class OpenTriviaRepositoryTest {

    @Autowired
    private OpenTriviaRepository openTriviaRepository;

    @Test
    public void test1() {
        System.out.println("The open trivia-api has " + openTriviaRepository.getData().size() + " questions...");
    }

    @Test
    public void test2() {
        List<OpenTriviaItem> list = openTriviaRepository.getData();

        final List<String> categoriesTemp = new ArrayList<>();
        list.forEach(openTriviaItem -> categoriesTemp.add(openTriviaItem.getCategory()));

        List<String> categories = categoriesTemp
                .stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(categories);
    }

    @Test
    public void test3() {
        List<OpenTriviaItem> list = openTriviaRepository.getData();

        List<OpenTriviaItem> category = list.stream().filter(item -> item.getCategory().equals("animals")).collect(Collectors.toList());

        Collections.shuffle(category);

        List<OpenTriviaItem> quiz = category.stream().limit(10).collect(Collectors.toList());

        quiz.forEach(q -> System.out.println(q.getId()));

//        1322
//        1198
//        553
//        754
//        1317
//        652
//        1050
//        1321
//        120
//        1018

    }

}
