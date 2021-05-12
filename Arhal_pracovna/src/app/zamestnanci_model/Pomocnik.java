package app.zamestnanci_model;

import java.util.ArrayList;
import java.util.List;

public class Pomocnik extends Zamestnanci {
	
	private List<Observer> observers = new ArrayList<Observer>();
	private boolean priprav = false;
	private String produkt;
	
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public boolean isPriprav() {
		return priprav;
	}
	
	public void setPriprav(boolean priprav) {
		this.priprav = priprav;
	}
	
	public String getProdukt() {
		return produkt;
	}

	public void setProdukt(String produkt) {
		this.produkt = produkt;
		notifyAllObervers();
	}
	
	
	private void notifyAllObervers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

}
