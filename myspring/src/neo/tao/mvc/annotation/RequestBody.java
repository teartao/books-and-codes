package neo.tao.mvc.annotation;

import java.lang.annotation.*;

/**
 * @Author neotao
 * @Date 2018/8/3
 * @Version V0.0.1
 * @Desc
 */
@Documented
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestBody {
    String value() default "";
}
