/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.ViewManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class pfinishedAppointments extends Stage {

    public pfinishedAppointments() {

        Image image = new Image("file:src/Imgs/logo.png");
        ImageView logoImageView = new ImageView(image);

        logoImageView.setFitWidth(140);
        logoImageView.setFitHeight(80);
        VBox sidebar = new VBox();
        sidebar.setSpacing(10);

        Button btn1 = new Button("Free Appointments");
        Button btn2 = new Button("Finished Appointments");
        Button btn3 = new Button("Waited Appointments");
        Button btn4 = new Button("Logout");
        sidebar.getChildren().addAll(btn1, btn2, btn3, btn4);
        BorderPane contentPane = new BorderPane();
        Label l1 = new Label("المحتوى");

        Label l4 = new Label("MY BOOKED FINISHED APPOINTMENTS");
        HBox h4 = new HBox(logoImageView, l4);
        h4.getStyleClass().add("aaa");
        contentPane.setLeft(sidebar);
        VBox v4 = new VBox(l1);
        contentPane.setCenter(v4);
        contentPane.setTop(h4);

        Scene scene = new Scene(contentPane, 850, 700);
        scene.getStylesheets().add("file:src/Css/primary.css");
        sidebar.getStyleClass().add("sid");

        l4.getStyleClass().add("pg");
        btn1.getStyleClass().add("button-style");
        btn2.getStyleClass().add("button-style");
        btn2.getStyleClass().add("actv");
        btn3.getStyleClass().add("button-style");
        btn4.getStyleClass().add("button-style");

        this.setScene(scene);
        this.setTitle("Booked Finished Appointments Page");
        this.show();
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openPatientDashboardPage();
                ViewManager.closepfinishedAppointmentsPage();
            }

        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openpwaitedAppointmentsPage();
                ViewManager.closepfinishedAppointmentsPage();
            }

        });
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openPatientLoginPage();
                ViewManager.closepfinishedAppointmentsPage();
            }

        });
    }
}
