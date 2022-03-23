package com.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//        System.out.println( "Hello World!" );
		AbstractApplicationContext con = new AnnotationConfigApplicationContext(AppConfig.class);
		Student student = con.getBean("student", Student.class);
		//joinpoint(before)
//		student.study(5,5);
		//joinpoint(after)
		
		int rank = student.rankOfVideo(100, 65);
		System.out.println("Video Ranking Position is : " + rank);
		
//		Employee employee = con.getBean("employee", Employee.class);
		//joinpoint(before)
//		employee.studySomething();
		//joinpoint(after)
	}
}
