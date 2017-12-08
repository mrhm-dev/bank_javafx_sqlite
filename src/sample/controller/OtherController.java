package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class OtherController {


    public void backtoHome(ActionEvent actionEvent) throws IOException {

        Parent homePageParent = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        Scene homePageScene = new Scene(homePageParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(homePageScene);
        window.show();

    }
}
