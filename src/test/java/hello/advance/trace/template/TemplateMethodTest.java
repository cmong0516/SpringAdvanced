package hello.advance.trace.template;

import hello.advance.trace.template.code.AbstractTemplate;
import hello.advance.trace.template.code.SubClassLogic1;
import hello.advance.trace.template.code.SubClassLogic2;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {
    // 현재까지의 코드를 보면 핵심 기능에 부가기능을 추가하고 있다.
    // 그런데 부가기능을 위한 코드가 핵심 기능의 코드보다 더 많은것같다.
    // 또 부가기능 코드에 동일한 패턴이 존재한다.

    @Test
    void templateMethodV0() {
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
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();
        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();

        // SubClassLogic 에서 call 메서드를 재정의 하여 execute 메서드 내에서 실행한다.
    }

    @Test
    void templateMethodV2() {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비지니스 로직 1 실행");
            }
        };

        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비지니스 로직 2 실행");
            }
        };

        template2.execute();
    }
}
