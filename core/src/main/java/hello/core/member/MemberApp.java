package hello.core.member;

import hello.core.AppConfig;
import hello.core.member.Grade;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//       AppConfig appConfig = new AppConfig();
//       MemberService memberServiceImpl = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // memberService 라는 메서드를 가져오고, type 은 MemberService 이다


        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " +memberA.getName());
        System.out.println("find member = " +findMember.getName());
}
}
