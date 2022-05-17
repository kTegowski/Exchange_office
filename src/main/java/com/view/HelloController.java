package com.view;

import com.model.ChangeTo;
import com.model.MoneyTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private HBox Hbox1;

    @FXML
    private HBox Hbox2;

    @FXML
    private GridPane PANE1;

    @FXML
    private ComboBox<String> fromValue;

    @FXML
    private Button ButtonAcct;


    @FXML
    private ComboBox<String> toValue;

    @FXML
    private TextField input;

    @FXML
    private Label Label1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        toValue.getItems().add("PLN");
        fromValue.getItems().add("PLN");
        for(String napis: MoneyTree.keyset){
            toValue.getItems().add(napis);
            fromValue.getItems().add(napis);
        }
    }
    public void ButtonAcctPress(ActionEvent event) {
        if (!input.getText().equals("")) {

            Double value = Double.parseDouble(input.getText());
            String firstCurrency = String.valueOf(fromValue.getValue());
            String secondCurrency = String.valueOf(toValue.getValue());


            if (firstCurrency.equals("PLN") && !secondCurrency.equals("PLN")) {
                Double moneyValue = ChangeTo.fromPLN(value, MoneyTree.getValue(secondCurrency));
                Label1.setText(String.format("%.2f", moneyValue));
            }


            if (!firstCurrency.equals("PLN") && secondCurrency.equals("PLN")) {
                Double moneyValue = ChangeTo.toPLN(value, MoneyTree.getValue(firstCurrency));
                Label1.setText(String.format("%.2f", moneyValue));
            }


            if (firstCurrency.equals("PLN") && secondCurrency.equals("PLN")) {
                Double moneyValue = value;
                Label1.setText(String.format("%.2f", moneyValue));
            }


            if (!firstCurrency.equals("PLN") && !secondCurrency.equals("PLN")) {
                Double moneyValue = ChangeTo.fromPLN(ChangeTo.toPLN(value, MoneyTree.getValue(firstCurrency)), MoneyTree.getValue(secondCurrency));
                Label1.setText(String.format("%.2f", moneyValue));
            }
        }
    }
    }









