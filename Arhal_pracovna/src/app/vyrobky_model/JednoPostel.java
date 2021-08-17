package app.vyrobky_model;

public class JednoPostel extends Postele{

	public JednoPostel(String nazov, double cena, String typ, int nosnost) {
		super("Jednopostel", 110, typ, nosnost);
	}

	@Override
	public void upozorniNaNosnost() {
		this.setNosnost(125);
		
	}

}
