package kr.co.financeryu.chat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChatStreamingModelExampleTest {

    @Test
    void chat(){
        ChatStreamingModelExample stream = new ChatStreamingModelExample();
        stream.chat("안녕 내 이름은 류재정이야?");
        assertEquals(true, true);
    }
}