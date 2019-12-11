import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public class CircleModel1 {

	private DoubleProperty radius = new SimpleDoubleProperty(20); // circle radius	
	private BooleanProperty filled = new SimpleBooleanProperty(); // is filled
	private SimpleObjectProperty<Color> color = new SimpleObjectProperty<Color>(Color.BLACK); // circle color
	private ObservableList<EventHandler<CircleActionEvent>> eventHandlerList; // event handlers list 
	
	public double getRadius()
	{
		return radius.get();
	}
	
	public void setRadius(double radius)
	{
		this.radius.set(radius);
		this.processEvent(new CircleActionEvent(this, "radius"));
		
	}
	
	public boolean isFilled()
	{
		return filled.get();
	}
	
	public void setFilled(boolean filled)
	{
		this.filled.set(filled);
		this.processEvent(new CircleActionEvent(this, "filled"));
	}
	
	public Color getColor()
	{
		return color.get();
	}
	
	 public void setColor (Color color)
	 {
		 this.color.set(color);
		 this.processEvent(new CircleActionEvent(this,"color"));
	 }
	
	public synchronized void addEventHandler (EventHandler<CircleActionEvent> h)
	{
		if (eventHandlerList == null)
			eventHandlerList = FXCollections.observableArrayList();
		if (!eventHandlerList.contains(h))
			eventHandlerList.add(h);
	}
	
	public synchronized void removeEventHandler (EventHandler<CircleActionEvent> h)
	{
		if (eventHandlerList!=null && eventHandlerList.contains(h))
			eventHandlerList.remove(h);
	}
	
	// print size of event handler list and event message
	 private synchronized void processEvent (CircleActionEvent e)
	 {
		 System.out.println("Size of eventHandlerList is: "+eventHandlerList.size());
		 for (int i=0; i<eventHandlerList.size();i++)
		 {
			 eventHandlerList.get(i).handle(e);
			 System.out.println("Event is: "+e.getMessage());
		 }
		 
	 }
}
