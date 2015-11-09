package jsr330annotations;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Jsr330Example {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:jsr330annotations/app-context.xml");
		ctx.refresh();
		MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
		renderer.render();
	}
}