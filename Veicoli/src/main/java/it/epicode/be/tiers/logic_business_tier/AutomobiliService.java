package it.epicode.be.tiers.logic_business_tier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.epicode.be.model.Auto;
import it.epicode.be.tiers.data_persistence_tier.AutomibiliRepo;
@Component
public class AutomobiliService {
	
	@Autowired
	private AutomibiliRepo repo;
	
	
	public void aggiungiAuto(Auto a) {
		repo.addAuto(a);
	}

	public void rimuoviAuto(Auto a) {
		repo.removeAuto(a);
	}
	public List<Auto> getListaAuto(){
		return repo.getGarage();
	}

	
}
