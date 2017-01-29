package edu.wi.entity;

import java.util.List;

public class Nauczyciel extends User {

	private List<String> przedmiot;
	private List<String> klasa;
	
	public List<String> getPrzedmiot() {
		return przedmiot;
	}
	public void setPrzedmiot(String przedmiot) {
		this.przedmiot.add(przedmiot);
	}
	public List<String> getKlasa() {
		return klasa;
	}
	public void setKlasa(String klasa) {
		this.klasa.add(klasa);
	}
	
	
}
