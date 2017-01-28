package edu.wi.entity;

import java.util.List;

public class Nauczyciel extends User {

	private List<Przedmiot> przedmiot;
	private List<Klasa> klasa;
	
	public List<Przedmiot> getPrzedmiot() {
		return przedmiot;
	}
	public void setPrzedmiot(List<Przedmiot> przedmiot) {
		this.przedmiot = przedmiot;
	}
	public List<Klasa> getKlasa() {
		return klasa;
	}
	public void setKlasa(List<Klasa> klasa) {
		this.klasa = klasa;
	}
	
	
}
