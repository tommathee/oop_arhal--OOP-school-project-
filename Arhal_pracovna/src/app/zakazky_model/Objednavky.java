package app.zakazky_model;

import java.util.ArrayList;

public class Objednavky {
	
    // Singleton:
    private static Objednavky instance;
    private Objednavky() {}
    public static Objednavky getInstance() {
        if (instance == null) {
            instance = new Objednavky();
        }
        return instance;
    }
	
	public ArrayList<Zakazka> zakazka = new ArrayList<>();
	
    public void vypisZakazky() {
        for (Zakazka z: zakazka) {
            System.out.println(z.getVypis());
        }
    }

}
