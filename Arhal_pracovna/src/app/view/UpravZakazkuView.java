package app.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class UpravZakazkuView {
	
	private Scene sc;
	private VBox box;
	private Text nazov;
	public VBox vyrobkyBox;
	public Text cena;
	
	public Button pridajPostel = new Button("Pridaj postel");
	public Button pridajKonStol = new Button("Pridaj konferecny stol");
	public Button pridajKuchStol = new Button("Pridaj kuchynsky stol");
	public Button pridajPracStol = new Button("Pridaj pracovny stol");
	public Button pridajJedStolicku = new Button("Pridaj jedalensku stolicku");
	public Button pridajBarStolicku = new Button("Pridaj barovu stolicku");
	public Button pridajKniznicu = new Button("Pridaj kniznicu");
	public Button pridajRegal = new Button("Pridaj regal");
	public Button pridajPolicu = new Button("Pridaj policu");
	
	public UpravZakazkuView() {
		ScrollPane pane = new ScrollPane();
		box = new VBox();
		pane.setContent(box);
		
		nazov = new Text("");
		box.getChildren().add(nazov);
		
		box.getChildren().add(pridajPostel);
		box.getChildren().add(pridajKonStol);
		box.getChildren().add(pridajKuchStol);
		box.getChildren().add(pridajPracStol);
		box.getChildren().add(pridajJedStolicku);
		box.getChildren().add(pridajBarStolicku);
		box.getChildren().add(pridajRegal);
		box.getChildren().add(pridajPolicu);
		box.getChildren().add(pridajKniznicu);
		
		box.getChildren().add(new Text("Vyrobky: "));
		vyrobkyBox = new VBox();
		box.getChildren().add(vyrobkyBox);
		
		//box.getChildren().add(new Text("Upravit zakazku:"));
		
		cena = new Text("Cena: 0.00 €");
		box.getChildren().add(cena);
		
		sc = new Scene(pane);
	}
	
	public Scene getScene() {
		return sc;
	}
	
    public void setNazov(String titulok) {
        nazov.setText("Editovat nakup - " + nazov);
    }

}
