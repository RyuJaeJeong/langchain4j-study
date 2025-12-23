package kr.co.financeryu.chat;

import dev.langchain4j.chain.ConversationalChain;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiTokenCountEstimator;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import io.github.cdimascio.dotenv.Dotenv;

public class ChatMemoryExample {

    // Fields
    private final ChatModel model;
    private final InMemoryChatMemoryStore memoryStore;

    // Cons
    public ChatMemoryExample() {
        Dotenv dotenv = Dotenv.load();
        String OPENAI_MODEL_NM = dotenv.get("OPENAI_MODEL_NM");
        String OPENAI_API_KEY = dotenv.get("OPENAI_API_KEY");
        this.model = OpenAiChatModel.builder()
                .modelName(OPENAI_MODEL_NM)
                .apiKey(OPENAI_API_KEY)
                .build();
        this.memoryStore = new InMemoryChatMemoryStore();
    }

    public ChatMemoryExample(ChatModel model) {
        this.model = model;
        this.memoryStore = new InMemoryChatMemoryStore();
    }

    // Method
    public String chat(String threadId, String query){
        ChatMemory chatMemory = TokenWindowChatMemory.builder()
                .id(threadId)
                .maxTokens(13107, new OpenAiTokenCountEstimator("gpt-5-mini"))
                .chatMemoryStore(this.memoryStore)
                .build();
        ConversationalChain chain = ConversationalChain.builder()
                .chatModel(this.model)
                .chatMemory(chatMemory)
                .build();
        return chain.execute(query);
    }



}
