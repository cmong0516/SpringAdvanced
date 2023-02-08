package hello.advance;

import hello.advance.trace.logtrace.FiledLogTrace;
import hello.advance.trace.logtrace.LogTrace;
import hello.advance.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
//        return new FiledLogTrace();

        // 두번 따닥 호출하면 동시성 문제로 인해 로그 출력이 이상해짐
        return new ThreadLocalLogTrace();
        // 동시성 문제 해결을 위해 ThreadLocalLogTrace 를 사용.
    }
}
