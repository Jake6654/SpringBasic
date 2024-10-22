package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import hello.core.order.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class AppConfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean("memberServiceImpl", MemberService.class);
        assertInstanceOf(MemberService.class,memberService);
        System.out.println("memberService = " + memberService);

        OrderService orderService = ac.getBean("orderServiceImpl", OrderService.class);
        assertInstanceOf(OrderService.class, orderService);

    }



}
