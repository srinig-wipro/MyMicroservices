package com.journaldev.java.dependencyinjection.test;


import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ap.sb.di.consumer.Consumer;
import ap.sb.di.consumer.MyDIApplication;
import ap.sb.di.injector.MessageServiceInjector;
import ap.sb.di.service.MessageService;

public class MyDIApplicationJUnitTest {

	private MessageServiceInjector injector;
	@BeforeAll
	public void setUp(){
		//mock the injector with anonymous class
		injector = new MessageServiceInjector() {
			
			@Override
			public Consumer getConsumer() {
				//mock the message service
				return new MyDIApplication(new MessageService() {
					
					@Override
					public void sendMessage(String msg, String rec) {
						System.out.println("Mock Message Service implementation");
						
					}
				});
			}
		};
	}
	
	@Test
	public void test() {
		Consumer consumer = injector.getConsumer();
		consumer.processMessages("Hi Pankaj", "pankaj@abc.com");
	}
	
	@After(value = "")
	public void tear(){
		injector = null;
	}

}
