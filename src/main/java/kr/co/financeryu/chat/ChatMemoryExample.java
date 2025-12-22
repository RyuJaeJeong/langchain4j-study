package kr.co.financeryu.chat;

import dev.langchain4j.chain.ConversationalChain;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import io.github.cdimascio.dotenv.Dotenv;

public class ChatMemoryExample {

    // Fields
    private final ChatModel model;
    private final InMemoryChatMemoryStore memoryStore;

    // Cons
    public ChatMemoryExample() {
        this.memoryStore = new InMemoryChatMemoryStore();
        Dotenv dotenv = Dotenv.load();
        String OPENAI_MODEL_NM = dotenv.get("OPENAI_MODEL_NM");
        String OPENAI_API_KEY = dotenv.get("OPENAI_API_KEY");
        this.model = OpenAiChatModel.builder()
                .modelName(OPENAI_MODEL_NM)
                .apiKey(OPENAI_API_KEY)
                .build();
    }

    // Method
    public String chat(String threadId, String query){
        ChatMemory memory = MessageWindowChatMemory.builder()
                .id(threadId)
                .maxMessages(10)
                .chatMemoryStore(this.memoryStore)
                .build();
        ConversationalChain chain = ConversationalChain.builder()
                .chatModel(this.model)
                .chatMemory(memory)
                .build();
        return chain.execute(query);
    }



}
