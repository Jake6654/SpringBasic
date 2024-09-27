package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig { // 애플리케이션의 실제 동작에 필요한 구현 객체를 생성
    // 앱의 config(설정, 구성) 을 해주는 class (생성자 주입)


    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository()); // 구체적인 개념을 전달
    }
    // 생성자 주입
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(),new RateDiscountPolicy());
    }


}
