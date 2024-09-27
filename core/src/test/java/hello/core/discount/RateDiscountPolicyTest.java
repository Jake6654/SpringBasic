package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다") // 성공 테스트
    void vip_0(){
        // given ( 주어진 것)
        Member member = new Member(1L,"memberA", Grade.VIP);
        // when (테스트 하고 싶은것)
        int discount = discountPolicy.discount(member,10000);
        // then
        Assertions.assertEquals(1000,discount);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다") // 실패 테스트
    void vip_X(){
        // given
        Member member = new Member(1L,"memberA", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member,10000);
        // then
        Assertions.assertEquals(0,0);
    }

}