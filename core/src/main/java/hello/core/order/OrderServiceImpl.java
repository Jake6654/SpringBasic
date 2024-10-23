package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// @RequiredArgsConstructor // Lombok create constructor automatically for the final variables in the field
// it also injects dependency auto
public class OrderServiceImpl implements OrderService{

    // 생성자 주입을할때 final 을 넣으면 생성자를 통해 의존관계가 들어왔는지 안 들어 왔는지 체크 할 수 있다
    // 누락을 막을 수 있다
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired // 생성자 주입
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
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

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }
}
