package app.vyrobky_model;

public class Regal extends NosnyNabytok {

	public Regal(String nazov, double cena, String typ, int nosnost) {
		super("Regal", 80, typ, nosnost);
	}

	@Override
	public void upozorniNaNosnost() {
		this.setNosnost(70);
		
	}

}
