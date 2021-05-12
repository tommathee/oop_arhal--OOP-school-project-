package app.vyrobky_model;

public class Postele extends Vyrobky {
	
	public String typ = "";
	public int nosnost;
	
	public Postele(String typ, int nosnost){
		super("Postel", 200);
		this.typ = typ;
		this.nosnost = nosnost;
	}

}
