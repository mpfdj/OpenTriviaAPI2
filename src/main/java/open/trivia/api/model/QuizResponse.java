package open.trivia.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuizResponse {
    private String id;
    private String category;
    private String question;
    private String type;
    private List<String> choices;
    private String answer;
}
