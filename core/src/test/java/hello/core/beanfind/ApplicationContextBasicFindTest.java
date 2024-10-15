package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService",MemberService.class); // 빈 이름으로 조회
        Assertions.assertInstanceOf(MemberService.class,memberService); // 멤버 서비스 변수가 멤버 서비스 클래스의 인스턴스 인지 테스트
    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class); // 타입으로 조회
        Assertions.assertInstanceOf(MemberService.class,memberService);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){ // 구체적인 것에 의존하기 때문에 좋지 않은 코드이다
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertInstanceOf(MemberService.class,memberService);
    }
    
    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
        // 빈 이름으로 조회가 안됬을때 오류가 뜨는 테스트
      Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxxx", MemberService.class));
      // assertThrows(예외클래스(예상되는 예외 클래스), 람다 표현식(실제로 예외가 발생할 것으로 예상되는 코드를 람다로 작성))

    }
    
}
