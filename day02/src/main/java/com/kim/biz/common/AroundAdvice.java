package com.kim.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

// around로 사용할 advice는 반드시 pjp를 input으로 가져야한다!!
// ex) 필터 서블릿 클래스

@Service
@Aspect
public class AroundAdvice {
	
	
	@Around("PointcutCommon.aPointcut()")
	public Object printLogAround(ProceedingJoinPoint pjp) throws Throwable {		
		
		String methodName = pjp.getSignature().getName();
		// 현재 수행중인 포인트컷(핵심로직,CRUD)의 메서드명
		System.out.println("수행중인 핵심메서드명: "+methodName);
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object returnObj = pjp.proceed(); // 수행해야할 포인트컷
		// pjp.proceed()에 의해 비즈니스 메서드가 수행됨!
		sw.stop();
		System.out.println("수행시간: "+sw.getTotalTimeMillis()+"ms");
		
		return returnObj;
	}
}
