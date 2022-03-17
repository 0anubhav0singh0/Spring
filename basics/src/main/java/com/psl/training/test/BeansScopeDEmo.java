package com.psl.training.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.psl.training.config.BeanConfig;
import com.psl.training.model.Vehicle;

public class BeansScopeDEmo {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		Vehicle v1 = context.getBean(Vehicle.class);
		Vehicle v2 = context.getBean(Vehicle.class);
		
//		v1.setColor("Red");
//		// This will reference same object in IOC container
//		System.out.println("V1 vehicle color : " + v1.getColor());  //Red
//		System.out.println("V2 vehicle color : " + v2.getColor());  //Red
//		System.out.println(v1);
//		System.out.println(v2);
//		/*
//		 * V1 vehicle color : Red
//		 * V2 vehicle color : Red
//		 * com.psl.training.model.Vehicle@1b11171f
//		 * com.psl.training.model.Vehicle@1b11171f
//		 * */
		
		// After making @Scope("prototype")
		v1.setColor("Red");
		System.out.println("V1 vehicle color : " + v1.getColor());  //Red
		System.out.println("V2 vehicle color : " + v2.getColor());  //Blue
		System.out.println(v1);
		System.out.println(v2);
		/*
		 * V1 vehicle color : Red
		 * V2 vehicle color : Blue
		 * com.psl.training.model.Vehicle@bd4dc25
		 * com.psl.training.model.Vehicle@25084a1e
		 * */
		// @Scope("singleton") /Default Scope/ 	It means only one copy per bean created by IOC Container
		// @Scope("prototype") 					every getBean will create a separate new reference 
		
	}

}
