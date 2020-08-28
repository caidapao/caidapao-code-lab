package com.caidapao.mvcspringframework.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DPAutowired {
    String value() default "";
}
