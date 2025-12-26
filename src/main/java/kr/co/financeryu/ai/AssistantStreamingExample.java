package kr.co.financeryu.ai;

import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.TokenStream;
import io.github.cdimascio.dotenv.Dotenv;

public class AssistantStreamingExample {

    private final Assistant assistant;

    public AssistantStreamingExample() {
        Dotenv dotenv = Dotenv.load();
        String OPENAI_API_KEY = dotenv.get("OPENAI_API_KEY");
        String OPENAI_MODEL_NM = dotenv.get("OPENAI_MODEL_NM");
        OpenAiStreamingChatModel streamingChatModel = OpenAiStreamingChatModel.builder()
                .apiKey(OPENAI_API_KEY)
                .modelName(OPENAI_MODEL_NM)
                .build();
        this.assistant = AiServices.builder(Assistant.class)
                .streamingChatModel(streamingChatModel)
                .build();
    }

    public TokenStream chat(String query) {
        return assistant.stream(query);
    }
}
