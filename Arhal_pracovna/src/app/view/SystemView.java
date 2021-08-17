 package app.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SystemView {
	
    public ScrollPane pane;
    public VBox box;
    public Button novaZakazkaButt;
    public Scene scene;
    public VBox boxZakazky;
    public Button refresh;

    public SystemView() {
        pane = new ScrollPane();
        box = new VBox();
        box.setSpacing(10);
        box.setTranslateX(10);
        pane.setContent(box);

        refresh = new Button("Refresh");
        box.getChildren().add(refresh);

        box.getChildren().add(new Text("Vitaj v Arhale!"));
        box.getChildren().add(new Text("Nova zakazka: "));

        novaZakazkaButt = new Button("Vytvor zakazku");
        box.getChildren().add(novaZakazkaButt);

        box.getChildren().add(new Text("Zakazky: "));
        boxZakazky = new VBox();
        box.getChildren().add(boxZakazky);

        // scena
        scene = new Scene(pane);
    }

    public Scene getScene() {
        return scene;
    }

}
