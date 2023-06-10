/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.ViewManager;
import Model.Users;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class adminRegisterPage extends Stage {

    public adminRegisterPage() {
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

        Button btn1 = new Button("Patient");
        Button btn2 = new Button("Free Appontments");
        Button btn3 = new Button("Booked Appontments");
        Button btn5 = new Button("Add Admin");
        Button btn4 = new Button("Logout");

        sidebar.getChildren().addAll(btn1, btn2, btn3, btn5, btn4);
        BorderPane contentPane = new BorderPane();
        TextField username = new TextField();
        username.setPromptText("Enter Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Enter Password");
        TextField fname = new TextField();
        fname.setPromptText("Enter First Name");
        TextField lname = new TextField();
        lname.setPromptText("Enter Last Name");
        TextField age = new TextField();
        age.setPromptText("Enter The Age");
        TextField email = new TextField();
        email.setPromptText("Enter The Email");
        TextField phone = new TextField();
        phone.setPromptText("Enter The Phone Number");
        username.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;-fx-background-color: white;");
        password.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;-fx-background-color: white;");
        fname.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;-fx-background-color: white;");
        lname.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;-fx-background-color: white;");
        age.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;-fx-background-color: white;");
        email.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;-fx-background-color: white;");
        phone.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;-fx-background-color: white;");

        username.setMaxWidth(200);
        username.setMaxHeight(30);
        password.setMaxWidth(200);
        password.setMaxHeight(30);
        fname.setMaxWidth(200);
        fname.setMaxHeight(30);
        lname.setMaxWidth(200);
        lname.setMaxHeight(30);
        age.setMaxWidth(200);
        age.setMaxHeight(30);
        email.setMaxWidth(200);
        email.setMaxHeight(30);
        phone.setMaxWidth(200);
        phone.setMaxHeight(30);
// Create radio buttons
        RadioButton maleRadioButton = new RadioButton("Male");
        RadioButton femaleRadioButton = new RadioButton("Female");

        // Create toggle group
        ToggleGroup genderGroup = new ToggleGroup();

        // Add radio buttons to toggle group
        maleRadioButton.setToggleGroup(genderGroup);
        femaleRadioButton.setToggleGroup(genderGroup);

        HBox genderBox = new HBox(10, maleRadioButton, femaleRadioButton);
        genderBox.setAlignment(Pos.CENTER);
        Button btn11 = new Button("Add");
        Label l4 = new Label("ADMIN REGISTER");
        HBox h4 = new HBox(logoImageView, l4);
        h4.getStyleClass().add("aaa");
        contentPane.setLeft(sidebar);
        VBox v4 = new VBox(25, logoImageView2, username, password, fname, lname, age, email, phone, genderBox, btn11);
        v4.setAlignment(Pos.CENTER);
        v4.setPadding(new Insets(0, 0, 100, 0));
        contentPane.setCenter(v4);
        contentPane.setTop(h4);

        Scene scene = new Scene(contentPane, 850, 700);
        scene.getStylesheets().add("file:src/Css/primary.css");
        sidebar.getStyleClass().add("sid");

        l4.getStyleClass().add("pg");
        btn1.getStyleClass().add("button-style");
        btn5.getStyleClass().add("actv");
        btn2.getStyleClass().add("button-style");
        btn3.getStyleClass().add("button-style");
        btn4.getStyleClass().add("button-style");
        btn5.getStyleClass().add("button-style");
        btn11.getStyleClass().add("button-style");
        maleRadioButton.getStyleClass().add("radio-button");
        femaleRadioButton.getStyleClass().add("radio-button");

        this.setScene(scene);
        this.setTitle("Admin Register Page");
        this.show();

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openAdminDashboardPage();
                ViewManager.closeAdminRegisterPage();
            }

        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openafreeAppointmentsPage();
                ViewManager.closeAdminRegisterPage();
            }

        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openabookedAppointmentsPage();
                ViewManager.closeAdminRegisterPage();
            }

        });
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openAdminLoginPage();
                ViewManager.closeAdminRegisterPage();
            }

        });
        btn11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
// Check if all fields are filled
                if (username.getText().isEmpty() || password.getText().isEmpty() || fname.getText().isEmpty() || lname.getText().isEmpty()
                        || age.getText().isEmpty() || email.getText().isEmpty() || phone.getText().isEmpty() || genderGroup.getSelectedToggle() == null) {
// Display an alert to notify the user to fill all fields

                    showAlert("The data is incomplete 👎");
                } else {
// Store the data in the database
                    String enteredUsername = username.getText();
                    String enteredPassword = password.getText();
                    String enteredFirstName = fname.getText();
                    String enteredLastName = lname.getText();
                    int enteredAge = Integer.parseInt(age.getText());
                    String enteredEmail = email.getText();
                    String enteredPhone = phone.getText();
                    String selectedGender = maleRadioButton.isSelected() ? "Male" : "Female";
                    String role = "admin";

                    // Create a new instance of the Users class and store the data
                    Users newAdmin = new Users(0, enteredUsername, enteredPassword, enteredFirstName, enteredLastName, enteredAge, enteredEmail, enteredPhone, selectedGender, role);

                    newAdmin.storeUser(newAdmin);
                    // Store the new admin in the database
                    // storeUser(newAdmin);

                    // Clear the input fields
                    username.clear();
                    password.clear();
                    fname.clear();
                    lname.clear();
                    age.clear();
                    email.clear();
                    phone.clear();
                    genderGroup.selectToggle(null);
                    showAlert2("The Admin Is Created ");
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
//Label l = new Label("THIS IS ADMIN REGISTER PAGE");
//        Button btn = new Button("Back");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//public void handle(ActionEvent event) {
//                ViewManager.openAdminDashboardPage();
//                ViewManager.closeAdminRegisterPage();
//            }
//
//        });
//
//        VBox v1 = new VBox(l, btn);
//        Scene scene = new Scene(v1, 500, 500);
//        this.setScene(scene);
//        this.setTitle("Admin Register Page");
//        this.show();
