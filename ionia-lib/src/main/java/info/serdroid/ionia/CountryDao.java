package info.serdroid.ionia;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import info.serdroid.ionia.model.Country;

@ApplicationScoped
public class CountryDao {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Country> getAll() {
		return entityManager.createQuery("select c from Country c", Country.class).getResultList();
	}
	
}
