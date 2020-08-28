package com.caidapao.mvcspringframework.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DPRequestParam {
    String value() default "";
}
