package com.spc.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String methodName = null;
		Object[] args = null;
		methodName = methodInvocation.getMethod().getName();
		args = methodInvocation.getArguments();

		System.out.println("Entering into " + methodName + "(" + args[0] + "," + args[1] + ")");

		Object ret = methodInvocation.proceed();
		
		System.out.println("Exiting from " + methodName + "() with ret = " + ret);

		return ret;
	}

}
