package kr.co.financeryu.ai;

import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.TokenStream;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AssistantStreamingExampleTest {

    @Test
    void chat() {
        String query = "안녕? 내 이름은 류재정이야";
        AssistantStreamingExample streamingExample = new AssistantStreamingExample();
        StringBuilder sb = new StringBuilder();
        TokenStream tokenStream = streamingExample.chat(query);
        CompletableFuture<ChatResponse> futureResponse = new CompletableFuture<>();
        tokenStream
                .onPartialResponse((String partialResponse) -> {
                    sb.append(partialResponse);
                    System.out.println("[partialResponse]: " + partialResponse);
                })
                .onCompleteResponse(futureResponse::complete)
                .onError(futureResponse::completeExceptionally)
                .start();
        futureResponse.join();
        assertNotNull(sb.toString());
    }
}