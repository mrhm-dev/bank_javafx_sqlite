package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {


    public void gotoNext(ActionEvent actionEvent) throws IOException {

        Parent otherPageParent = FXMLLoader.load(getClass().getResource("/fxml/other.fxml"));
        Scene otherPageScene = new Scene(otherPageParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(otherPageScene);
        window.show();
    }
}

