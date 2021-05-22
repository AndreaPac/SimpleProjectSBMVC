package it.epicode.be.tiers.presentation_ui_tier;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.epicode.be.model.Auto;
import it.epicode.be.tiers.logic_business_tier.AutomobiliService;

//ci leghiamo all0interfaccia grafica con il controller
@Controller
public class AutomobiliController {
	
	@Autowired
	private AutomobiliService servizioAuto;

	@GetMapping("/")
	public String listaAuto(Map<String,Object> modello) {
		
		modello.put("automobili",servizioAuto.getListaAuto());
	
		return "listaAutomobili";
	}
	
	
	
	@GetMapping("/elimina")
	public String eliminaAuto(@RequestParam int idAuto,Map<String,Object> modello) {
		
		Auto daEliminare = null;
		for(Auto auto: servizioAuto.getListaAuto()) {
			if(auto.getId() == idAuto)
				daEliminare = auto;
		}
		
		if(daEliminare != null)
			servizioAuto.rimuoviAuto(daEliminare);
		
		modello.put("automobili",servizioAuto.getListaAuto());
		
		return "listaAutomobili";
	}
	
	
	@GetMapping("/modifica")
	public String modificaAuto(@RequestParam int idAuto,Map<String,Object> modello) {
		
		
		Auto daModificare = null;
		for(Auto auto: servizioAuto.getListaAuto()) {
			if(auto.getId() == idAuto)
				daModificare = auto;
		}
		
		
		modello.put("autoSingola", daModificare);
		
		return "dettagliSingolaAuto";
	}
	
	@GetMapping("/salva")
	public String salvaAuto(@ModelAttribute("autoSingola") Auto nuovaAuto,Map<String,Object> modello) {
		
		Auto daModificare = null;
		for(Auto auto: servizioAuto.getListaAuto()) {
			if(auto.getId() == nuovaAuto.getId())
				daModificare = auto;
		}

		if(daModificare != null) {
			servizioAuto.rimuoviAuto(daModificare);
		}
		servizioAuto.aggiungiAuto(nuovaAuto);
		
		modello.put("automobili",servizioAuto.getListaAuto());

		
		return "listaAutomobili";
	}
	
	
	@GetMapping("/nuova")
	public String nuovaAuto(Map<String,Object> modello) {

		Auto nuovaAuto = new Auto("", "", 0);
		modello.put("autoSingola", nuovaAuto);

		
		return "dettagliSingolaAuto";
	}
}
