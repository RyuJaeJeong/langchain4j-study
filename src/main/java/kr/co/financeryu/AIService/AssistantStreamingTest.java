package kr.co.financeryu.AIService;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.TokenStream;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class AssistantStreamingTest {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        Scanner sc = new Scanner(System.in);
        final String OPENAI_API_KEY = dotenv.get("OPENAI_API_KEY");
        final String OPENAI_MODEL_NM = dotenv.get("OPENAI_MODEL_NM");
        OpenAiStreamingChatModel model = OpenAiStreamingChatModel.builder()
                .apiKey(OPENAI_API_KEY)
                .modelName(OPENAI_MODEL_NM)
                .build();
        Assistant assistant = AiServices.builder(Assistant.class)
                .streamingChatModel(model)
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.builder().chatMemoryStore(new InMemoryChatMemoryStore()).maxMessages(10).build())
                .build();
        while(true){
            String memoryId = sc.nextLine();
            String query = sc.nextLine();
            if(query.equals("END")) break;
            else{
                TokenStream tokenStream = assistant.stream(memoryId, query);
                CompletableFuture<ChatResponse> futureResponse = new CompletableFuture<>();
                tokenStream
                        .onPartialResponseWithContext(((partialResponse, partialResponseContext) -> {
                            System.out.println(partialResponse.text());
    //                    if(sholdCancel()){
    //                        partialResponseContext.streamingHandle().cancel();
    //                    }
                        }))
                        .onCompleteResponse(futureResponse::complete)
                        .onError(futureResponse::completeExceptionally)
                        .start();
                ChatResponse chatResponse = futureResponse.join();
                System.out.println("\n" + chatResponse.toString());
            }

        }

    }
}
