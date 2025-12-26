package kr.co.financeryu.AIService.AdvancedTranslation;

import dev.langchain4j.service.Result;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface SeniorTranslator {
    @UserMessage("당신은 다국어 번역가 입니다. 사용자의 한국어 입력을 다국어로 번역하여 결과를 반환 합니다. {{userInput}}")
    Result<SeniorTranslatorDTO> translate(@V("userInput") String userMessage);
}
