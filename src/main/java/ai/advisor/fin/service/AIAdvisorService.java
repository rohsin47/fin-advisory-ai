package ai.advisor.fin.service;

import ai.advisor.fin.model.AIAdvisorModel;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class AIAdvisorService {

    private final ChatModel chatModel;

    public AIAdvisorService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public AIAdvisorModel.Answer generate(AIAdvisorModel.Question question) {
        PromptTemplate promptTemplate = new PromptTemplate(question.question());
        Prompt prompt = promptTemplate.create();
        ChatResponse chatResponse = chatModel.call(prompt);
        return new AIAdvisorModel.Answer(chatResponse.getResult().getOutput().getContent());
    }
}
