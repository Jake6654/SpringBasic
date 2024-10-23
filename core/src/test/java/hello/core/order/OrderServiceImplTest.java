package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test // 오더 서비스 오더를 잘 만들었는지 확인하는 테스트
    void createOrder(){ // setter 주입으로 했을경우 nullPointException 발생
        // 생성자 주입을 했을때는 컴파일 오류(제일 좋은 오류) 발생하여 개발자에게 알려준다
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L,"itemA", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new FixDiscountPolicy());
        Order orderA = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertEquals(1000, orderA.getDiscountPrice());
    }

}