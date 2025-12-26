package kr.co.financeryu.AIService;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Scanner;

public class AssistantCompletionsExample {

    private final Assistant assistant;

    public AssistantCompletionsExample() {
        Dotenv env = Dotenv.load();
        String OPENAI_API_KEY = env.get("OPENAI_API_KEY");
        String OPENAI_MODEL_NM = env.get("OPENAI_MODEL_NM");
        OpenAiChatModel chatModel = OpenAiChatModel.builder()
                .apiKey(OPENAI_API_KEY)
                .modelName(OPENAI_MODEL_NM)
                .build();
        this.assistant = AiServices.create(Assistant.class, chatModel);
    }

    /**
     * 사용자 질의에 대한 답변을 반환 합니다.
     * @param query 사용자 질의
     * @return 답변
     */
    public String chat(String query){
        return assistant.chat(query);
    }
}
