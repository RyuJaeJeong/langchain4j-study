package kr.co.financeryu.AIService;

import dev.langchain4j.service.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranslatorExampleTest {
    @Test
    void chat() {
        String query = "Happy New Year!";
        TranslatorExample example = new TranslatorExample();
        Result<String> result = example.translate(query);
        System.out.println(result.content());
        assertEquals(result.finishReason().toString(), "STOP");
    }
}
