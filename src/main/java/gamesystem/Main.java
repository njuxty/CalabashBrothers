package gamesystem;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.WindowEvent;
import javafx.event.EventHandler;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
    	
    	boolean running = true;
    	try {
    		
    	primaryStage.setTitle("葫芦娃大战妖精");
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 750, 750);
        Gamebody gb = new Gamebody(750, 750);
        primaryStage.setScene(scene);
        root.getChildren().add(gb);
        //scene.getStylesheets().add(getClass().getClassLoader().getResource("GUI.fxml").toExternalForm());
        /*while(running==true) {
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode() == KeyCode.SPACE) {
                    	gb.threadstart();}
                    }
                });}*/
        
        
        

        primaryStage.show();}catch(Exception e) {
			e.printStackTrace();
		}
     

    }

    public static void main(String[] args) {
        launch(args);
    }
}
