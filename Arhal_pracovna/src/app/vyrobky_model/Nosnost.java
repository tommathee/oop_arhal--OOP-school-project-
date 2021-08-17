package app.vyrobky_model;

public interface Nosnost {

	public void upozorniNaNosnost();
	default public void pozorNosnost(NosnyNabytok n){
		System.out.println("Pozor, tento nabytok je ohraniceny maximalnou nosnostou: " + n.getNosnost());
	}
	
	default public void pozorNosnost(Postele p){
		System.out.println("Pozor, postel je ohranicena maximalnou nosnostou: " + p.getNosnost());
	}
}
