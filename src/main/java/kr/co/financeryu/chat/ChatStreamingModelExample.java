package kr.co.financeryu.chat;

import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.chat.response.StreamingChatResponseHandler;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.concurrent.CountDownLatch;

public class ChatStreamingModelExample {

    //fields
    private final StreamingChatModel model;

    //Cons
    public ChatStreamingModelExample() {
        Dotenv dotenv = Dotenv.load();
        String OPENAI_MODEL_NM = dotenv.get("OPENAI_MODEL_NM");
        String OPENAI_API_KEY = dotenv.get("OPENAI_API_KEY");
        this.model = OpenAiStreamingChatModel.builder()
                .modelName(OPENAI_MODEL_NM)
                .apiKey(OPENAI_API_KEY)
                .build();
    }


    // method
    public static void main(String[] args) {
        ChatStreamingModelExample stream = new ChatStreamingModelExample();
        stream.chat("구글에 대해 소개해줘?");
    }

    public void chat(String query){
        CountDownLatch latch = new CountDownLatch(1);
        System.out.println(query);
        model.chat(query, new StreamingChatResponseHandler() {
            @Override
            public void onPartialResponse(String partialResponse) {
                System.out.println("onPartialResponse: " + partialResponse);
                StreamingChatResponseHandler.super.onPartialResponse(partialResponse);
            }

            @Override
            public void onCompleteResponse(ChatResponse chatResponse) {
                System.out.println("onCompleteResponse: " + chatResponse);
                latch.countDown();
            }

            @Override
            public void onError(Throwable throwable) {
                latch.countDown();
                throwable.printStackTrace();
            }
        });

        try{
            latch.await();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}
