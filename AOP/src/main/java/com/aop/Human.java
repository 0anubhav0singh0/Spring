package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
public class Human {
//	@Before("execution(public void com.aop.Student.study())")
//	public void wakeUp() {
//		System.out.println("Good Morning...");
//	}
	
//	// >> Aap ye chahate ho ki jitne bhi methods hai pure entire application me uske baad Advice call ho jana chahiye
//	// * wildCard operator 
//	// this will look for method starting from study....() (eg.. studyTonight(), studeSomething())
//	@Before("execution(public void study*())")
//	public void wakeUp() {
//		System.out.println("Good Morning...");
//	}
	
	// * iska matlab yaha ye hai ki koi bhi method ka signature ho matlab koi bhi return type ho
//	@Before("execution(public * study*())")
//	public void wakeUp() {
//		System.out.println("Good Morning...");
//	}
	
	// ------------------------------------------------------------------------------------------------------------------------
	// execution(public * study*()) issi expression koi hi pointcuts kehte hai
	// ku bolte hai ? kuki yaha par aapne bataya ki yaha par wakeUp ya sleep naame ka advice execute karana chahate ho
//	@Before("myPointCuts()")
//	public void wakeUp() {
//		System.out.println("Good Morning ...");
//	}
//	
//	@After("myPointCuts()")
//	public void sleep() {
//		System.out.println("Good Evening....");
//	}
//	
//	@Pointcut("execution(public * study*())")
//	public void myPointCuts() {}
	// ------------------------------------------------------------------------------------------------------------------------
	
	
	// ------------------------------------------------------------------------------------------------------------------------
	// me chahata hu ki ye jo method chal raha hai ye kis type ka hai, iska return type kya hai, ye kitne parameter le raha hai ye saari information hame mil jaye
	// or konsa argument pass ho raha hai ye bhi gether karna hai hame
	// ye ham karenge joinpoint object ki madat se easily gather kar sakte hai 
//	@Before("myPointCuts()")
//	public void wakeUp(JoinPoint j) {
//		//System.out.println("Good Morning ..." + j.getArgs()); // Good Morning ...[Ljava.lang.Object;@54c62d71 // this is array
//		System.out.println("Good Morning ..." + j.getArgs()[0]); // first parameter
//	}
//	
//	@After("myPointCuts()")
//	public void sleep() {
//		System.out.println("Good Evening....");
//	}
//	
//	@Pointcut("execution(public * study*(..))")
//	public void myPointCuts() {}
	// ------------------------------------------------------------------------------------------------------------------------
	
	
	
	// AFTERRETURNING
	// https://www.youtube.com/watch?v=e7h8y2rynWc&list=PL5mjp3QjkuoLQyAmAYgSALsDDHmjyLxbC&index=7
	
	
	// AFTERTHROWING
	// https://www.youtube.com/watch?v=skLtAwC68ro&list=PL5mjp3QjkuoLQyAmAYgSALsDDHmjyLxbC&index=8
	
	//
}
