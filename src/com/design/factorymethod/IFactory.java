package com.design.factorymethod;

/**
 * 工厂接口
 * @author yest
 *
 */
public interface IFactory {

	/**
	 * 生产产品
	 * @return
	 */
	IProduct produce();
}
