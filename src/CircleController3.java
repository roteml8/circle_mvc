import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CircleController3 extends GridPane implements CircleEvents, EventHandler<ActionEvent> 
{

	private CircleModel3 model; // the model
	private TextField tfRadius = new TextField(); // text field for radius
	private ComboBox<Boolean> cboFilled = new ComboBox<Boolean> (FXCollections.observableArrayList(false,true)); //cbo to filled
	private ComboBox<Boolean> cboArea = new ComboBox<Boolean> (FXCollections.observableArrayList(false,true)); // cbo to display area
	private ColorPicker cp = new ColorPicker(); // cp to circle
	private final double minRadius = 0; // lower bound to radius 
	
	
	public CircleController3()
	{
		this.setPadding(new Insets(20));
		this.setHgap(10);
		this.setVgap(10);
		this.setAlignment(Pos.CENTER_LEFT);
		
		this.add(new Label("Radius"),0,0);
		this.add(new Label("Filled"), 0, 1);
		this.add(new Label("Area"), 0, 2);
		this.add(new Label("Color"), 0, 3);
		
		this.add(tfRadius,1,0);
		this.add(cboFilled, 1, 1);
		this.add(cboArea, 1, 2);
		cboFilled.setValue(false);
		cboArea.setValue(false);
		this.add(cp, 1, 3);
		cboFilled.setPrefWidth(150);
		tfRadius.setPrefWidth(300);
		cp.setPrefWidth(150);
		cboArea.setPrefWidth(150);
			
		tfRadius.setOnAction(this);
		cboFilled.setOnAction(this);
		cp.setOnAction(this);
		cboArea.setOnAction(this);
	}
	
	@Override
	public void handle(ActionEvent e)
	{
		if (model == null)
			return;
		if (e.getSource()==tfRadius)
		{
			double radius = new Double(tfRadius.getText()).doubleValue();
			if (radius <= minRadius)
				tfRadius.setText("Radius must be above 0");
			else
				model.setRadius(radius);
		}
		else if (e.getSource()==cboFilled)
			model.setFilled(cboFilled.getValue());
		else if (e.getSource()==cboArea)
			model.setArea(cboArea.getValue());
		else if (e.getSource()==cp)
			model.setColor(cp.getValue());
		
	}
	
	public void setModel (CircleModel3 model)
	{
		this.model=model;

	}
	
	public CircleModel3 getModel()
	{
		return model;
	}
}
