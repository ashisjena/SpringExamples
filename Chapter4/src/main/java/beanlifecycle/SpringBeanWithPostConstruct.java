package beanlifecycle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

//@Component("simplebean")
public class SpringBeanWithPostConstruct {
	private static final String DEFAULT_NAME = "Luke Skywalker";
	private String name;
	private int age = Integer.MIN_VALUE;

	public void setName(String name) {
		System.out.println("Name set");
		this.name = name;
	}

	public void setAge(int age) {
		System.out.println("Age set");
		this.age = age;
	}

	@PostConstruct
	public void init() {
		System.out.println("Initializing Bean");

		if (name == null) {
			System.out.println("Using default Name");
			name = DEFAULT_NAME;
		}

		if (age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException(
					"You must set the age property of any beans of type " + SpringBeanWithPostConstruct.class);
		}
	}

	public String toString() {
		return "Name: " + name + "\nAge: " + age;
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:beanlifecycle/app-context-annotation.xml");
		ctx.refresh();
		SpringBeanWithPostConstruct SpringBeanWithPostConstruct1 = getBean("simpleBean1", ctx);
		SpringBeanWithPostConstruct SpringBeanWithPostConstruct2 = getBean("simpleBean2", ctx);
		SpringBeanWithPostConstruct SpringBeanWithPostConstruct3 = getBean("simpleBean3", ctx);
	}

	private static SpringBeanWithPostConstruct getBean(String beanName, ApplicationContext ctx) {
		try {
			SpringBeanWithPostConstruct bean = (SpringBeanWithPostConstruct) ctx.getBean(beanName);
			System.out.println(bean);
			return bean;
		} catch (BeanCreationException ex) {
			System.out.println("An error occured in bean configuration: " + ex.getMessage());
			return null;
		}
	}
}
