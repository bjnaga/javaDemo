package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	static AnchorPane root;
	static VBox root2;
	@Override
	public void start(Stage primaryStage) {
		try {
		
			root = new AnchorPane();
			root2 = new VBox();
			Scene scene = new Scene(root2,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			load();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void load() throws FileNotFoundException{
		FileInputStream input;
	
		input =new FileInputStream("like.jpg");
		
		Image image =new Image(input);
		ImageView img = new ImageView(image);
		
		img.setFitHeight(50);
		img.setFitWidth(50);
		Button btn = new Button("click me!");
//		Button btn = new Button ("",img);
//		Button btn = new Button ("btn");
		root2.getChildren().add(btn);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("clicked");
				root2.getChildren().add(new Label("Clicked"));
				btn.setText("Button Pressed");
				Label lbl = new Label("test");
				root2.getChildren().add(lbl);
			}
		});
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
