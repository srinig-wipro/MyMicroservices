package com.journaldev.java.dependencyinjection.test;

import ap.sb.di.consumer.Consumer;
import ap.sb.di.injector.EmailServiceInjector;
import ap.sb.di.injector.MessageServiceInjector;
import ap.sb.di.injector.SMSServiceInjector;

public class MyMessageDITest {

	public static void main(String[] args) {
		String msg = "Hi Pankaj";
		String email = "pankaj@abc.com";
		String phone = "4088888888";
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		//Send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, email);
		
		//Send SMS
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, phone);
	}

}
