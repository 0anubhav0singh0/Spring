package com.psl.training.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Vehicle {
	public String color;
	public String name;

	@Autowired
	public Engine engine;

	@Autowired
	public Engine engineElectric;

	public Vehicle(String name, String color) {
		super();
		this.color = color;
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Engine getEngineElectric() {
		return engineElectric;
	}

	public void setEngineElectric(Engine engineElectric) {
		this.engineElectric = engineElectric;
	}

}
