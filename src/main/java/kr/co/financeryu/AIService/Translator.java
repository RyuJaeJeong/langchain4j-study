package kr.co.financeryu.AIService;

import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;

public interface Translator {

//    @SystemMessage("당신은 한국어 번역기입니다, 사용자의 입력을 한국어로 번역하세요")
    Result<String> chat(String userMessage);

}
