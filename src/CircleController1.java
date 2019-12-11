
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class CircleController1 extends GridPane implements EventHandler<ActionEvent>{
	
	private CircleModel1 model; // the model
	private TextField tfRadius = new TextField(); // text field for radius
	private ComboBox<Boolean> cboFilled = new ComboBox<>(FXCollections.observableArrayList(new Boolean(false),new Boolean(true))); // combo box to choose filed/unfilled
	private ColorPicker cp  = new ColorPicker(); // color picker for circle 
	
	public CircleController1()
	{
		this.setPadding(new Insets(20));
		this.setHgap(10);
		this.setVgap(10);
		this.setAlignment(Pos.CENTER_LEFT);
		
		this.add(new Label("Radius"),0,0);
		this.add(new Label("Filled"), 0, 1);
		this.add(new Label("Color"), 0, 2);
		this.add(tfRadius,1,0);
		this.add(cboFilled, 1, 1);
		this.add(cp, 1, 2);

		cboFilled.setValue(false);
		cboFilled.setPrefWidth(100);
		tfRadius.setPrefWidth(100);
		cp.setPrefWidth(100);
			
		tfRadius.setOnAction(this);
		cboFilled.setOnAction(this);
		cp.setOnAction(this);
	
	}
	

	@Override
	public void handle(ActionEvent event)
	{
		if (model == null)
			return;
		if (event.getSource()==tfRadius)
			model.setRadius(new Double(tfRadius.getText()).doubleValue());
		else if (event.getSource()==cboFilled)
			model.setFilled(cboFilled.getValue());
		else if (event.getSource()==cp)
			model.setColor(cp.getValue());
		
	}
	
	public void setModel(CircleModel1 newModel)
	{
		model = newModel;
	}
	
	public CircleModel1 getModel()
	{
		return model;
	}

}
