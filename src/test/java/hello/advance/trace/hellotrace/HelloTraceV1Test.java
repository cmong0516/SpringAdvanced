package hello.advance.trace.hellotrace;

import hello.advance.trace.TraceId;
import hello.advance.trace.TraceStatus;
import org.junit.jupiter.api.Test;

public class HelloTraceV1Test {
    @Test
    void begin_end() {
        HelloTraceV1 trace = new HelloTraceV1();

//        public TraceStatus begin(String message) {
//            TraceId traceId = new TraceId();
//            long startTimeMs = System.currentTimeMillis();
//
//            log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
//
//            return new TraceStatus(traceId, startTimeMs, message);
//        }

//        private static String addSpace(String prefix, int level) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < level; i++) {
//                sb.append((i == level - 1) ? "|" + prefix : "|   ");
//            }
//            return sb.toString();
//        }

        // begin 에 String hello 를 입력하면 TraceId 생성하고 level 수만큼 StringBuilder 에 prefix 를 추가한다.

        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    void begin_exception() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException());
    }
}
