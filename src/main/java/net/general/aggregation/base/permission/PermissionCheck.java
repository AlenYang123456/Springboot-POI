//package net.general.aggregation.base.permission;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
///**
// * @Author: dreamer Q
// * @Date: 2019/11/18 20:11
// * @Version 1.0
// * @Discription 自定义权限校验注解
// * AOP实现接口权限的校验
// * 前提:rbac的权限控制
// * 相关文件 PermissionCheckAspect
// *         PermissionManager
// */
//@Target({ElementType.METHOD,ElementType.TYPE})
//@Retention(RetentionPolicy.RUNTIME)
//public @interface PermissionCheck {
//
//    String value() default "";
//
//    boolean require() default true;
//}
