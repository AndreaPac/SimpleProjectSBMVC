package it.epicode.be.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Auto {
	
	private static int finta_sequence = 0;
	
	private int id;
	private String modello;
	private String marca;
	private int cavalli;

	public Auto(String modello,String marca,int cavalli) {
		
		id = ++finta_sequence;
		
		this.modello=modello;
		this.marca=marca;
		this.cavalli=cavalli;
	}
}
