package com.lmkhant;

import com.lmkhant.controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    public MainApp() {
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("Rent Receipt PDF Exporter");
        stage.setScene(new Scene((new MainController()).getParent()));
        stage.setScene(new Scene((new MainController()).getParent()));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
