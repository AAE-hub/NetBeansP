/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionprogramfx.v2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author 2
 */
public class EncryptionProgramFXV2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10, 10, 10, 10));
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(1, 1, 1, 1));
        grid.setAlignment(Pos.CENTER);

        HBox hbox = new HBox();
        hbox.setSpacing(10);

        grid.setStyle("-fx-background-color: #b3b3ff;");
        grid.setMinSize(100, 100);
        grid.setVgap(25);
        grid.setHgap(5);

        Text username = new Text("Plain text :");
        grid.add(username, 0, 2);

        TextField text = new TextField();

        grid.add(text, 2, 2, 100, 1);

        Text password = new Text("Encrypted text:");
        grid.add(password, 0, 3);

        TextField text2 = new TextField();

        grid.add(text2, 2, 3, 100, 1);

        Button btn = new Button();
        btn.setText("Encrypt");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String a = text.getText();
                System.out.println(a);

                enc(a);
                text.clear();
            }
        });

        Button btn2 = new Button();
        btn2.setText("decrypt");
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String a = text2.getText();
                System.out.println(a);

                dec(a);
                text2.clear();
            }
        });

        hbox.getChildren().add(btn);
        hbox.getChildren().add(btn2);

        hbox.setAlignment(Pos.BOTTOM_CENTER);
        bPane.setBottom(hbox);
        bPane.setCenter(grid);
        bPane.minWidth(650);

        HBox.setMargin(btn, new Insets(10, 10, 10, 10));
        HBox.setMargin(btn2, new Insets(10, 10, 10, 10));

        Scene scene = new Scene(bPane, 650, 250);

        primaryStage.setTitle("Encryption Program V2");
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(350);
        primaryStage.setMinWidth(700);

        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public String enc(String plaintxt) {
        plaintxt = plaintxt.replaceAll(" ", "");

        byte[] byt = plaintxt.getBytes();

        byte[] encByt = new byte[plaintxt.length()];

        for (int i = 0; i < byt.length; i++) {

            encByt[i] = (byte) (byt[i] + 3);

        }
        String str = new String(encByt);

        System.out.println(str);

        TextArea enctext = new TextArea(str);
        enctext.setWrapText(true);
        enctext.setMinHeight(450);
        //GridPane enclay = new GridPane();

       // enclay.getChildren().add(enctext);
        VBox vbox = new VBox(enctext);
        vbox.setPadding(new Insets(5, 5, 10, 10));

        //enclay.setPadding(new Insets(10, 10, 10, 10));
        Scene secondScene = new Scene(vbox, 600, 500);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Encrypted text");

        newWindow.setScene(secondScene);

        // Set position of second window, related to primary window.
        newWindow.show();
        return "";

    }

    public String dec(String plaintxt) {
        plaintxt = plaintxt.replaceAll(" ", "");

        byte[] byt = plaintxt.getBytes();

        byte[] encByt = new byte[plaintxt.length()];

        for (int i = 0; i < byt.length; i++) {

            encByt[i] = (byte) (byt[i] - 3);

        }
        String str = new String(encByt);

        System.out.println(str);

        TextArea enctext = new TextArea(str);
        enctext.setWrapText(true);
        enctext.setMinHeight(450);
        //GridPane enclay = new GridPane();

       // enclay.getChildren().add(enctext);
        VBox vbox = new VBox(enctext);
        vbox.setPadding(new Insets(5, 5, 10, 10));

        //enclay.setPadding(new Insets(10, 10, 10, 10));
        Scene secondScene = new Scene(vbox, 600, 500);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("decrypted text");

        newWindow.setScene(secondScene);

        // Set position of second window, related to primary window.
        newWindow.show();
        return "";

    }

    
}
