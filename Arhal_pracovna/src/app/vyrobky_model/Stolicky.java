package app.vyrobky_model;

public abstract class Stolicky extends Vyrobky{
	
	private String typ = "";
	
	public Stolicky(String nazov, double cena, String typ){
		super(nazov, cena);
		this.setTyp(typ);
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

}
