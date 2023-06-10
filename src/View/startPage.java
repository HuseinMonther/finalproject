/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
public class startPage extends Stage {

    public startPage() {

        // Create the sidebar
        VBox sidebar = new VBox();
        sidebar.setSpacing(10);
        sidebar.setPadding(new Insets(10));

        Button button1 = new Button("Option 1");
        Button button2 = new Button("Option 2");
        Button button3 = new Button("Option 3");
        sidebar.getChildren().addAll(button1, button2, button3);

        // Create the main content
        BorderPane contentPane = new BorderPane();
        Label l1 = new Label("المحتوى");
        Label l3 = new Label("عيادة");
        Label l4 = new Label("اسم الصفحة");
        HBox h4 = new HBox(l3, l4);
        // Set the sidebar as the left component of the content pane
        contentPane.setLeft(sidebar);
        VBox v4 = new VBox(l1);
        contentPane.setCenter(v4);
        contentPane.setTop(h4);

        // Create the scene
        Scene scene = new Scene(contentPane, 800, 600);
        scene.getStylesheets().add("file:src/Css/jstTst.css");
        sidebar.getStyleClass().add("a");
        l3.getStyleClass().add("b");
        l4.getStyleClass().add("c");
        this.setScene(scene);
        this.setTitle("Start Page");
        this.show();
    }
}
