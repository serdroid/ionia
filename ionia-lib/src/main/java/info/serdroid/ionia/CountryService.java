package info.serdroid.ionia;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;

import info.serdroid.ionia.model.Country;

@ApplicationScoped
public class CountryService {
	@Inject
	CountryCache countryCache;
	
	public void init() {
		countryCache.reload();
	}
	
	public String getCountry(String pageName) {
		Country country = countryCache.getCountry(pageName);
		return country.toString();
	}
}
