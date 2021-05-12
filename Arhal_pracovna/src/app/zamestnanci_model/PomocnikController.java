package app.zamestnanci_model;

public class PomocnikController extends Observer {

	public PomocnikController(Pomocnik pomocnik){
		this.pomocnik = pomocnik;
		this.pomocnik.attach(this);
	}
	
	@Override
	public void update() {
		System.out.println("Pripravujem material na vyrobu: " + pomocnik.getProdukt());
		
	}

}
