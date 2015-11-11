package sample;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JmsSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		MessageSender messageSender = ctx.getBean("messageSender", MessageSender.class);
		for (int i = 0; i < 10; i++) {
			messageSender.sendMessage("Test message: " + i);
		}
	}
}