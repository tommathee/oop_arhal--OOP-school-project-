package app.controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import app.view.*;
import app.zakazky_model.Objednavky;
import app.zakazky_model.Zakazka;
import app.zamestnanci_model.*;


public class SystemController {

	SystemView view;
	private ArrayList<Zamestnanci> zamestnanci = new ArrayList<>();

	/**
	 * nastavenie okna a akcii s nimi spojenymi
	 * @param view
	 */
	public SystemController(SystemView view) {
		this.view = view;
		
		initialize();
		
        view.refresh.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                refreshZakazky();
            }
        });
        
        view.novaZakazkaButt.setOnAction((actionEvent) -> {
            Zakazka demo = new Zakazka();
            Objednavky.getInstance().zakazka.add(demo);
            refreshZakazky();
        });
	}
	
	/**
	 * pridanie zamestnancov do arraylistu
	 */
	private void initialize() {		
		zamestnanci.add(new Pomocnik());
		zamestnanci.add(new Zvarac());
		zamestnanci.add(new Lakovnik());
		zamestnanci.add(new Monter());
		zamestnanci.add(new Stolar());
	}

	/**
	 * nastavenia tlacidiel v okne a vypisov
	 */
	public void refreshZakazky() {
		ArrayList<Zakazka> zakazka = Objednavky.getInstance().zakazka;
		ArrayList<Node> nodes = new ArrayList<>();
		
		for (Zakazka z : zakazka){
			// text
			Text t = new Text(z.getVypis());
			nodes.add(t);
			
			// delete button 
			Button del = new Button("X");
			nodes.add(del);
			del.setOnAction(e -> {
				Objednavky.getInstance().zakazka.remove(z);
				refreshZakazky();
			});		
			
			// edit button
			Button edit = new Button("Uprav");
			nodes.add(edit);
			edit.setOnAction(e -> {
			
				// nove okno
				Stage stage = new Stage();
				UpravZakazkuView view =  new UpravZakazkuView();
				UpravZakazkuController ctr = new UpravZakazkuController(view, z);
				stage.setScene(view.getScene());
				stage.show();
				stage.setWidth(500);
				stage.setHeight(500);
				
			});
			
			// vyroba button
			Button make = new Button("Posli na vyrobu");
			nodes.add(make);
			make.setOnAction(e -> {
				
				//nove okno
				Stage stage = new Stage();
				ProcesVyrobyView view =  new ProcesVyrobyView();
				ProcesVyrobyController vyroba = new ProcesVyrobyController(z, zamestnanci);
				stage.setScene(view.getScene());
				stage.show();
				stage.setWidth(700);
				stage.setHeight(300);
						
				try {				
					vyroba.pripravVyrobu();
					System.out.println("Vyrobena");	
					
				} catch (Exception e1) {

					System.out.println("Prazdna zakazka, nemozem poslat do vyroby !!!");
					e1.printStackTrace();
				}
				if (z.isVyrobena()) {					
					z.getVyrobky().clear();
					Objednavky.getInstance().zakazka.remove(z);
				}
		
			});

		}
		
		view.boxZakazky.getChildren().setAll(nodes);
	}
}
