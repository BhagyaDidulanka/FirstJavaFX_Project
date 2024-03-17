package controller;

import Table.CustomerTM;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TableFormController {

    public TableView<CustomerTM> tblCustomer;
    public TextField txtID;
    public TextField txtName;
    public TextField txtContact;
    public TextField txtAddress;
    public AnchorPane root;

    public void initialize(){
        loadTable();

        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contact"));


        tblCustomer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerTM>() {
            @Override
            public void changed(ObservableValue<? extends CustomerTM> observable, CustomerTM oldValue, CustomerTM newValue) {

                CustomerTM obj = tblCustomer.getSelectionModel().getSelectedItem();

//                System.out.println(obj.getId());
//                System.out.println(obj.getName());
//                System.out.println(obj.getAddress());
//                System.out.println(obj.getContact());

                  txtID.setText(obj.getId());
                  txtName.setText(obj.getName());
                  txtContact.setText(obj.getContact());
                  txtAddress.setText(obj.getAddress());

            }
        });

    }

    public void loadTable(){
        ObservableList<CustomerTM> customerList = tblCustomer.getItems();

     /*   CustomerTM customer1=new CustomerTM("001","Bhagya","city1","0717157329");
        CustomerTM customer1=new CustomerTM("001","Bhagya","city1","0717157329");
        CustomerTM customer1=new CustomerTM("001","Bhagya","city1","0717157329");
        CustomerTM customer1=new CustomerTM("001","Bhagya","city1","0717157329"); */

        //customerList.add(customer1);
        customerList.add(new CustomerTM("001","Bhagya","city1","0717157329"));
        customerList.add(new CustomerTM("002","Sew","city2","0727157422"));
        customerList.add(new CustomerTM("003","Didu","city3","0787157679"));
        customerList.add(new CustomerTM("004","Piyu","city4","0715654567"));

        tblCustomer.refresh();
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {

        Parent parent= FXMLLoader.load(this.getClass().getResource("../view/DashBordForm.fxml"));

        Scene sence=new Scene(parent);

        Stage stage=(Stage) root.getScene().getWindow();

        stage.setScene(sence);
        stage.setTitle("Dash Bord");
        stage.centerOnScreen();
    }
    }

