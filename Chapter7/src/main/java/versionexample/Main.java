package versionexample;

import java.util.Date;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:versionexample/app-context.xml");
		ctx.refresh();
		ContactDAO dao = ctx.getBean("contactDAO", ContactDAO.class);
		/*Contact contact = new Contact();
		contact.setFirstName("RAMA");
		contact.setLastName("BEHERA");
		contact.setBirthDate(new Date());*/
		Contact contact = dao.get(1);
		contact.setFirstName("BHIMA");
		dao.saveOrUpdate(contact);
	}
}