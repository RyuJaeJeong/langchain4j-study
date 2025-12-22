package kr.co.financeryu.chat;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChatCompletionsExampleTest {

    @Test
    void chat() {
        ChatModel fake = new ChatModel() {
            @Override
            public String chat(String userMessage) {
                return "Answer about " + userMessage;
            }

            @Override
            public ChatResponse chat(List<ChatMessage> messages) {
                return ChatResponse.builder()
                        .aiMessage(new AiMessage("Answer"))
                        .build();
            }
        };

        // given
        String query = "안녕?";

        ChatCompletionsExample model = new ChatCompletionsExample(fake);
        // when
        String answer = model.chat(query);

        // then
        System.out.println("answer1: " + answer);
        assertEquals(answer, "Answer about " + query);

        // given
        List<ChatMessage> list = new ArrayList<>();
        list.add(new UserMessage("hello"));

        //when
        answer = model.chat(list);

        // then
        System.out.println("answer2: " + answer);
        assertEquals(answer, "Answer");
    }
}