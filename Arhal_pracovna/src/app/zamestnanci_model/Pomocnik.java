package app.zamestnanci_model;


public class Pomocnik extends Zamestnanci {
	
	private boolean priprav = false;
	private String produkt;
	
	 
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
		System.out.println("Pripravujem material na vyrobu: " + this.getProdukt());
	}
	
}
