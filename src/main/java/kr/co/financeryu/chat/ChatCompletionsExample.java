package kr.co.financeryu.chat;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.List;

public class ChatCompletionsExample {

    //fields
    private final ChatModel model;

    //cons
    public ChatCompletionsExample() {
        Dotenv dotenv = Dotenv.load();
        String OPENAI_MODEL_NM = dotenv.get("OPENAI_MODEL_NM");
        String OPENAI_API_KEY = dotenv.get("OPENAI_API_KEY");
        model = OpenAiChatModel.builder()
                .modelName(OPENAI_MODEL_NM)
                .apiKey(OPENAI_API_KEY)
                .build();
    }

    ChatCompletionsExample(ChatModel model) {
        this.model = model;
    }

    // method
    /**
     * LLM에서 답변을 반환 합니다.
     * @param query 사용자 질의
     * @return 답변
     */
    public String chat(String query){
        return model.chat(query);
    }

    public String chat(List<ChatMessage> messages){
        return model.chat(messages).aiMessage().text();
    }

}