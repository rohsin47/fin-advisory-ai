package ai.advisor.fin.resource;

import ai.advisor.fin.model.AIAdvisorResponse;
import ai.advisor.fin.model.AIAdvisorQuery;
import ai.advisor.fin.service.AIAdvisorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AIAdvisorResource {

    private final AIAdvisorService aiAdvisorService;

    public AIAdvisorResource(AIAdvisorService aiAdvisorService) {
        this.aiAdvisorService = aiAdvisorService;
    }

    @PostMapping("/advise")
    public AIAdvisorResponse advise(@RequestBody AIAdvisorQuery question) {
        return aiAdvisorService.generate(question);
    }
}
