package com.view;

import com.model.MoneyTree;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        stage.setTitle("Exchange Money!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        MoneyTree tree = new MoneyTree();
        com.model.MoneyInfo bazaDanych = new com.model.MoneyInfo();
        for (int i = 1; i < 14; i++) {
            bazaDanych.setValue(i);
            tree.addtoMap(bazaDanych.getCurrency());
        }
        launch();

    }
}