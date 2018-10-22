package com.che.service.bean;

/**
 * 实现此接口的类可以得到代理类
 * 
 * @author tmgan
 */
public interface BeanSelfAware {
	
	void setSelf(Object proxyBean);
}
