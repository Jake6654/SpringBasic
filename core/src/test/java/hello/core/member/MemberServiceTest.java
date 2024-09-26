package hello.core.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();



    @Test
    void join(){
        // given
        Member member = new Member(1L,"memberA",Grade.VIP);

        // when(언제 테스트 하고 싶은가?)
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then (member 와 findMember 가 같다면 통과)
        Assertions.assertEquals(member,findMember);
    }
}
