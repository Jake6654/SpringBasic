package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB: B사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA: A 사용자 주문 금액 조회
        // int price = statefulService1.getPrice();
        System.out.println("userA price = " + userAPrice);
        System.out.println("userB price = " + userBPrice);// 20000 원이 나와버린다
        // statefulService2 에서 가격을 20000으로 바꿔버리기 때문에

        assertEquals(10000,userAPrice);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}