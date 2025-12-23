package kr.co.financeryu.chat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChatMemoryExampleTest {

    @Test
    void chat() {
        StringBuilder sb = new StringBuilder();
        ChatMemoryExample chatMemoryExample = new ChatMemoryExample();

        // given
        String threadId = "test1";
        String[] arr = {"내 이름은 류재정이야, ai 서비스 개발하고있어", "내가 뭐하는 사람이라고?", "오 대단한걸?"};
        for (String query: arr){
            // when
            String answer = chatMemoryExample.chat(threadId, query);
            System.out.println("query: " + query);
            System.out.println("answer: " + answer);
            sb.append(answer);
        }

        // then
        assertNotNull(sb.toString());
    }
}