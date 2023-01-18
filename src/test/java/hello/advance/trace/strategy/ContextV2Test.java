package hello.advance.trace.strategy;

import hello.advance.trace.strategy.code.ContextV1;
import hello.advance.trace.strategy.code.ContextV2;
import hello.advance.trace.strategy.code.Strategy;
import hello.advance.trace.strategy.code.StrategyLogic1;
import hello.advance.trace.strategy.code.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {
    @Test
    void strategyV1() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }

    @Test
    void strategyV2() {
        ContextV2 contextV2 = new ContextV2();
//        contextV2.execute(new Strategy() {
//            @Override
//            public void call() {
//                log.info("비지니스 로직 1 실행");
//            }
//        });

        contextV2.execute(() -> log.info("비지니스 로직 1 실행"));

//        contextV2.execute(new Strategy() {
//            @Override
//            public void call() {
//                log.info("비지니스 로직 2 실행");
//            }
//        });
        contextV2.execute(() -> log.info("비지니스 로직 2 실행"));
    }
}
