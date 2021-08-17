package app.vyrobky_model;

public class ManzelskaPostel extends Postele{

	public ManzelskaPostel(String nazov, double cena, String typ, int nosnost) {
		super("Manzelska postel", 300, typ, nosnost);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void upozorniNaNosnost() {
		this.setNosnost(240);
		
	}

}
