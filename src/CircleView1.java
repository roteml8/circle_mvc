import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleView1 extends StackPane {

	private CircleModel1 model; // the model
	private Circle c = new Circle(); // the circle
	

	
	public void setModel (CircleModel1 newModel)
	{
		model = newModel;
		model.addEventHandler(e-> paint());
		paint();
		this.getChildren().add(c);
	}

	public void paint() 
	{
		c.setStroke(model.getColor());
		c.setRadius(model.getRadius());
		if (model.isFilled())
			c.setFill(model.getColor());
		else
			c.setFill(Color.TRANSPARENT);
	}

	public CircleModel1 getModel()
	{
		return model;
	}
}
