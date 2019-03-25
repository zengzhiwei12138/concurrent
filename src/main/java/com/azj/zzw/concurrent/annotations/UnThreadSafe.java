package com.azj.zzw.concurrent.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author AZJ
 * @version V1.0
 * @package com.azj.zzw.concurrent.annotations
 * @desc 线程不安全的类 -- 用来标记【线程不安全】的类
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface UnThreadSafe {

    String value() default "";

}
