package org.borko.search.manager.formats.video;


import org.borko.search.manager.interfaces.ABSTRACT_VIDEOS;
import org.borko.search.manager.interfaces.FILE_IMPL;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestVideoFormats {


	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
		System.out.println(context.getBeanDefinitionCount());
		
	}

}
