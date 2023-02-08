package hello.advance.app.v5;

import hello.advance.trace.callback.TraceCallback;
import hello.advance.trace.callback.TraceTemplate;
import hello.advance.trace.logtrace.LogTrace;
import hello.advance.trace.template.AbstractTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {

        return template.execute("OrderController.request()", new TraceCallback<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });

    }
}

// template 는 execute() 를 실행할때 TraceCallback 타입을 인자로 받기 때문에
// call 메서드를 재정의 해주어야한다.