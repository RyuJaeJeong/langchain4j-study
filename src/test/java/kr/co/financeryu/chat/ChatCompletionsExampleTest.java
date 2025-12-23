package kr.co.financeryu.chat;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChatCompletionsExampleTest {

    @Test
    void chat() {
        //given
        String query = "안녕?";

        ChatCompletionsExample model = new ChatCompletionsExample();
        //when
        String answer = model.chat(query);

        //then
        System.out.println("answer: " + answer);
        assertNotNull(answer);

        //given
        List<ChatMessage> list = new ArrayList<>();
        list.add(new UserMessage("내 이름은 류재정이야"));
        list.add(new AiMessage("안녕하세요 재정님, 무엇이 궁금하신가요?"));
        list.add(new UserMessage("내 이름이 뭐라고?"));

        //when
        answer = model.chat(list);

        //then
        System.out.println("answer: " + answer);
        assertNotNull(answer);
    }
}
