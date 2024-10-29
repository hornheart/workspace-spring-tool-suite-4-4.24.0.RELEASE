package com.itwill.user.controller.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotation3 {
	String value() default "" ;
	int age() default 30;
	String[] basePackages() default {};
	boolean required() default false;
}