package app.vyrobky_model;

public class Polica extends NosnyNabytok{

	public Polica(String nazov, double cena, String typ, int nosnost) {
		super("Polica", 20, typ, nosnost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void upozorniNaNosnost() {
		this.setNosnost(10);
		
	}

	
}
