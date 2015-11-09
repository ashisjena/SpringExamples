package autowirewithQualifierAnnotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:autowirewithQualifierAnnotation/app-context.xml");
		ctx.refresh();
		Dependant dependant = (Dependant) ctx.getBean("dependant");
		System.out.println(dependant.getStudent().getDeptName());
	}
}
