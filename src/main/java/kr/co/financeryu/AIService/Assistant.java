package kr.co.financeryu.AIService;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.TokenStream;
import dev.langchain4j.service.UserMessage;

public interface Assistant {
    String chat(String userMessage);
    TokenStream stream(@UserMessage String message);
}
