package sampleexample.dao;

import java.io.Serializable;
import java.util.List;

public interface EntityDAO<T extends Serializable> {

	public List<T> list();

	public T get(int id);

	public void saveOrUpdate(T entity);

	public void delete(int id);
	
	public void delete(T entity);
}