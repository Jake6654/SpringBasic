package hello.core.annotation;


import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
// Qualifier 애노테이션을 재정의 함으로써(기능은 같지만) 코드를 더욱 간결하게 쓸 수 있다

public @interface MainDiscountPolicy {
}
