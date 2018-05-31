package com.hero.fitness.annotation;

import java.lang.annotation.*;

/**
 * @program: rry
 * @description:
 * @author: XiaoYu
 * @create: 2018-03-21 16:54
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface RequestValid {

    public boolean argsValid() default true;

    public boolean argsLog() default true;
}
