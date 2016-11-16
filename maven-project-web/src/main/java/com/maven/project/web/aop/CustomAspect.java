package com.maven.project.web.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAspect {
	
	@Pointcut("execution(* com.maven.project.services..for*(..))")
	public void query(){}
	
	@Pointcut("@annotation(com.maven.project.web.customAnnotations.QuerySystem)")
	public void loginTimeOut(){}
	
	
	@Before("query()")//方法之前执行
	public void queryBefore(JoinPoint joinPoint){
		System.out.println("=======query start @Before ====方法名称:"+joinPoint.getSignature().getName());
	}
	
	@After("query()")//方法之后执行
	public void queryAfter(JoinPoint joinPoint){
		System.out.println("=======query end @After ====方法名称:"+joinPoint.getSignature().getName());
	}
	
	@Around("query()")//方法前后执行,如果需要返回值,则必须  return joinPoint.proceed(); 返回类型为Object
	public void queryAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("=======query start @Around ====方法名称:"+joinPoint.getSignature().getName());
		joinPoint.proceed();
		System.out.println("=======query end @Around ====方法名称:"+joinPoint.getSignature().getName());
	}
	
	@Around("loginTimeOut()")
	public void times(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.currentTimeMillis();
		joinPoint.proceed();
		long end = System.currentTimeMillis();
		System.out.println("======= 登陆耗时："+(end-start)/1000+" ====方法名称:"+joinPoint.getSignature().getName());
	}
}
