package hello.advance.trace.strategy;

import hello.advance.trace.strategy.code.ContextV1;
import hello.advance.trace.strategy.code.Strategy;
import hello.advance.trace.strategy.code.StrategyLogic1;
import hello.advance.trace.strategy.code.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        log.info("비니지스 로직1 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        log.info("비니지스 로직2 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);

        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);

        contextV2.execute();

        // ContextV1 은 생성자로 Strategy 를 주입받아 실행
    }

    @Test
    void strategyV2() {
        Strategy strategyLogic1 = new Strategy() {

            @Override
            public void call() {
                log.info("비지니스 로직 1 실행");
            }
        };

        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();


        Strategy strategyLogic2 = new Strategy() {

            @Override
            public void call() {
                log.info("비지니스 로직 2 실행");
            }
        };

        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();

        // 익명 내부 클래스로 Strategy 를 생성할수도 있다.
    }

    @Test
    void strategyV3() {
        ContextV1 contextV1 = new ContextV1(new Strategy() {

            @Override
            public void call() {
                log.info("비지니스 로직 1 실행");
            }
        });

        contextV1.execute();;

        ContextV1 contextV2 = new ContextV1(new Strategy() {

            @Override
            public void call() {
                log.info("비지니스 로직 2 실행");
            }
        });
        contextV2.execute();

        // 익명 내부 클래스를 활용하여 ContextV1 인자에서 바로 생성
    }

    @Test
    void strategyV4() {

        ContextV1 contextV1 = new ContextV1(() -> log.info("비지니스 로직 1 실행"));
        contextV1.execute();;

        ContextV1 contextV2 = new ContextV1(() -> log.info("비지니스 로직 2 실행"));
        contextV2.execute();

        // 람다식을 활용하여 ContextV1 인자에서 바로 생성.
        // 람다식을 활용할 때는 Strategy 인터페이스에 메서드가 1개 여야만 한다.
    }
}
