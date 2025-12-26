package kr.co.financeryu.workflow;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface StyleEditor {
    @UserMessage("""
        당신은 전문 편집자입니다.
        다음 이야기를 {{style}} 스타일에 더 잘 어울리고 일관성 있게 분석하여 다시 작성해 주세요.
        다른 설명은 생략하고 오직 이야기 본문만 출력하세요.
        이야기 내용은 다음과 같습니다: "{{story}}"
        """)
    @Agent("주어진 stryle에 맞게 story를 편집합니다.")
    String editStory(@V("story") String story, @V("style") String style);
}
