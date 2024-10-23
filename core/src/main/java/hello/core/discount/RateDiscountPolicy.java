package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy // Qualifier 을 재정의 하여 사용
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override // 할인 정책에 대한 테스트 하기
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        } else{
         return 0;
        }
    }
}
