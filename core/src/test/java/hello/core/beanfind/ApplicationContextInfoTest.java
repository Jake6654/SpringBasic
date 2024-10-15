package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String [] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + "object = " + bean);

        }
    } @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String [] beanDefinitionNames = ac.getBeanDefinitionNames(); // container 에 저장된 모든 빈의 이름을 가져온다
        for (String beanDefinitionName : beanDefinitionNames) {
            // BeanDefinition: 빈의 메타데이터(객체 정보)를 정의하는 인터페이스이다. 생성 정보, 의존성 등등
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // 빈의 이름을 전달하여 빈의 객체정보를 가져옴(메타 데이터) 역할군을 체크하기 위해

            // 빈의 메타 정보가 저장된 beanDefinition 변수에 getRole() 을 사용하여 역할군 체크
            // Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE: 스프링 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){ // 역할군 체크
                Object bean = ac.getBean(beanDefinitionName); // getBean(빈 이름)을 통해 빈(객체)을 불러옴
                System.out.println("name = " + beanDefinitionName + " object = " + bean);  // beanDefinitionName: 빈 이름(메서드 이름) + 빈(객체) 참조값 출력
            }




        }
    }
}
