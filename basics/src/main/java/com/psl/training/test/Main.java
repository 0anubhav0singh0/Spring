package com.psl.training.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.psl.training.config.BeanConfig;
import com.psl.training.model.Vehicle;

public class Main {

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beanConfig.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
//		Vehicle vehicle = (Vehicle) context.getBean("v1");
		Vehicle vehicle = context.getBean(Vehicle.class);
		
		System.out.println(vehicle.getName() + "-" + vehicle.getColor() + "-" + vehicle.getEngine().getCapacity());
		System.out.println(vehicle.getName() + "-" + vehicle.getColor() + "-" + vehicle.getEngineElectric().getCapacity());
//		System.out.println();
	}

}
