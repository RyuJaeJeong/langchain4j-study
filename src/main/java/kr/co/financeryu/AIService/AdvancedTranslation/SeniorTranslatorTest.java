package kr.co.financeryu.AIService.AdvancedTranslation;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.Result;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Scanner;

public class SeniorTranslatorTest {

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
        SeniorTranslator translator = AiServices.builder(SeniorTranslator.class)
                .chatModel(model)
                .build();
        Result<SeniorTranslatorDTO> result = translator.chat(query);
        System.out.println("content: " + result.content().toString());
        System.out.println("token usage: " + result.tokenUsage());
        System.out.println("finish reason: " + result.finishReason());
    }
}
