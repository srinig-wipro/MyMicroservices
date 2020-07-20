package ap.sb.di.injector;

import ap.sb.di.consumer.Consumer;
import ap.sb.di.consumer.MyDIApplication;
import ap.sb.di.service.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new SMSServiceImpl());
	}

}
