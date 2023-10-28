package com.example.advanced.trace.hellotrace;

import com.example.advanced.trace.TraceId;
import com.example.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV2Test {
    @Test
    void begin_end(){
        HelloTraceV2 helloTraceV2 = new HelloTraceV2();
        TraceStatus status1 = helloTraceV2.begin("hello1");
        TraceStatus status2 = helloTraceV2.beginSync(status1.getTraceId(), "hello2");
        helloTraceV2.end(status2);
        helloTraceV2.end(status1);
    }
    @Test
    void begin_exception(){
        HelloTraceV2 helloTraceV2 = new HelloTraceV2();
        TraceStatus status1 = helloTraceV2.begin("hello1");
        TraceStatus status2 = helloTraceV2.beginSync(status1.getTraceId(), "hello2");
        helloTraceV2.exception(status2, new IllegalStateException());
        helloTraceV2.exception(status1, new IllegalStateException());
    }
}