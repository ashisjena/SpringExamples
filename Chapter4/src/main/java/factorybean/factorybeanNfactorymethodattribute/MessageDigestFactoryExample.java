package factorybean.factorybeanNfactorymethodattribute;

import org.springframework.context.support.GenericXmlApplicationContext;

import factorybean.MessageDigester;

public class MessageDigestFactoryExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:factorybean/app-context-with-attribute.xml");
		ctx.refresh();
		MessageDigester digester = (MessageDigester) ctx.getBean("digester");
		digester.digest("Hello World!");
	}
}