package app.controller;

import java.util.ArrayList;

import app.vyrobky_model.NosnyNabytok;
import app.vyrobky_model.Postele;
import app.vyrobky_model.Vyrobky;
import app.zakazky_model.PrazdnaZakazkaException;
import app.zakazky_model.Zakazka;
import app.zamestnanci_model.*;

public class ProcesVyrobyController extends Thread implements Subject {

	private Thread t;
	private Zakazka zakazka;
	private ArrayList<Zamestnanci> zamestnanci;
	private ArrayList<Zamestnanci> observers = new ArrayList<>();
	
	/**
	 * konstruktor pre proces vyroby
	 * @param zak proces vyroby konkretnej zakazky, nad ktorou bola zavolana metoda
	 * @param zam kazdemu zamestnancovi priradi nejaku pracu
	 */
	public ProcesVyrobyController(Zakazka zak, ArrayList<Zamestnanci> zam) {
		this.zakazka = zak;
		this.zamestnanci = zam;
	}
	
	/**
	 * metoda zodpovedna za odoslanie zakazky na vyrobu, vyuzivam pri tom multithreading
	 * cez volanie metody run() sa vykona pripravenie od Pomocnika, ktory ked dokonci,
	 * upozorni na to vsetkych observerov (ostatnych zamestnancov) a medzitym sa spusti dalsie vlakno,
	 * pre kazdy vyrobok v zakazke
	 * @throws PrazdnaZakazkaException v pripade ze je prazdna zakazka, nemozno ju vyrobit
	 */
	public void pripravVyrobu() throws PrazdnaZakazkaException {
		
		if (!(this.zakazka.getVyrobky().isEmpty())) {
			
			pridajObserver();			
			run();
			delObservers();
		}
		
		else 	
			throw new PrazdnaZakazkaException();
		this.zakazka.setVyrobena(true);
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#start()
	 */
	public void start(){
		if (t == null) {
			t = new Thread (this);
	        t.start ();
	    }
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		for (Vyrobky v : zakazka.getVyrobky()){
			
			System.out.println("* * * * * * * * * * * * * * * * *");
			
			if (v instanceof NosnyNabytok){
				((NosnyNabytok) v).upozorniNaNosnost();
				((NosnyNabytok) v).pozorNosnost((NosnyNabytok) v);
			}
			
			if (v instanceof Postele){
				((Postele) v).upozorniNaNosnost();
				((Postele) v).pozorNosnost((Postele) v);
			}
			
			for (Observer z : zamestnanci){
				
				if (z instanceof Pomocnik){
					((Pomocnik) z).setProdukt(v.getNazov());
					notifyZamestnanci();
				}
				else continue;
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
				}				
			}				
		}
	}
	

	/* (non-Javadoc)
	 * @see app.controller.Subject#delObservers()
	 */
	@Override
	public void delObservers() {
		observers.clear();		
	}

	/* (non-Javadoc)
	 * @see app.controller.Subject#pridajObserver()
	 */
	@Override
	public void pridajObserver() {
		for (Zamestnanci z : zamestnanci){
		if (z instanceof Pomocnik) continue;
		
		if (z instanceof Monter) continue;
			
		else observers.add(z);	
		}
	}

	/* (non-Javadoc)
	 * @see app.controller.Subject#notifyZamestnanci()
	 */
	@Override
	public void notifyZamestnanci() {
		for(Observer obs : observers){			
			obs.update();		
		}		
	}

	public Zakazka getZakazka() {
		return zakazka;
	}

	public void setZakazka(Zakazka zakazka) {
		this.zakazka = zakazka;
	}
	

}
