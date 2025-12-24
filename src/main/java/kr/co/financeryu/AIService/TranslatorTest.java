package kr.co.financeryu.AIService;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Scanner;

public class TranslatorTest {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String query = sc.nextLine();
        Dotenv dotenv = Dotenv.load();
        final String OPENAI_API_KEY = dotenv.get("OPENAI_API_KEY");
        final String OPENAI_MODEL_NM = dotenv.get("OPENAI_MODEL_NM");
        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey(OPENAI_API_KEY)
                .modelName(OPENAI_MODEL_NM)
                .build();
        Translator translator = AiServices.create(Translator.class, model);
        String result = translator.chat("Translation Specialist");
        System.out.println(result);
    }
}
