package ap.sb.di.injector;

import ap.sb.di.consumer.Consumer;
import ap.sb.di.consumer.MyDIApplication;
import ap.sb.di.service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		MyDIApplication app = new MyDIApplication();
		app.setService(new EmailServiceImpl());
		return app;
	}

}
