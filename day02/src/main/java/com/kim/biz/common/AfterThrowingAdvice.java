package com.kim.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;


@Service
@Aspect
public class AfterThrowingAdvice {
	
	
	@AfterThrowing(pointcut="PointcutCommon.aPointcut()", throwing="exceptObj")
	public void printLogAfterThrowning(JoinPoint jp,Exception exceptObj) {
		String methodName = jp.getSignature().getName();
		// 현재 수행중인 포인트컷(핵심로직,CRUD)의 메서드명
		Object[] args = jp.getArgs();
		// 현재 수행중인 포인트컷(핵심로직,CRUD)이 사용하는 인자들의 정보

		System.out.println("수행중인 핵심메서드명: "+methodName);
		System.out.println("사용하는 인자");
		System.out.println("=========");
		for(Object v:args) {
			System.out.println(v);
		}
		System.out.println("=========");
		
		System.out.println("발생한 예외: "+exceptObj.getMessage());
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("올바르지 않은 인자값.....");
		}
		else if(exceptObj instanceof NumberFormatException) {
			System.out.println("숫자 형식이 아닌 값....");
		}
		else if(exceptObj instanceof Exception) {
			System.out.println("예외가 발생...");
		}
		else {
			System.out.println("확인되지 않은 에러 발생!!!");
		}
	}
	
}
