/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplelibraryprogram;
import javafx.event.ActionEvent;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;


import static javafx.application.Application.launch;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 *
 * @author 2
 */
public class SimpleLibraryProgram extends Application {
 
    
    books s;
     
    ObservableList<books> data = FXCollections.observableArrayList();


    TableView<books> table;
    TextField tx1 = new TextField("");
    TextField tx2 = new TextField("");
    TextField tx3 = new TextField("");
    TextField tx4 = new TextField("");
    TextField tx5 = new TextField("");

    @Override
    public void start(Stage primaryStage)throws Exception {
       
    
                
                
        
        
        table = new TableView<books>();

        table.setEditable(true);

        TableColumn o1 = new TableColumn("1");
        o1.setCellValueFactory(new PropertyValueFactory<books, String>("bookname"));
        TableColumn o2 = new TableColumn("2");
        o2.setCellValueFactory(new PropertyValueFactory<books, String>("booknumber"));
        TableColumn o3 = new TableColumn("3");
        o3.setCellValueFactory(new PropertyValueFactory<books, String>("author"));
        TableColumn o4 = new TableColumn("4");
        o4.setCellValueFactory(new PropertyValueFactory<books, String>("branch"));
        TableColumn o5 = new TableColumn("5");
        o5.setCellValueFactory(new PropertyValueFactory<books, String>("rownnumber"));
o1.setMinWidth(250);
o1.setPrefWidth(210);
o3.setPrefWidth(210);
o4.setPrefWidth(210);
o5.setPrefWidth(210);
o2.setPrefWidth(100);
o3.setMinWidth(250);


        table.getColumns().addAll(o1, o2, o3, o4, o5);
       
        Button tableb = new Button("table");
        tableb.setOnAction((ActionEvent e) -> {

            Stage wi = new Stage();

            VBox vb = new VBox(table);
            vb.setSpacing(5);
            vb.setAlignment(Pos.CENTER);
            Scene se = new Scene(vb, 500, 500);
            wi.setScene(se);
            wi.show();

        });

        Button b = new Button("add");
        b.setOnAction((ActionEvent event) -> {
         
            books s;
            
            if ( tx1.getText().isEmpty() ||tx2.getText().isEmpty() ||tx3.getText().isEmpty() ||tx4.getText().isEmpty()){
            Label label = new Label("you cant add an entity with empty value");
                
            VBox vbox = new VBox(label);
        vbox.setAlignment(Pos.CENTER);

        //new scene
        Scene secondScene = new Scene(vbox, 400, 50);

 
        Stage newWindow = new Stage();
        newWindow.setTitle("Encrypted text");
        newWindow.setScene(secondScene);
        newWindow.show();
            }  else{
            String q = tx1.getText();

            String qq = tx2.getText();

            String qqq = tx3.getText();

            String qqqq = tx4.getText();

            String qqqqq = tx5.getText();

             
            
            data.add(new books(q, qq, qqq, qqqq, qqqqq));

            table.setItems(data);

            tx1.clear();
            tx2.clear();
            tx3.clear();
            tx4.clear();
            tx5.clear();
            }
        });

        Button delete = new Button("delete");
        delete.setOnAction(e -> {

            int a = table.getSelectionModel().getSelectedIndex();

            data.remove(a);
            table.refresh();
          
        
        });

        
        table.setPrefSize(1200, 500);
         
             
        GridPane root = new GridPane();
             
        root.setPadding(new Insets(10,10,10,10));
        VBox tx=new VBox (tx1,tx2,tx3,tx4,tx5);
              
        root.setHgap(10); 
        root.setVgap(10); 
        VBox vbox;
        
        VBox label= new VBox(new Label("book name :"),
                new Label("book number:"),
                new Label("author"),
                new Label("branch number "),
                new Label("row number"));
      
        VBox vb = new VBox(table);
             
              HBox bytton=new HBox(b,delete);
          root.add(label,1 ,1);
              root.add(tx,2 ,1 );       
     
        label.setSpacing(17);
        tx.setSpacing(5);
        root.add(vb,3,1);
        
        root.add(bytton,2,2,1,1);
        bytton.setAlignment(Pos.CENTER);
        bytton.setSpacing(30);
        root.setStyle("-fx-background-color: #b3b3ff");
        tx.setStyle("-fx-background-color: #ff8080");
        label.setStyle("-fx-background-color: #77ff33");
        bytton.setStyle("-fx-background-color: #24248f");
       vb.setStyle("-fx-background-color: #77ff33");
      
//        
//           
//        
//            grid.getChildren().add(vbox);
//         
        Scene scene = new Scene(root, 1500, 400);
     
              
        
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    ObservableList<books> getBooks(String q, String qq, String qqq, String qqqq, String qqqqq) {
//        s = new books(q, qq, qqq, qqqq, qqqqq);
//        ObservableList<books> Books = FXCollections.observableArrayList();
//
//        Books.add(s);
//
//        return Books;
//    }
//
// 
    public static void main(String[] args) {
        launch(args);
    }

}
