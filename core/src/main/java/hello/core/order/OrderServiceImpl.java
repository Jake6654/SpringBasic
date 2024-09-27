package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // DIP 를 철저하게 지킴(추상화에 의존)
    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    // MemberRepository 와 DiscountPolicy 둘다 필요
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // 단일 체계 원칙이 잘 지켜진 코드이다. discount 에 무슨제가 발생하면 discount 에서만 코드를 고치면 된다
        // if not, discount 에서 에러가 발생했을대 order 에서 코드를 변경해야하는 잘못 설계된 코드가 될 수 있다

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
