package kr.co.financeryu.ai;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.Result;
import io.github.cdimascio.dotenv.Dotenv;

public class TranslatorExample {

    // Fields
    private final Translator translator;

    // Cons
    public TranslatorExample() {
        Dotenv dotenv = Dotenv.load();
        final String OPENAI_API_KEY = dotenv.get("OPENAI_API_KEY");
        final String OPENAI_MODEL_NM = dotenv.get("OPENAI_MODEL_NM");
        OpenAiChatModel chatModel = OpenAiChatModel.builder()
                .apiKey(OPENAI_API_KEY)
                .modelName(OPENAI_MODEL_NM)
                .build();
        this.translator = AiServices.builder(Translator.class)
                .chatModel(chatModel)
                .build();

    }


    // Method
    public Result<String> translate(String query) {
        return translator.chat(query);
    }
}
