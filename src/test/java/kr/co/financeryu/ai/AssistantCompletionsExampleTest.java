package kr.co.financeryu.ai;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssistantCompletionsExampleTest {

    @Test
    void chat() {
        String query = "내 이름은 류재정 이야";
        AssistantCompletionsExample example = new AssistantCompletionsExample();
        String answer = example.chat(query);
        assertNotNull(answer);
    }
}