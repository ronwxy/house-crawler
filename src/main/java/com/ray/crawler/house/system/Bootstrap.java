package com.ray.crawler.house.system;

import java.io.IOException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ray4w on 2016/7/15.
 */
public class Bootstrap {
	
	public static AbstractApplicationContext ctx;

	public static void main(String[] args) throws IOException{
    	ctx = new ClassPathXmlApplicationContext(new String[] {"classpath:applicationContext.xml"});
    	System.in.read();
    	ctx.registerShutdownHook();
    }
}
