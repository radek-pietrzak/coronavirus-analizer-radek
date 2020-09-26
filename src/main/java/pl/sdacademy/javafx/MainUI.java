package pl.sdacademy.javafx;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainUI extends VBox {
    Button buttonShowGraph;
    Button buttonRefreshData;
    Label labelMainMenu;
    Label labelLastUpdate;

//    FX2 stworzenie konstruktora, który wyświetli elementy z zadania
    public MainUI(Stage stage) {
        super();
        buttonShowGraph = new Button("Wyświetl wykres");
        buttonRefreshData = new Button("Aktualizuj dane");
        labelMainMenu = new Label("Menu główne");
        labelLastUpdate = new Label("Dane zaktualizowano XX.XX.XXXX");
        this.getChildren().add(buttonShowGraph);
        this.getChildren().add(buttonRefreshData);
        this.getChildren().add(labelMainMenu);
        this.getChildren().add(labelLastUpdate);
//        buttonShowGraph.setOnAction(event -> showGraph(stage));
        this.setAlignment(Pos.CENTER);
    }


}
