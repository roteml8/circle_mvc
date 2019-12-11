import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleView2 extends StackPane implements CircleEvents 
{

	private CircleModel2 model; // the model
	private Circle c = new Circle(); // the circle
	private String event = "DEFAULT"; // string representation of event
	private int counter; // serial num
	private Label text = new Label(); // text label to display circle and event details
	
	public CircleView2(int counter)
	{
		this.counter=counter;
	}

	public void setModel(CircleModel2 model)
	{
		this.model=model;
		for (eventType et: eventType.values())
			model.addEventHandler(e-> { event = et.toString(); paint();} , et);
		paint();
		this.getChildren().add(c);
		this.getChildren().add(text);
		StackPane.setAlignment(text, Pos.TOP_LEFT);
	}	
	
	public void paint()
	{
		double area;
		double radius = model.getRadius();
		String areaS = "";
		c.setRadius(model.getRadius());
		c.setStroke(model.getColor());
		if (model.isFilled())
			c.setFill(model.getColor());
		else
			c.setFill(Color.TRANSPARENT);
		if (model.getArea())
		{
			  area = model.getRadius() * model.getRadius() * Math.PI;
			  areaS = "Circle Area: "+area;
		}
		text.setText("\n\tEvent Type: "+event+"\n\t"+"Circle Number: "+(counter+1)+"\n\t"+"Circle Radius: "+radius+"\n\t"+areaS);
		
	}
	
	public CircleModel2 getModel(){
		return model;
	}
}
