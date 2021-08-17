package app.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ProcesVyrobyView {

	private Scene sc;
	private VBox box;
	private Text nazov;
	
	public Button upravZakazku = new Button("Uprav zakazku");

	public ProcesVyrobyView(){
		ScrollPane pane = new ScrollPane();
		box = new VBox();
		pane.setContent(box);
		box.setTranslateX(300);
		
		nazov = new Text();
		box.getChildren().add(nazov);
		
		box.getChildren().add(upravZakazku);
		
		sc = new Scene(pane);
		
	}
	
	public Scene getScene() {
		return sc;
	}

}
