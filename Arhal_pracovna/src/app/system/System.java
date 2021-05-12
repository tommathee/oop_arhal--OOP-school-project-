package app.system;

import app.controller.SystemController;
import app.view.SystemView;
import javafx.application.Application;
import javafx.stage.Stage;

public class System extends Application {
	
	public SystemView sysView;
	public SystemController sysController;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		sysView = new SystemView();
		sysController = new SystemController(sysView);
		
		primaryStage.setWidth(900);
		primaryStage.setHeight(500);
		
		primaryStage.setTitle("Arhal");
		primaryStage.setScene(sysView.getScene());
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
		/*
		BarovaStolicka p1 = new BarovaStolicka("Barova stolicka", 70, "Stolicka");
		Vyrobky p2 = new Postele("Manzelska");
		
		ArrayList<Vyrobky> vyrobkyArray = new ArrayList<>();
		vyrobkyArray.add(p1);
		vyrobkyArray.add(p2);
		
		for(Vyrobky v : vyrobkyArray) {
			v.vypisTyp();
		}
		
	    Zakazka z = new Zakazka();
	    z.getVyrobky().add(new Postele("Manzelska"));
	    z.getVyrobky().add(new KonferecnyStol("Dubovy", 100, "Nizky"));
	    Objednavky.getInstance().zakazka.add(z);
	    Objednavky.getInstance().vypisZakazky();
*/
	}
}
