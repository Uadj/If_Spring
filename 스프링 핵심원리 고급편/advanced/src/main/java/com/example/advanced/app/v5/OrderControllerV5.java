package com.example.advanced.app.v5;

import com.example.advanced.trace.callback.TraceCallback;
import com.example.advanced.trace.callback.TraceTemplate;
import com.example.advanced.trace.logtrace.LogTrace;
import com.example.advanced.trace.template.AbstractTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {
    private final OrderServiceV5 orderServiceV5;
    private final TraceTemplate template;
    public OrderControllerV5(OrderServiceV5 orderServiceV5, LogTrace trace) {
        this.orderServiceV5 = orderServiceV5;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId){
        return template.execute("OrderController.request()", new TraceCallback<>() {
            @Override
            public String call() {
                orderServiceV5.orderItem(itemId);
                return "ok";
            }
        });
    }
}
