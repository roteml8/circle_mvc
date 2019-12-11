import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SingleCircleMVC1 extends Application {
	
	private CircleModel1 model = new CircleModel1();
	
	public void showController()
	{
		Stage cs = new Stage();
		CircleController1 c = new CircleController1();
		c.setModel(model);
		Scene s = new Scene(c,200,200);
		cs.setTitle("Controller");
		cs.setScene(s);
		cs.setAlwaysOnTop(true);
		cs.setOnCloseRequest(e -> e.consume());
		cs.setResizable(true);
		cs.setX(200);
		cs.setY(200);
		cs.show();
	}
	
	public void showView()
	{
		Stage vs = new Stage();
		CircleView1 view = new CircleView1();
		view.setModel(model);
		Scene scene = new Scene(view,500,200);
		vs.setTitle("View");
		vs.setScene(scene);
		vs.setAlwaysOnTop(true);
		vs.setOnCloseRequest(e-> e.consume());
		vs.setX(300);
		vs.setY(300);
		vs.show();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button btController = new Button("Show Controller");
		Button btView = new Button("Show View");
		HBox hbox = new HBox(20,btController, btView);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(20));
		btController.setOnAction(e-> showController());
		btView.setOnAction(e-> showView());
		Scene scene = new Scene(hbox,400,100);
		primaryStage.setOnCloseRequest(e-> Platform.exit());
		primaryStage.setTitle("SingleCircleMVC1");
		primaryStage.setScene(scene);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.setResizable(true);
		primaryStage.setX(0);
		primaryStage.setY(0);
		primaryStage.show();
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
	

}
