package com.azj.zzw.concurrent.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author AZJ
 * @version V1.0
 * @package com.azj.zzw.concurrent.annotations
 * @desc 用来标记【推荐的写法】
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Recommend {

    String value() default "";

}
