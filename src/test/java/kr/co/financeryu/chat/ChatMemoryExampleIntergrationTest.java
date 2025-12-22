package kr.co.financeryu.chat;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ChatMemoryExampleIntergrationTest {

    @Test
    void chat() {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ChatMemoryExample chatMemoryExample = new ChatMemoryExample();

        // given
        String threadId = "test1";
        String[] arr = {"내 이름은 류재정이야", "내 이름이 뭐라고?"};
        for (String query: arr){
            // when
            if(query.equals("END")) break;
            String answer = chatMemoryExample.chat(threadId, query);
            System.out.println("answer: " + answer);
            sb.append(answer);
        }

        // then
        assertNotNull(sb.toString());
    }
}