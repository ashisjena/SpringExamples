package factorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestExampleMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:factorybean/app-context.xml");
		ctx.refresh();
		MessageDigester digester = (MessageDigester) ctx.getBean("digester");
		digester.digest("Hello World!");
	}
}