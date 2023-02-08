package hello.advance.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1 {

    private Strategy strategy;

    // call() 를 가지고 있는 Strategy 를 생성자로 주입받는다.

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();

    // 주입받은 call() 실행
        strategy.call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }
}

