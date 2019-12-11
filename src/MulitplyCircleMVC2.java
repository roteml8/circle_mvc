import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MulitplyCircleMVC2 extends Application{
	
	private ObservableList<CircleModel2> modelList = FXCollections.observableArrayList(); // list of models
	private ObservableList<CircleView2> viewList = FXCollections.observableArrayList(); // list of views
	private ObservableList<CircleController2> controlList = FXCollections.observableArrayList(); // list of controllers
	private int counter = 0; // circle counter

	public void showControllerAndView()
	{
		CircleModel2 model = new CircleModel2(counter);
		Stage cs = new Stage();
		CircleController2 c = new CircleController2();
		c.setModel(model);
		Scene s = new Scene(c,500,200);
		cs.setTitle("Controller number "+(counter+1));
		cs.setScene(s);
		cs.setAlwaysOnTop(true);
		cs.setOnCloseRequest(e -> e.consume());
		cs.setResizable(false);
		cs.setX(200);
		cs.setY(200);
		cs.show();
		
		Stage vs = new Stage();
		CircleView2 view = new CircleView2(counter);
		view.setModel(model);
		Scene scene = new Scene(view,500,200);
		vs.setTitle("View number "+(counter+1));
		vs.setScene(scene);
		vs.setAlwaysOnTop(true);
		vs.setOnCloseRequest(e-> e.consume());
		vs.setX(300);
		vs.setY(300);
		vs.show();
		
		modelList.add(model);
		viewList.add(view);
		controlList.add(c);
		counter++;
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button b = new Button("Show view and controller");
		HBox hbox = new HBox(20,b);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(20));
		b.setOnAction(e-> showControllerAndView());
		Scene scene = new Scene(hbox,400,100);
		primaryStage.setOnCloseRequest(e-> Platform.exit());
		primaryStage.setTitle("MultilpleCircleMVC2");
		primaryStage.setScene(scene);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.setResizable(false);
		primaryStage.setX(0);
		primaryStage.setY(0);
		primaryStage.show();
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
