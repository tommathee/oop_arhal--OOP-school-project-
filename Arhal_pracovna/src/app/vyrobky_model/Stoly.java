package app.vyrobky_model;

public abstract class Stoly extends Vyrobky{
	
	String typ = "";
	
	public Stoly(String nazov, double cena, String typ){
		super(nazov, cena);
		this.typ = typ;
	}

}
