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

//        public void end(TraceStatus status) {
//            complete(status, null);
//        }

        // hello 를 받은 TraceStatus 는 traceId, startTimeMs ,hello

//
//        private void complete(TraceStatus status, Exception e) {
//            Long stopTimeMs = System.currentTimeMillis();
//            long resultTimeMs = stopTimeMs - status.getStartTimeMs();
//            TraceId traceId = status.getTraceId();
//            if (e == null) {
//                log.info("[{}] {}{} time={}ms", traceId.getId(),
//                        addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(),
//                        resultTimeMs);
//            } else {
//                log.info("[{}] {}{} time={}ms ex={}", traceId.getId(),
//                        addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs,
//                        e.toString());
//            }
//        }

        // complete 메서드로 종료시간과 소요시간을 계산
        // exception 이 발생하지 않았다면 traceId 와 message , resultTime 로그
        // exception 이 발생했다면 exception 까지 출력.

        trace.end(status);
    }

    @Test
    void begin_exception() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException());
        // exception 까지 출력한것이 begin_exception
    }
}
