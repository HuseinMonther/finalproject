/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.ViewManager;
import Model.Appointments;
import Model.Users;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class abookedAppointments extends Stage {

    private TableView<Appointments> tableView;

    public abookedAppointments() {

        Image image = new Image("file:src/Imgs/logo.png");
        ImageView logoImageView = new ImageView(image);

        logoImageView.setFitWidth(140);
        logoImageView.setFitHeight(80);
        VBox sidebar = new VBox();
        sidebar.setSpacing(10);

        Button btn1 = new Button("Patient");
        Button btn2 = new Button("Free Appontments");
        Button btn3 = new Button("Booked Appontments");
        Button btn5 = new Button("Add Admin");
        Button btn4 = new Button("Logout");

        sidebar.getChildren().addAll(btn1, btn2, btn3, btn5, btn4);
        BorderPane contentPane = new BorderPane();
        // إنشاء الأعمدة
        TableColumn<Appointments, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setPrefWidth(132);

        TableColumn<Appointments, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("appointment_date"));
        dateColumn.setPrefWidth(132);

        TableColumn<Appointments, String> dayColumn = new TableColumn<>("Day");
        dayColumn.setCellValueFactory(new PropertyValueFactory<>("appointment_day"));
        dayColumn.setPrefWidth(132);

        TableColumn<Appointments, String> timeColumn = new TableColumn<>("Time");
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("appointment_time"));
        timeColumn.setPrefWidth(132);

        TableColumn<Appointments, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusColumn.setPrefWidth(132);

        // ... إنشاء باقي الأعمدة الأخرى التي ترغب في عرضها ...
        // إنشاء TableView
        tableView = new TableView<>();
        tableView.getColumns().addAll(idColumn, dateColumn, dayColumn, timeColumn, statusColumn);
        Button btn66 = new Button("Show");
        TextField entered = new TextField();
        entered.setPromptText("Search By Patient First Name");
        Button btnsrc = new Button("Search");
        HBox serch = new HBox(entered, btnsrc);
        serch.setAlignment(Pos.CENTER);
        Button btn99 = new Button("+Add Comment");
        Label l4 = new Label("BOOKED APPOINTMENTS");
        HBox h4 = new HBox(logoImageView, l4);
        h4.getStyleClass().add("aaa");
        contentPane.setLeft(sidebar);
        VBox v4 = new VBox(10, tableView, btn66, btn99, serch);
        contentPane.setCenter(v4);
        contentPane.setTop(h4);
        v4.setAlignment(Pos.CENTER);
        Scene scene = new Scene(contentPane, 850, 700);
        scene.getStylesheets().add("file:src/Css/primary.css");
        sidebar.getStyleClass().add("sid");

        l4.getStyleClass().add("pg");
        btn1.getStyleClass().add("button-style");
        btn3.getStyleClass().add("actv");
        btn2.getStyleClass().add("button-style");
        btn3.getStyleClass().add("button-style");
        btn4.getStyleClass().add("button-style");
        btn5.getStyleClass().add("button-style");
        btn99.getStyleClass().add("button-style");
        btn66.getStyleClass().add("button-style");
        btnsrc.getStyleClass().add("button-style3");
        entered.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;-fx-background-color: white;-fx-min-width: 170px;");

        entered.setMaxWidth(200);
        entered.setMaxHeight(30);
        this.setScene(scene);
        this.setTitle("Booked Appointments Page");
        this.show();
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openAdminDashboardPage();
                ViewManager.closeabookedAppointmentsPage();
            }

        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openafreeAppointmentsPage();
                ViewManager.closeabookedAppointmentsPage();
            }

        });
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openAdminLoginPage();
                ViewManager.closeabookedAppointmentsPage();
            }

        });
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openAdminRegisterPage();
                ViewManager.closeabookedAppointmentsPage();
            }

        });
        btn66.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // جلب جميع المستخدمين من قاعدة البيانات وعرضهم في الـ TableView
                ObservableList<Appointments> appList = Appointments.getAllBookedAppointments();
                tableView.setItems(appList);
            }
        });
    }
}
