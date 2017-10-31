package com.spc.beans;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class LoggingPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> classType) {
		//For add() method only advice for other method false
		int c=1;
		c++;
		System.out.println("Count: "+c);
		if(classType.isAssignableFrom(Calculator.class) && method.getName().equals("add")) {
			 return true;
		}
		return false;
	}

}
