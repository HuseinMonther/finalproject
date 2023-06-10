/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.ViewManager;
import Model.Appointments;
import Model.Users;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
public class afreeAppointments extends Stage {

    private TableView<Appointments> tableView;

    public afreeAppointments() {

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
        Button btn99 = new Button("+Create");
        Button btn27 = new Button("Delete");
        Button btn26 = new Button("Update");
        HBox hbtns = new HBox(10, btn99, btn26, btn27);
        hbtns.setAlignment(Pos.CENTER);
        Label l4 = new Label("FREE APPOINTMENTS");
        HBox h4 = new HBox(logoImageView, l4);
        h4.getStyleClass().add("aaa");
        contentPane.setLeft(sidebar);
        VBox v4 = new VBox(10, tableView, btn66, hbtns);
        v4.setAlignment(Pos.CENTER);
        contentPane.setCenter(v4);

        contentPane.setTop(h4);

        Scene scene = new Scene(contentPane, 850, 700);
        scene.getStylesheets().add("file:src/Css/primary.css");
        sidebar.getStyleClass().add("sid");

        l4.getStyleClass().add("pg");
        btn1.getStyleClass().add("button-style");
        btn2.getStyleClass().add("actv");
        btn2.getStyleClass().add("button-style");
        btn3.getStyleClass().add("button-style");
        btn4.getStyleClass().add("button-style");
        btn5.getStyleClass().add("button-style");
        btn99.getStyleClass().add("button-style");
        btn66.getStyleClass().add("button-style");
        btn26.getStyleClass().add("button-style");
        btn27.getStyleClass().add("button-style");
        this.setScene(scene);
        this.setTitle("Free Appointments Page");
        this.show();
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openAdminDashboardPage();
                ViewManager.closeafreeAppointmentsPage();
            }

        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openabookedAppointmentsPage();
                ViewManager.closeafreeAppointmentsPage();
            }

        });
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openAdminLoginPage();
                ViewManager.closeafreeAppointmentsPage();
            }

        });
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openAdminRegisterPage();
                ViewManager.closeafreeAppointmentsPage();
            }

        });
        btn99.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openCreateFreeAppPage();
                ViewManager.closeafreeAppointmentsPage();
            }

        });
        btn66.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // جلب جميع المستخدمين من قاعدة البيانات وعرضهم في الـ TableView
                ObservableList<Appointments> appList = Appointments.getAllFreeAppointments();
                tableView.setItems(appList);
            }
        });
        btn27.setOnAction(e -> {
            // الحصول على العنصر المحدد من الجدول
            Appointments selectedApp = tableView.getSelectionModel().getSelectedItem();
            if (selectedApp != null) {
                // عرض نافذة تأكيد الحذف
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete this appointment?");

                // تعيين أزرار التأكيد والإلغاء
                ButtonType confirmButton = new ButtonType("Delete");
                ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(confirmButton, cancelButton);

                // مراقبة حدث النقر على الأزرار
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == confirmButton) {
                    // قم بحذف المريض من قاعدة البيانات
                    selectedApp.deleteFromDatabase();
                    showAlert2("The Appointment Is Deleted ");
                    // قم بحذف العنصر من الجدول
                    tableView.getItems().remove(selectedApp);
                }
            } else {
                showAlert3("No Row Is Selected!");
            }
        });
        btn26.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Appointments selectedApp = tableView.getSelectionModel().getSelectedItem();
                if (selectedApp != null) {
                    try {
                        openNewWindow();
                    } catch (SQLException ex) {
                        Logger.getLogger(adminDashboardPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ViewManager.closeafreeAppointmentsPage();
                } else {
                    showAlert3("No Row Is Selected!");
                }
            }

        });

    }

    private void showAlert2(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("DELETED");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();

    }

    private void showAlert3(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();

    }

    private void openNewWindow() throws SQLException {
        Stage secondaryStage = new Stage();

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
        Button btn26 = new Button("Update");
        Label l4 = new Label("UPDATE APPOINTMENT");
        HBox h4 = new HBox(logoImageView, l4);
        h4.getStyleClass().add("aaa");
        contentPane.setLeft(sidebar);
        VBox v4 = new VBox(25, logoImageView2, adate, aday, atime, btn26);
        v4.setAlignment(Pos.CENTER);
        v4.setPadding(new Insets(0, 0, 100, 0));
        contentPane.setCenter(v4);
        contentPane.setTop(h4);
        l4.getStyleClass().add("pg");
        btn1.getStyleClass().add("button-style2");
        btn26.getStyleClass().add("button-style");

        btn26.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Appointments selectedApp = tableView.getSelectionModel().getSelectedItem();
                if (selectedApp != null) {
                    if (adate.getText().isEmpty() || aday.getText().isEmpty() || atime.getText().isEmpty()) {
// Display an alert to notify the user to fill all fields

                        showAlert("The data is incomplete 👎");
                    } else {
                        selectedApp.setAppointment_date(adate.getText());
                        selectedApp.setAppointment_day(aday.getText());
                        selectedApp.setAppointment_time(atime.getText());

                        try {
                            selectedApp.update(selectedApp);

                        } catch (SQLException ex) {
                            Logger.getLogger(adminDashboardPage.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(adminDashboardPage.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        showAlert("Appointment data updated successfully!");
                        adate.clear();
                        aday.clear();
                        atime.clear();

                        tableView.refresh();
                        ViewManager.openafreeAppointmentsPage();
                        secondaryStage.close();
                    }
                } else {

                    showAlert("No patient selected!");

                }

            }
        });

        this.setTitle("Create Patient Page");
        this.show();
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openafreeAppointmentsPage();
                secondaryStage.close();
            }

        });

        Scene scene = new Scene(contentPane, 850, 700);
        scene.getStylesheets().add("file:src/Css/primary.css");
        sidebar.getStyleClass().add("sid");
        secondaryStage.setTitle("Update");
        secondaryStage.setScene(scene);
        secondaryStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
