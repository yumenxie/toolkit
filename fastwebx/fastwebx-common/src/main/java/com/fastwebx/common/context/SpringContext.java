package com.fastwebx.common.context;

import java.io.FileOutputStream;
import java.util.Enumeration;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringContext implements ApplicationContextAware {

	
	@Override
	public void setApplicationContext(ApplicationContext value)
			throws BeansException {
		ctx = value;
		
	}

	public static <T> T getBean(Class<T> clazz){
		String name = clazz.getSimpleName();
		return (T) ctx.getBean( name.substring(0,1).toLowerCase()+name.substring(1));
	}
	
	public static Object getBean(String beanId){
		return ctx.getBean(beanId);
	}
	
	
	public static void setContext(ApplicationContext context){
		ctx=context;
	}
	
	private static ApplicationContext ctx;
	
}
