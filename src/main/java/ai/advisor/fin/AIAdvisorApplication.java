package ai.advisor.fin;

import ai.advisor.fin.service.AIAdvisorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AIAdvisorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AIAdvisorApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider weatherTools(AIAdvisorService aiAdvisorService) {
        return MethodToolCallbackProvider.builder().toolObjects(aiAdvisorService).build();
    }
}
