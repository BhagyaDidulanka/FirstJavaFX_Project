package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class TestFormController {
    public TextField txtSomthing;
    public Button btnOk;
    public Label lblText;
    public Button btnHide;
    public Button btnShow;
    public AnchorPane root;

    public void initialize(){
        btnOk.setDisable(true);
        txtSomthing.setDisable(true);
        btnHide.setVisible(false);
        btnShow.setVisible(false);
    }
    public void btnSubmitOnAction(ActionEvent actionEvent) {
        System.out.println("Submit button..");
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Sucsessfull");
        alert.showAndWait();
        btnOk.setDisable(false);
        txtSomthing.setDisable(false);
        txtSomthing.requestFocus();

    }

    public void btnOkOnAction(ActionEvent actionEvent) {
        textSomthingEnter();
    }

    public void txtSomthingOnAction(ActionEvent actionEvent) {
        textSomthingEnter();
    }

    public void textSomthingEnter(){
        String text=txtSomthing.getText();
        lblText.setText(text);
        txtSomthing.clear();
        txtSomthing.requestFocus();
        btnHide.setVisible(true);
    }

    public void btnHideOnAction(ActionEvent actionEvent) {
        btnShow.setVisible(true);
        btnHide.setVisible(false);
        lblText.setVisible(false);
    }

    public void btnShowOnAction(ActionEvent actionEvent) {
        lblText.setVisible(true);
        btnHide.setVisible(true);
        btnShow.setVisible(false);
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {

        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Do you want Log out...", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();

        boolean equals=buttonType.get().equals(ButtonType.YES);

        if(equals){
            Parent parent= FXMLLoader.load(this.getClass().getResource("../view/DashBordForm.fxml"));

            Scene sence=new Scene(parent);

            Stage stage=(Stage) root.getScene().getWindow();

            stage.setScene(sence);
            stage.setTitle("Dash Bord");
            stage.centerOnScreen();
        }

    }
}
