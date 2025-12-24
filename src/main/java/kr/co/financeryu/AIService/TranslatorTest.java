package kr.co.financeryu.AIService;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.Result;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Scanner;

public class TranslatorTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String query = sc.nextLine();
        Dotenv dotenv = Dotenv.load();
        final String OPENAI_API_KEY = dotenv.get("OPENAI_API_KEY");
        final String OPENAI_MODEL_NM = dotenv.get("OPENAI_MODEL_NM");
        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey(OPENAI_API_KEY)
                .modelName(OPENAI_MODEL_NM)
                .build();
        Translator translator = AiServices.builder(Translator.class)
                .chatModel(model)
                .systemMessageProvider(chatMemoryId -> "당신은 번역 agent입니다. 다국어 입력을 일본어로 번역하세요")   // 시스템 프롬프트 동적으로 추가 가능
                .build();
        Result<String> result = translator.chat(query);
        System.out.println("content: " + result.content());
        System.out.println("token usage: " + result.tokenUsage());
        System.out.println("finish reason: " + result.finishReason());
    }
}
