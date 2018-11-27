package info.serdroid.ionia;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import info.serdroid.ionia.model.Country;

@ApplicationScoped
public class CountryCache {
	Country NOT_FOUND;
	
	@Inject
	CountryDao countryDao;
	Map<String, Country> countryByAlpha2Code;

	public CountryCache() {
		countryByAlpha2Code = new HashMap<>();
	}

	void reload() {
		List<Country> allItems = countryDao.getAll();
		allItems.forEach(this::addItem);
	}
	
	void addItem(Country country) {
		System.out.println("adding => " + country);
		countryByAlpha2Code.put(country.getAlpha2Code(), country);
	}
	
	public Country getCountry(String alpha2) {
		Country found = countryByAlpha2Code.get(alpha2); 
		System.out.printf("searching for %s and found = %s", alpha2, found);
		return found != null ? found : NOT_FOUND;
	}

	void load(@Observes @Initialized(ApplicationScoped.class) Object obj) {
		System.out.println("---- MenuCache#reload ----");
		NOT_FOUND = new Country();
		NOT_FOUND.setId((short) -1);
		NOT_FOUND.setAlpha2Code("NOT_FOUND");
		NOT_FOUND.setName("Not Found");
		reload();
	}
	
}
