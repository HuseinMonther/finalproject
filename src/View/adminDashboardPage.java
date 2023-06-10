/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.ViewManager;
import Model.DB;
import Model.Users;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Hassan
 */
public class adminDashboardPage extends Stage {

    private void searchUsers(String username) {
        ObservableList<Users> userList = Users.getUsersByUsername(username);
        tableView.setItems(userList);
    }
    private TableView<Users> tableView;

    public adminDashboardPage() {

        Image image = new Image("file:src/Imgs/logo.png");
        ImageView logoImageView = new ImageView(image);

        logoImageView.setFitWidth(160);
        logoImageView.setFitHeight(90);
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
        TableColumn<Users, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Users, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<Users, String> passwordColumn = new TableColumn<>("Password");
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

        TableColumn<Users, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstname"));

        TableColumn<Users, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        TableColumn<Users, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Users, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Users, Integer> phoneColumn = new TableColumn<>("Phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<Users, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

        TableColumn<Users, String> roleColumn = new TableColumn<>("Role");
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

        // ... إنشاء باقي الأعمدة الأخرى التي ترغب في عرضها ...
        // إنشاء TableView
        tableView = new TableView<>();
        tableView.getColumns().addAll(idColumn, usernameColumn, passwordColumn, firstNameColumn, lastNameColumn, ageColumn, emailColumn, phoneColumn, genderColumn, roleColumn);

        Button btn99 = new Button("+Create");
        Button btn66 = new Button("Show");
        Button btn26 = new Button("Update");
        Button btn27 = new Button("Delete");
        HBox hbtns = new HBox(10, btn99, btn26, btn27);
        TextField entered = new TextField();
        entered.setPromptText("Search By First Name");
        Button btnsrc = new Button("Search");
        HBox serch = new HBox(entered, btnsrc);
        serch.setAlignment(Pos.CENTER);
        hbtns.setAlignment(Pos.CENTER);
        Label l4 = new Label("ALL PATIENT");
        HBox h4 = new HBox(logoImageView, l4);
        h4.getStyleClass().add("aaa");
        contentPane.setLeft(sidebar);
        VBox v4 = new VBox(10, tableView, btn66, hbtns, serch);
        v4.setAlignment(Pos.CENTER);
        contentPane.setCenter(v4);
        contentPane.setTop(h4);

        Scene scene = new Scene(contentPane, 990, 700);
        scene.getStylesheets().add("file:src/Css/primary.css");
        sidebar.getStyleClass().add("sid");

        l4.getStyleClass().add("pg");
        btn1.getStyleClass().add("button-style");
        btn1.getStyleClass().add("actv");
        btn2.getStyleClass().add("button-style");
        btn3.getStyleClass().add("button-style");
        btn4.getStyleClass().add("button-style");
        btn5.getStyleClass().add("button-style");
        btn99.getStyleClass().add("button-style");
        btn66.getStyleClass().add("button-style");
        btn26.getStyleClass().add("button-style");
        btn27.getStyleClass().add("button-style");
        btnsrc.getStyleClass().add("button-style3");
        entered.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;-fx-background-color: white;");

        entered.setMaxWidth(200);
        entered.setMaxHeight(30);
        this.setScene(scene);
        this.setTitle("All Patient Page");
        this.show();
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openafreeAppointmentsPage();
                ViewManager.closeAdminDashboardPage();
            }

        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openabookedAppointmentsPage();
                ViewManager.closeAdminDashboardPage();
            }

        });

        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openAdminRegisterPage();
                ViewManager.closeAdminDashboardPage();
            }

        });
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openAdminLoginPage();
                ViewManager.closeAdminDashboardPage();
            }

        });
        btn66.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // جلب جميع المستخدمين من قاعدة البيانات وعرضهم في الـ TableView
                ObservableList<Users> userList = Users.getAllUsers();
                tableView.setItems(userList);
            }
        });
        btn99.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openAdminCreatePatientPage();
                ViewManager.closeAdminDashboardPage();
            }

        });
        btn27.setOnAction(e -> {
            // الحصول على العنصر المحدد من الجدول
            Users selectedUser = tableView.getSelectionModel().getSelectedItem();
            if (selectedUser != null) {
                // عرض نافذة تأكيد الحذف
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete this patient?");

                // تعيين أزرار التأكيد والإلغاء
                ButtonType confirmButton = new ButtonType("Delete");
                ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(confirmButton, cancelButton);

                // مراقبة حدث النقر على الأزرار
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == confirmButton) {
                    // قم بحذف المريض من قاعدة البيانات
                    selectedUser.deleteFromDatabase();
                    showAlert2("The Patient Is Deleted ");
                    // قم بحذف العنصر من الجدول
                    tableView.getItems().remove(selectedUser);
                }
            } else {
                showAlert3("No Row Is Selected!");
            }
        });
        btn26.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Users selectedUser = tableView.getSelectionModel().getSelectedItem();
                if (selectedUser != null) {
                    try {
                        openNewWindow();
                    } catch (SQLException ex) {
                        Logger.getLogger(adminDashboardPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ViewManager.closeAdminDashboardPage();
                } else {
                    showAlert3("No Row Is Selected!");
                }
            }
        });
        btnsrc.setOnAction(e -> {
            String enteredText = entered.getText();
            searchUsers(enteredText);
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
        TextField username = new TextField();
        username.setPromptText("Enter Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Enter Password");
        TextField fname = new TextField();
        fname.setPromptText("Enter First Name");
        TextField lname = new TextField();
        lname.setPromptText("Enter Last Name");
        TextField age = new TextField();
        age.setPromptText("Enter Your Age");
        TextField email = new TextField();
        email.setPromptText("Enter Your Email");
        TextField phone = new TextField();
        phone.setPromptText("Enter Your Phone Number");
        username.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;  -fx-background-color: white;");
        password.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;  -fx-background-color: white;");
        fname.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;  -fx-background-color: white;");
        lname.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;  -fx-background-color: white;");
        age.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;  -fx-background-color: white;");
        email.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;  -fx-background-color: white;");
        phone.setStyle("-fx-border-color: transparent transparent #00c9bd transparent;  -fx-background-color: white;");

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
        Button btn26 = new Button("Update");
        Label l4 = new Label("CREARTE PATIENT");
        HBox h4 = new HBox(logoImageView, l4);
        h4.getStyleClass().add("aaa");
        contentPane.setLeft(sidebar);
        VBox v4 = new VBox(25, logoImageView2, username, password, fname, lname, age, email, phone, genderBox, btn26);
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
                Users selectedUser = tableView.getSelectionModel().getSelectedItem();
                if (selectedUser != null) {
                    if (username.getText().isEmpty() || password.getText().isEmpty() || fname.getText().isEmpty() || lname.getText().isEmpty()
                            || age.getText().isEmpty() || email.getText().isEmpty() || phone.getText().isEmpty() || genderGroup.getSelectedToggle() == null) {
// Display an alert to notify the user to fill all fields

                        showAlert("The data is incomplete 👎");
                    } else {
                        selectedUser.setUsername(username.getText());
                        selectedUser.setPassword(password.getText());
                        selectedUser.setFirstname(fname.getText());
                        selectedUser.setLastname(lname.getText());
                        selectedUser.setAge(age.getAnchor());
                        selectedUser.setPhone(phone.getText());
                        selectedUser.setEmail(email.getText());
                        selectedUser.setAge(Integer.parseInt(age.getText()));
                        try {
                            selectedUser.update(selectedUser);

                        } catch (SQLException ex) {
                            Logger.getLogger(adminDashboardPage.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(adminDashboardPage.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        showAlert("Patient data updated successfully!");
                        username.clear();
                        password.clear();
                        fname.clear();
                        lname.clear();
                        age.clear();
                        email.clear();
                        phone.clear();
                        genderGroup.selectToggle(null);
                        tableView.refresh();
                        ViewManager.openAdminDashboardPage();
                        secondaryStage.close();
                    }
                } else {

                    showAlert("No patient selected!");

                    genderGroup.selectToggle(null);
                }

            }
        });

        this.setTitle("Create Patient Page");
        this.show();
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ViewManager.openAdminDashboardPage();
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

//
//        Label l = new Label("THIS IS ADMIN DASHBOARD PAGE");
//        Button btn = new Button("Logout");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                ViewManager.openPatientLoginPage();
//                ViewManager.closeAdminDashboardPage();
//            }
//
//        });
//
//        VBox v1 = new VBox(l, btn);
//        Scene scene = new Scene(v1, 500, 500);
//        this.setScene(scene);
//        this.setTitle("Admin Dashboard Page");
//        this.show();
