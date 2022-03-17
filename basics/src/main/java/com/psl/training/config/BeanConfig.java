package com.psl.training.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.psl.training.model.Accessories;
import com.psl.training.model.Engine;
import com.psl.training.model.Vehicle;

@Configuration // this annotation will tell spring that this class provide Configuration
@ComponentScan(basePackages = "com.psl.training")
@PropertySource(value="classpath:/application.properties")
public class BeanConfig {
	
	@Value("${vehicle.name}")
	String name;
	
//	@Value("{vehicle.wheels.count}")
//	int noOfWheels;
	
	@Value("${vehicle.color}")
	String color;
	
	@Value("${vehicle.engine.capacity}")
	String engineCapacity;
	
	@Value("${vehicle.elecEngin.capacity}")
	String eleEngineCapacity;
	
	// if you have to set values then use @Bean other wise use @Component
	@Bean
	@Scope("prototype")
	public Vehicle getVehicle() {
		Vehicle vehicle = new Vehicle(name, color);
		return vehicle;
	}
	
	@Bean("engine") // writing inside Bean to call by byName if they belong to same class
	public Engine getEngine() {
		Engine engine = new Engine();
		engine.setCapacity(engineCapacity);
		return engine;
	}
	
	@Bean("engineElectric")
	public Engine getEngineElectric() {
		Engine engine = new Engine();
		engine.setCapacity(eleEngineCapacity);
		return engine;
	}
	
//	@Bean
//	public Accessories getAccessories() {
//		return new Accessories();
//	}
}
