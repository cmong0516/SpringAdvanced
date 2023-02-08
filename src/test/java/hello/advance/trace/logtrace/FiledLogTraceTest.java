package hello.advance.trace.logtrace;

import static org.junit.jupiter.api.Assertions.*;

import hello.advance.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class FiledLogTraceTest {

    FiledLogTrace trace = new FiledLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus status1 = trace.begin("hello1");
        System.out.println(status1.getTraceId().getLevel());
        TraceStatus status2 = trace.begin("hello2");
        System.out.println(status2.getTraceId().getLevel());
        trace.end(status2);
        trace.end(status1);

        // 다른 status 인데 동기화 문제 발생.
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2,new IllegalStateException());
        trace.exception(status1,new IllegalStateException());
    }

}