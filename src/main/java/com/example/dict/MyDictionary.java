package com.example.dict;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.IOException;
import java.sql.*;

public class MyDictionary extends Application {

    private Group tileGroup = new Group();

    int xLine = 20;
    int yLine = 20;
    int ajkd = 45;
    DirectoryUsing dictionary;

    private Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(400,300);
        root.getChildren().addAll(tileGroup);

        dictionary  = new DirectoryUsing();
        TextField wordText = new TextField("Yogitaian");
        wordText.setTranslateX(xLine);
        wordText.setTranslateY(yLine);


        Button searchBottom  = new Button("search");
        searchBottom.setTranslateX(xLine+200);
        searchBottom.setTranslateY(yLine);


        Label meaningLabel = new Label("hey bro! I am meaning");
        meaningLabel.setTranslateX(xLine);
        meaningLabel.setTranslateY(yLine+40);

        searchBottom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String word = wordText.getText();
                if(word.isEmpty())
                {
                    meaningLabel.setText("oops!please enter a word ");
                }
                else
                    meaningLabel.setText(dictionary.findMeaning(word));
            }
        });



        tileGroup.getChildren().addAll(wordText,searchBottom,meaningLabel);
        return  root;
    }
    public void connectToDatabase() {
        final String DB_URL = "jdbc:mysql://localhost:3306/my_dct";
        final String USER = "root";
        final String PASS = "Yogita@17";

        System.out.println("Connecting to database");
        String newId = "select * from word_list";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(newId);
        ) {
            while (rs.next()) {
                //Display values
                System.out.println(rs.getInt("id") + rs.getString("word") + rs.getString("meaning")); //rs.getInt("rollno");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        connectToDatabase();
        Scene scene = new Scene(createContent());
        stage.setTitle("My Dictionary!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}