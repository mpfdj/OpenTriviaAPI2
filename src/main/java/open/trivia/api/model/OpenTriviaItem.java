package open.trivia.api.model;

import lombok.Data;

import java.util.List;

@Data
public class OpenTriviaItem {
    private int id;
    private String category;
    private String question;
    private String type;
    private List<String> choices;
    private String answer;
}
