package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService; // BeforeEach 에서 할당된 memberService 가 들어옴

    @BeforeEach
    public void beforeEach(){ // 모든 테스트전에 돌아가는 코드
        // AppConfig 객체를 만들고 멤버 서비스 할당 후 테스트 메서드가 실행
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    AppConfig appConfig = new AppConfig();

    @Test
    void join(){
        // given
        Member member = new Member(1L,"memberA",Grade.VIP);
        memberService.join(member);

        // when(언제 테스트 하고 싶은가?)
        Member findMember = memberService.findMember(1L);

        // then (member 와 findMember 가 같다면 통과)
        Assertions.assertEquals(member,findMember);
    }
}
