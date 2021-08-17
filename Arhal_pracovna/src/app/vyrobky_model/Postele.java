package app.vyrobky_model;

public abstract class Postele extends Vyrobky implements Nosnost {
	
	private String typ = "";
	private int nosnost = 0;
	
	public Postele(String nazov, double cena, String typ, int nosnost){
		super(nazov, cena);
		this.setTyp(typ);
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public double getNosnost() {
		return nosnost;
	}

	public void setNosnost(int nosnost) {
		this.nosnost = nosnost;
	}
	
}
