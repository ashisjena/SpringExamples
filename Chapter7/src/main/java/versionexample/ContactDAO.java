package versionexample;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("contactDAO")
@Scope("singleton")
@Transactional
public class ContactDAO {
	@Autowired(required = true)
	private SessionFactory factory = null;

	@SuppressWarnings("unchecked")
	public List<Contact> list() {
		return factory.getCurrentSession().createQuery("FROM Contact").list();
	}

	public Contact get(long id) {
		return factory.getCurrentSession().get(Contact.class, id);
	}

	public void saveOrUpdate(Contact entity) {
		factory.getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(int id) {
		Contact contact = new Contact();
		contact.setId((long) id);
		factory.getCurrentSession().delete(contact);
	}
}