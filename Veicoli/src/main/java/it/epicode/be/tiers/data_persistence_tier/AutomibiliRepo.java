package it.epicode.be.tiers.data_persistence_tier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.epicode.be.model.Auto;
import lombok.Getter;
@Component
public class AutomibiliRepo {
	@Getter
	private List<Auto> garage;
	
	public AutomibiliRepo() {
		
		garage = new ArrayList<Auto>();
		
		garage.add(new Auto( "Panda","Fiat", 80));
		garage.add(new Auto( "Portofino","Ferrari", 400));
		garage.add(new Auto( "ClasseA","Mercedes", 150));
		garage.add(new Auto( "Fiesta","Ford", 100));
		garage.add(new Auto( "Focus","Ford", 120));
		garage.add(new Auto( "Y","Lancia", 70));
	}
	public void addAuto(Auto auto) {
		garage.add(auto);
	}
	public void removeAuto(Auto auto) {
		garage.remove(auto);
	}
}
