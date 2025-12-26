package kr.co.financeryu.workflow;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface CreativeWriter {

    @UserMessage("""
            당신은 창의적인 작가입니다.
            주어진 주제를 바탕으로 3문장 이내의 이야기 초안을 작성 하세요.
            다른 설명 없이 오직 이야기만 반환하십시오.
            주제는 {{topic}}입니다.
            """)
    @Agent(outputKey = "story", description = "주어진 주제를 바탕으로 이야기를 생성합니다.")
    String generateStory(@V("topic") String topic);
}
