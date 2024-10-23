package hello.core;


import lombok.Getter;
import lombok.Setter;

@Getter // 롬복 라이브러리를 통해 게터와 세터를 자동으로 사용할 수 있게 해준다
@Setter // 여러 기능들이 존재
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("Jake");

        String helloLombokName = helloLombok.getName();
        System.out.println("helloLombokName = " + helloLombokName);
    }
}
