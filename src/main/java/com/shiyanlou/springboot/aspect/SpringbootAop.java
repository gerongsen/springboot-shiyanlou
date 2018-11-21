package com.shiyanlou.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//声明为切面类
@Aspect
@Component
public class SpringbootAop {
	
	@Pointcut(value = "execution(* com.shiyanlou.springboot.test.*.run(..))")
	public void aop() {
		
	}
	
	@Before("aop()")
	public void before() {
		System.out.println("before:执行方法前");
	}
	
	@After("aop()")
	public void after() {
		System.out.println("after:执行方法后");
	}
	
	@AfterThrowing("aop()")
	public void afterThrowing() {
		System.out.println("afterThrowing:抛出异常后");
	}
	
	@AfterReturning("aop()")
	public void afterReturning() {
		System.out.println("afterReturning:方法返回后");
	}
	
	@Around("aop()")
	public void around(ProceedingJoinPoint joinPoint) {
		System.out.println("around:环绕通知前");
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("around:环绕通知后");
	}
}
