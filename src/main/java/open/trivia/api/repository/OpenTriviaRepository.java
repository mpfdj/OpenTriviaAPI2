package open.trivia.api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import open.trivia.api.model.OpenTriviaItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Repository
public class OpenTriviaRepository {

    @Value("classpath:/open-trivia.json")
    private Resource resource;

    @Getter
    private List<OpenTriviaItem> data;

    @PostConstruct
    public void postConstruct() {
        try (InputStream inputStream = resource.getInputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            OpenTriviaItem[] items = objectMapper.readValue(inputStream, OpenTriviaItem[].class);
            data = Arrays.asList(items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
