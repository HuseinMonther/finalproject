/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.ViewManager;
import Model.Appointments;
import Model.Users;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Hassan
 */
public class createFreeApp extends Stage {

    public createFreeApp() {

        Image image = new Image("file:src/Imgs/logo.png");
        ImageView logoImageView = new ImageView(image);

        logoImageView.setFitWidth(140);
        logoImageView.setFitHeight(80);
        Image logo = new Image("file:src/Imgs/user.png");
        ImageView logoImageView2 = new ImageView(logo);

        logoImageView2.setFitWidth(70);
        logoImageView2.setFitHeight(70);

        VBox sidebar = new VBox();
        sidebar.setSpacing(10);

        Button btn1 = new Button("←");

        sidebar.getChildren().addAll(btn1);
        BorderPane contentPane = new BorderPane();
        TextField adate = new TextField();
        adate.setPromptText("Enter Appointment Date");
        TextField aday = new TextField();
        aday.setPromptText("Enter Appointment Day");
        TextField atime = new TextField();
        atime.setPromptText("Enter Appointment Time");

        adate.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;  -fx-background-color: white;");
        aday.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;  -fx-background-color: white;");
        atime.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;  -fx-background-color: white;");

        adate.setMaxWidth(200);
        adate.setMaxHeight(30);
        aday.setMaxWidth(200);
        aday.setMaxHeight(30);
        atime.setMaxWidth(200);
        atime.setMaxHeight(30);

        Button btn2 = new Button("Create");;
        Label l4 = new Label("CREARTE FREE APPOINTMENT");
        HBox h4 = new HBox(logoImageView, l4);
        h4.getStyleClass().add("aaa");
        contentPane.setLeft(sidebar);
        VBox v4 = new VBox(25, logoImageView2, adate, aday, atime, btn2);
        v4.setAlignment(Pos.CENTER);
        v4.setPadding(new Insets(0, 0, 100, 0));
        contentPane.setCenter(v4);
        contentPane.setTop(h4);

        Scene scene = new Scene(contentPane, 850, 700);
        scene.getStylesheets().add("file:src/Css/primary.css");
        sidebar.getStyleClass().add("sid");

        l4.getStyleClass().add("pg");
        btn1.getStyleClass().add("button-style2");
        btn2.getStyleClass().add("button-style");

        this.setScene(scene);
        this.setTitle("Create Free Appointment Page");
        this.show();
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openafreeAppointmentsPage();
                ViewManager.closeCreateFreeAppPage();
            }

        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
// Check if all fields are filled
                if (adate.getText().isEmpty() || aday.getText().isEmpty() || atime.getText().isEmpty()) {
// Display an alert to notify the user to fill all fields

                    showAlert("The data is incomplete 👎");
                } else {
// Store the data in the database
                    String enteredAdate = adate.getText();
                    String enteredAday = aday.getText();
                    String enteredAtime = atime.getText();
                    String status = "free";

                    // Create a new instance of the Users class and store the data
                    Appointments newAppointment = new Appointments(0, enteredAdate, enteredAday, enteredAtime, status);

                    newAppointment.storeAppointment(newAppointment);
                    // Store the new admin in the database
                    // storeUser(newAdmin);

                    // Clear the input fields
                    adate.clear();
                    atime.clear();
                    aday.clear();

                    showAlert2("The Appointment Is Created");
                }
            }
        }
        );

    }

    private void showAlert(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();

    }

    private void showAlert2(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Added");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();

    }
}
