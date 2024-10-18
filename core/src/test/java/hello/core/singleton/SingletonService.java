package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {

    // 스태틱 영역에 자기 자신의 객체를 만들어 놓음
    private static final SingletonService instance = new SingletonService();

    // public 으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용
    // static 메서드를 사용한 이유?: 객체를 생성하지 않고도 이 메서드에 접근할 수 있기 때문이다
    // 이는 프로그램 내의 여러 클래스와 객체가 공통으로 같은 싱글톤 객체에 접근할 수 있게 해준다
    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){
        // private 생성자를 통해 외부에서 생성을 못하게 막는다
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
