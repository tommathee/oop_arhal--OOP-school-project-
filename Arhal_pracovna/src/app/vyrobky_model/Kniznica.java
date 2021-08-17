package app.vyrobky_model;

public class Kniznica extends NosnyNabytok {

	public Kniznica(String nazov, double cena, String typ, int nosnost) {
		super("Kniznica", 60, typ, nosnost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void upozorniNaNosnost() {
		this.setNosnost(35);
		
	}

	
}
