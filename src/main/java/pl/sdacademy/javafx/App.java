package pl.sdacademy.javafx;

// FX1 tworzenie klasy App rozszerzającej Application

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    // FX2 sprawdzenie metody
    @Override
    public void start(Stage stage) {
        MainUI firstMainVBox = new MainUI(stage);
        Scene scene = new Scene(firstMainVBox, 400, 600);
        stage.setScene(scene);
        stage.show();
    }
}
