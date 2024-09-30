package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 애플리케이션의 설정 정보를 담는
public class AppConfig { // 애플리케이션의 실제 동작에 필요한 구현 객체를 생성
    // 앱의 config(설정, 구성) 을 해주는 class (생성자 주입)

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
        //return new FixDiscountPolicy();
    }

    @Bean
    public MemberRepository memberRepository(){ // 역할을 더욱 명확하게 구분하여 코드의 가독성을 높임
        return new MemoryMemberRepository();
    }



}
