package kr.co.financeryu.AIService.AdvancedTranslation;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.Result;
import io.github.cdimascio.dotenv.Dotenv;

public class SeniorTranslatorExample {

    private final SeniorTranslator translator;

    public SeniorTranslatorExample() {
        Dotenv dotenv = Dotenv.load();
        final String OPENAI_API_KEY = dotenv.get("OPENAI_API_KEY");
        final String OPENAI_MODEL_NM = dotenv.get("OPENAI_MODEL_NM");
        OpenAiChatModel chatModel = OpenAiChatModel.builder()
                .apiKey(OPENAI_API_KEY)
                .modelName(OPENAI_MODEL_NM)
                .build();
        translator = AiServices.builder(SeniorTranslator.class)
                .chatModel(chatModel)
                .build();
    }

    public Result<SeniorTranslatorDTO> translate(String query) {
        return translator.translate(query);
    }
}
