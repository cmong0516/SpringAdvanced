package hello.advance.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();

        strategy.call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }
}

// ContextV1 은 생성자로 주입 받았다면 V2 는 메서드에 파라미터로 Strategy 를 받아 실행한다,