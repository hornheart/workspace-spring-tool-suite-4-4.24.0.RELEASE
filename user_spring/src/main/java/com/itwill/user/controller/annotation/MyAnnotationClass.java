package com.itwill.user.controller.annotation;
@MyAnnotation3(value="myAnnotation",age = 11,basePackages = "ss",required = false)
public class MyAnnotationClass {
	@MyAnnotation2(value="test",age = 33,basePackages = {"x","y"})
	public void method1() {
		
	}
}