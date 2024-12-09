package ai.advisor.fin.model;

import lombok.Data;

@Data
public class AIAdvisorModel {

    public record Question(String question){}

    public record Answer(String answer){}
}
