/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming3task1;

import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ImageCycle extends Application {

    String IMGAES_PATHS[] = {"image1.jpg", "image2.jpg", "image3.jpg", "image4.jpg"};

    ImageView imageView = new ImageView();
    
    GridPane gridPane() {
        GridPane gridpane = new GridPane();
        gridpane.addRow(0, imageView);
        gridpane.setHgap(20);
        gridpane.setVgap(20);
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setPadding(new Insets(20));
        return gridpane;
    }
    
    @Override
    public void start(Stage primaryStage) {

        imageView.setFitHeight(600);
        imageView.setFitWidth(600);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    int i = 0;
                    while (true) {
                        imageView.setImage(new Image(IMGAES_PATHS[i % 4]));
                        i++;
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException exception) {
                    Logger.getLogger(ImageCycle.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        });

        Scene se = new Scene(gridPane(), 600, 600);
        Stage stage = new Stage();
        stage.setTitle("IMAGES SHOW");
        stage.setScene(se);
        stage.show();
        thread.start();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
