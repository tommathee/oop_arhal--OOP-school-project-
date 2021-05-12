package app.vyrobky_model;

public abstract class Vyrobky {

	private String nazov = "";
	private double cena = 0;
	
	public Vyrobky(String nazov, double cena){
		this.setNazov(nazov);
		this.setCena(cena);
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getNazov() {
		return nazov;
	}

	public void setNazov(String nazov) {
		if (nazov.isEmpty()) throw new RuntimeException("Ziadny nazov produktu");
		this.nazov = nazov;
	}

	public void vypisTyp() {
		System.out.println("Typ nabytku: " + nazov);
		
	}
	
}
