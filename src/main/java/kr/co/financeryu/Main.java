package kr.co.financeryu;

import dev.langchain4j.model.openai.OpenAiChatModel;

public class Main {
    public static void main(String[] args) {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .modelName("gpt-5-mini")
                .build();
        String answer = model.chat("안녕 chat gpt?");
        System.out.println(answer);
    }
}