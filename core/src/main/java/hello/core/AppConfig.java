package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 // 앱의 config(설정, 구성) 스프링 설정 정보에는 항상 configuration 을 넣자
public class AppConfig { // 애플리케이션의 실제 동작에 필요한 구현 객체를 생성



    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());

    }


    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());

    }


    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
        //return new FixDiscountPolicy();
    }


    public MemberRepository memberRepository(){// 역할을 더욱 명확하게 구분하여 코드의 가독성을 높임
        return new MemoryMemberRepository();
    }



}
