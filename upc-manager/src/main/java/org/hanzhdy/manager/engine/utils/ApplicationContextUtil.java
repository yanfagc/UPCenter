package org.hanzhdy.manager.engine.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtil implements ApplicationContextAware {
	
	private static ApplicationContext context;

	public void setApplicationContext(ApplicationContext c) throws BeansException {
		context = c;
	}
	
	public static ApplicationContext getApplicationContext(){
		return context;
	} 
	
	public static <T> T getBean(String beanId,Class<T> clazz){
		Object obj = context.getBean(beanId);
		return (T)obj;
	}
}
