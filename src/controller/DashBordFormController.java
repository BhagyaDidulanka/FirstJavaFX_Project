package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBordFormController {
    public AnchorPane root;

    public void btnTestFormOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent= FXMLLoader.load(this.getClass().getResource("../view/TestForm.fxml"));

        Scene sence = new Scene(parent);

        Stage stage=(Stage) root.getScene().getWindow();

        stage.setScene(sence);
        stage.setTitle("Test form");
        stage.centerOnScreen();

    }

    public void btnTableFormOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent=FXMLLoader.load(this.getClass().getResource("../view/TableForm.fxml"));

        Scene sence=new Scene(parent);

        Stage stage=(Stage) root.getScene().getWindow();

        stage.setScene(sence);
        stage.setTitle("Table Form");
        stage.centerOnScreen();
    }
}
