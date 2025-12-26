package kr.co.financeryu.AIService.AdvancedTranslation;

import dev.langchain4j.service.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeniorTranslatorExampleTest {

    @Test
    void translate() {
        String query = "안녕? 반가워";
        SeniorTranslatorExample example = new SeniorTranslatorExample();
        Result<SeniorTranslatorDTO> result = example.translate(query);
        System.out.println(result.content().toString());
        assertEquals(result.finishReason().toString(), "STOP");
    }
}