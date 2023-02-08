package hello.advance.app.v4;

import hello.advance.trace.TraceStatus;
import hello.advance.trace.logtrace.LogTrace;
import hello.advance.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderService;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemId) {

        AbstractTemplate<String> template = new AbstractTemplate<String>(trace) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        };

        return template.execute("OrderController.request()");
    }
}

// template 을 활용하여 기존 v3 까지의 코드보다 깔끔해졌다.
// 추상클래스인 AbstractTemplate 의 call 메서드를 구현하여 template 클래스를 생성하고 execute
// 변경이 일어날때 AbstractTemplate 만 수정하면 된다.
// 하지만 템플릿 메서드 패턴은 추상클래스를 이용한 상속을 사용하기에 상속에서 오는 문제점이 발생한다.