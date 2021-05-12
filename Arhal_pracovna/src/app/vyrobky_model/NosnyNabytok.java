package app.vyrobky_model;

public abstract class NosnyNabytok extends Vyrobky {
	
	private String typ = "";
	private double nosnost;
	
	public NosnyNabytok(String nazov, double cena, String typ, double nosnost){
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

	public void setNosnost(double nosnost) {
		this.nosnost = nosnost;
	}

}
