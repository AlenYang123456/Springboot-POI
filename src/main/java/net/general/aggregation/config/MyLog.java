package net.general.aggregation.config;

/**
 * @Author: dreamer Q
 * @Date: 2019/12/3 22:36
 * @Version 1.0
 * @Discription
 */

import java.lang.annotation.*;

/**
 * 自定义注解类
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented //生成文档
public @interface MyLog {
    String value() default "";
}
