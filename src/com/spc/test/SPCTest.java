package com.spc.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.spc.beans.Calculator;
import com.spc.beans.LoggingAdvice;
import com.spc.beans.LoggingPointcut;

public class SPCTest {
	public static void main(String[] args) {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new Calculator());
		/*pf.addAdvice(new LoggingAdvice());*/
		pf.addAdvisor(new DefaultPointcutAdvisor(new LoggingPointcut(), new LoggingAdvice()));

		Calculator proxy = (Calculator) pf.getProxy();
		int sum = proxy.add(10, 20);
		int mul = proxy.multiply(10, 2);
		System.out.println("Sum = " + sum);
		System.out.println("Multiply = "+ mul);
	}
}
