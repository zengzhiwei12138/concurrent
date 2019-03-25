package com.azj.zzw.concurrent.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author AZJ
 * @version V1.0
 * @package com.azj.zzw.concurrent.annotations
 * @desc  自定义注解--用来标记【线程安全】的类
 * Target 指的是注解的作用域
 * Retention 指的是
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {

    String value() default "";
}
