package app.zakazky_model;

import java.util.ArrayList;
import java.util.Date;
import app.vyrobky_model.*;

public class Zakazka{

	//private String zakaznik;
	private Date datum;
	private boolean vyrobena = false;
	private ArrayList<Vyrobky> vyrobky = new ArrayList<>();

	
	public Zakazka() {
		setDatum(new Date());
	}

	public ArrayList<Vyrobky> getVyrobky() {
		return vyrobky;
	}

	public void setVyrobky(ArrayList<Vyrobky> vyrobky) {
		this.vyrobky = vyrobky;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

    public String getVypis() {
        StringBuilder sb = new StringBuilder();
        sb.append("ZAKAZKA: ");
        sb.append(getDatum());
        sb.append("\n -> ");
        for (Vyrobky v : getVyrobky()) {
            sb.append(v.getNazov());
            sb.append(": ");
            sb.append(v.getCena());
            sb.append("€   ");

        }
        return sb.toString();
    }

	public boolean isVyrobena() {
		return vyrobena;
	}

	public void setVyrobena(boolean vyrobena) {
		this.vyrobena = vyrobena;
	}
 
}
