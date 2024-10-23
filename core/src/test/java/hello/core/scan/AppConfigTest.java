package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class AppConfigTest {


    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        // AppConfig에서 수동으로 만든 빈과 AutoAppConfig에서 자동으로 생성된 빈이 충돌하여 오류 발생
        MemberService memberService = ac.getBean(MemberService.class);
        assertInstanceOf(MemberService.class,memberService);


        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        assertInstanceOf(OrderService.class, orderService);

    }



}
