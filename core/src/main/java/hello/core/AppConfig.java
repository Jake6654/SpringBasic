package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 앱의 config(설정, 구성) 스프링 설정 정보에는 항상 configuration 을 넣자
public class AppConfig { // 애플리케이션의 실제 동작에 필요한 구현 객체를 생성

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()

    //"call AppConfig.memberService"
    //"call AppConfig.memberRepository"
    //"call AppConfig.orderService"
    //"call AppConfig.memberRepository"
    //"call AppConfig.memberRepository"

    // 실제 호출된 메서드 멤버 리포지토리가 1번만 호출되었다
//    call AppConfig.memberService
//    call AppConfig.memberRepository
//    call AppConfig.orderService

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
    public MemberRepository memberRepository(){// 역할을 더욱 명확하게 구분하여 코드의 가독성을 높임
        return new MemoryMemberRepository();
    }



}
