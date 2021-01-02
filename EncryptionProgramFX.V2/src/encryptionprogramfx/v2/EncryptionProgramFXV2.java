/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionprogramfx.v2;

//packages
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
        
        //main container
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10, 10, 10, 10));
       
        //gridpane inside a broderpane(bPane)
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(1, 1, 1, 1));
        grid.setAlignment(Pos.CENTER);

        //hbox for buttons
        HBox hbox = new HBox();
        hbox.setSpacing(10);

        //gridpane (grid) style 
        grid.setStyle("-fx-background-color: #b3b3ff;");
        grid.setMinSize(100, 100);
        grid.setVgap(25);
        grid.setHgap(5);

        //plain text:
        Text username = new Text("Plain text :");
        grid.add(username, 0, 2);

        //text for plain text
        TextField text = new TextField();

        //adding text to grid
        grid.add(text, 2, 2, 100, 1);

        //encrypted text:
        Text password = new Text("Encrypted text:");
        grid.add(password, 0, 3);

        //text field and add it
        TextField text2 = new TextField();
        grid.add(text2, 2, 3, 100, 1);

        //new button and name it
        Button btn = new Button();
        btn.setText("Encrypt");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
              //adding text field input as string
                String a = text.getText();
              //enc method
                enc(a);
              //clear text from input
                text.clear();
            }
        });
             //another button
        Button btn2 = new Button();
        btn2.setText("decrypt");
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String a = text2.getText();
                
                //dec method
                dec(a);
                //clear last input
                text2.clear();
            }
        });

        //hbox for buttons
        hbox.getChildren().add(btn);
        hbox.getChildren().add(btn2);
        //placing hbox
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        //placing borderpane and gridpane and style
        bPane.setBottom(hbox);
        bPane.setCenter(grid);
        bPane.minWidth(650);

        //hbox margin
        HBox.setMargin(btn, new Insets(10, 10, 10, 10));
        HBox.setMargin(btn2, new Insets(10, 10, 10, 10));
         //create scene for boredpane
        Scene scene = new Scene(bPane, 650, 250);
        //Stage
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
       //deleting all spaces
        plaintxt = plaintxt.replaceAll(" ", "");
        //byte array and its length
        byte[] byt = plaintxt.getBytes();
        byte[] encByt = new byte[plaintxt.length()];
         
        //move every char three char bytes forward
        for (int i = 0; i < byt.length; i++) {

            encByt[i] = (byte) (byt[i] + 3);

        }
        //store for loop in str as a word or sentence
        String str = new String(encByt);
        
        System.out.println(str);

        //creating text area to show encrypted sentence
        TextArea enctext = new TextArea(str);
        enctext.setWrapText(true);
        enctext.setMinHeight(450);
        
        //encrypted text in vbox
        VBox vbox = new VBox(enctext);
        vbox.setPadding(new Insets(5, 5, 10, 10));

        //new scene
        Scene secondScene = new Scene(vbox, 600, 500);

 
        Stage newWindow = new Stage();
        newWindow.setTitle("Encrypted text");

        newWindow.setScene(secondScene);

       
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
        //storing finshed array in string
        String str = new String(encByt);
        //text area with str
        TextArea enctext = new TextArea(str);
        enctext.setWrapText(true);
        enctext.setMinHeight(450);
        //decrypted txt in vbox
        VBox vbox = new VBox(enctext);
        vbox.setPadding(new Insets(5, 5, 10, 10));
        //create new scene
        Scene secondScene = new Scene(vbox, 600, 500);
        Stage newWindow = new Stage();
        newWindow.setTitle("decrypted text");
        newWindow.setScene(secondScene);
        newWindow.show();
        return "";

    }

    
}
