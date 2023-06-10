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
import javafx.scene.control.TextField;
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
public class adminLoginPage extends Stage {

    public adminLoginPage() {
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

        Button btn = new Button("Login");
        Button btn2 = new Button("Register");
        Button btn3 = new Button("Admin");
        Button btn4 = new Button("Exit");

        sidebar.getChildren().addAll(btn, btn2, btn3, btn4);
        BorderPane contentPane = new BorderPane();
        TextField username = new TextField();
        username.setPromptText("Enter Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Enter Password");
        username.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;-fx-background-color: white;");
        password.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;-fx-background-color: white;");
        username.setMaxWidth(200);
        username.setMaxHeight(30);
        password.setMaxWidth(200);
        password.setMaxHeight(30);
        Button btn1 = new Button("Login");
        Label l4 = new Label("ADMIN LOGIN");
        HBox h4 = new HBox(logoImageView, l4);
        h4.getStyleClass().add("aaa");
        contentPane.setLeft(sidebar);
        VBox v4 = new VBox(32, logoImageView2, username, password, btn1);
        v4.setAlignment(Pos.CENTER);
        v4.setPadding(new Insets(0, 0, 200, 0));
        contentPane.setCenter(v4);
        contentPane.setTop(h4);

        Scene scene = new Scene(contentPane, 850, 700);
        scene.getStylesheets().add("file:src/Css/primary.css");
        sidebar.getStyleClass().add("sid");

        l4.getStyleClass().add("pg");
        btn1.getStyleClass().add("button-style");
        btn.getStyleClass().add("button-style");
        btn2.getStyleClass().add("button-style");
        btn3.getStyleClass().add("button-style");
        btn4.getStyleClass().add("button-style");
        btn3.getStyleClass().add("actv");

        this.setScene(scene);
        this.setTitle("Admin Login Page");
        this.show();

        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }

        });
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String usernamef = username.getText();
                String passwordf = password.getText();

                Users user = Users.getAdminByUsernameAndPassword(usernamef, passwordf);

                if (user != null && user.getUsername().equals(usernamef) && user.getPassword().equals(passwordf)) {

                    ViewManager.openAdminDashboardPage();
                    ViewManager.closeAdminLoginPage();
                    username.clear();
                    password.clear();

                } else if (user == null) {
                    showAlert("The data is incomplete or incorrect 👎");
                    username.clear();
                    password.clear();
                }

            }

        });
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openPatientLoginPage();
                ViewManager.closeAdminLoginPage();
            }

        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openPatientRegisterPage();
                ViewManager.closeAdminLoginPage();
            }

        });

    }

    private void showAlert(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();

    }
}
//Label l = new Label("THIS IS ADMIN LOGIN PAGE");
//        Button btn1 = new Button("Save");
//        Button btn2 = new Button("Back");
//        btn1.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                ViewManager.openAdminDashboardPage();
//                ViewManager.closeAdminLoginPage();
//            }
//
//        });
//
//        btn2.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                ViewManager.openPatientLoginPage();
//                ViewManager.closeAdminLoginPage();
//            }
//
//        });
//        VBox v1 = new VBox(l, btn1, btn2);
//        Scene scene = new Scene(v1, 500, 500);
//        this.setScene(scene);
//        this.setTitle("Admin Login Page");
//        this.show();
