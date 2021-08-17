package app.controller;

import java.util.stream.Collectors;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import app.vyrobky_model.*;
import app.view.UpravZakazkuView;
import app.zakazky_model.Zakazka;


public class UpravZakazkuController {
	
	UpravZakazkuView view;
	Zakazka upravena;
	
	/**
	 * konstruktor ktory priraduje kazdemu tlacidlu jeho funkciu na pridanie daneho vyrobku do zakazky
	 * @param v
	 * @param upravena
	 */
	public UpravZakazkuController(UpravZakazkuView v, Zakazka upravena) {
		view = v;
		this.upravena = upravena;
		
		view.pridajManzPostel.setOnAction(e -> {
			upravena.getVyrobky().add(new ManzelskaPostel(null, 0, null, 0));
			refreshVyrobky();
		});
		
		view.pridajJednoPostel.setOnAction(e -> {
			upravena.getVyrobky().add(new JednoPostel(null, 0, null, 0));
			refreshVyrobky();
		});
		
		view.pridajBarStolicku.setOnAction(e -> {
			upravena.getVyrobky().add(new BarovaStolicka(null, 0, null));
			refreshVyrobky();
		});	
				
		view.pridajJedStolicku.setOnAction(e -> {
			upravena.getVyrobky().add(new JedalenskaStolicka(null, 0, null));
			refreshVyrobky();
		});
		
		view.pridajKonStol.setOnAction(e -> {
			upravena.getVyrobky().add(new KonferecnyStol(null, 0, null));
			refreshVyrobky();
		});
		
		view.pridajKuchStol.setOnAction(e -> {
			upravena.getVyrobky().add(new KuchynskyStol(null, 0, null));
			refreshVyrobky();
		});
		
		view.pridajPracStol.setOnAction(e -> {
			upravena.getVyrobky().add(new PracovnyStol(null, 0, null));
			refreshVyrobky();
		});
		
		view.pridajPolicu.setOnAction(e -> {
			upravena.getVyrobky().add(new Polica(null, 0, null, 0));
			refreshVyrobky();
		});
		
		view.pridajRegal.setOnAction(e -> {
			upravena.getVyrobky().add(new Regal(null, 0, null, 0));
			refreshVyrobky();
		});
		
		view.pridajKniznicu.setOnAction(e -> {
			upravena.getVyrobky().add(new Kniznica(null, 0, null, 0));
			refreshVyrobky();
		});
		
		refreshVyrobky();
	}
	
	/**
	 * refresh je potrebny aby sa aktualizovalo okno s novou zakazkou
	 */
	public void refreshVyrobky(){
		
        view.vyrobkyBox.getChildren().setAll(
                upravena.getVyrobky().stream().map(vyrobok -> {
                    HBox vyrobokBox = new HBox();

                    // text vyrobku
                    vyrobokBox.getChildren().add(new Text(vyrobok.getNazov()));

                    // delete
                    Button del = new Button("X");
                    vyrobokBox.getChildren().add(del);
                    del.setOnAction(e -> {
                        upravena.getVyrobky().remove(vyrobok);
                        refreshVyrobky();
                    });

                    return vyrobokBox;
                }).collect(Collectors.toList())
        );

        // polymorfizmus
        double sum = 0;
        for (Vyrobky v : upravena.getVyrobky()) {
            sum += v.getCena();
        }

        view.cena.setText("Cena : " + Double.toString(sum) + " + €");	
	}

}
