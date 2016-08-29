package com.design.factorymethod;

public class CarFactory implements IFactory {

	@Override
	public IProduct produce() {
		return new Car();
	}
}
