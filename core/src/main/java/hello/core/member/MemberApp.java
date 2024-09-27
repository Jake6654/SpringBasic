package hello.core.member;

import hello.core.AppConfig;
import hello.core.member.Grade;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberServiceImpl = appConfig.memberService(); // MemoryMemberRepository 를 구현한 MemServiceImpl 이 반환된다
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberServiceImpl.join(memberA);

        Member findMember = memberServiceImpl.findMember(1L);
        System.out.println("new member = " +memberA.getName());
        System.out.println("find member = " +findMember.getName());
}
}
