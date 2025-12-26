package kr.co.financeryu.workflow;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface AudienceEditor {
    @UserMessage("""
        당신은 전문 편집자입니다.
        다음 이야기를 {{audience}} 대상에 더 적합하도록 분석하고 다시 작성해 주세요. 
        다른 설명 없이 오직 수정된 이야기만 출력하세요. 
        이야기 내용은 다음과 같습니다: {{story}}
        """)
    @Agent("주어진 audience에 맞게 story를 재 작성합니다.")
    String editStory(@V("story") String story, @V("audience") String audience);
}
