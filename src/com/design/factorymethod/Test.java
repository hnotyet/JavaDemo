package com.design.factorymethod;

public class Test {

	public static void main(String[] args) {
		IFactory factory = new CarFactory();
		
		IProduct   product = factory.produce();
		product.whoAmI();
	}
}
