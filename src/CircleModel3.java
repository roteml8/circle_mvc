import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public class CircleModel3 implements CircleEvents
{

	private int count; // model serial num
	private DoubleProperty radius = new SimpleDoubleProperty(20); // circle radius		
	private BooleanProperty filled = new SimpleBooleanProperty(); // is filled
	private BooleanProperty area = new SimpleBooleanProperty(); // is area displayed
	private ObjectProperty<Color> color = new SimpleObjectProperty<Color>(Color.BLACK); // circle color
	private ObservableMap<eventType,ObservableList<EventHandler<CircleActionEvent>>> eventHandlerMap; //hash map of eventType to a list of event handlers
	
	public CircleModel3 (int count)
	{
		this.count=count;
	}
	
	public double getRadius()
	{
		return radius.get();
	}
	
	public void setRadius(double radius)
	{
		this.radius.set(radius);
		this.processEvent(eventType.RADIUS,new CircleActionEvent(this, eventType.RADIUS.toString()));
		
	}
	
	public boolean isFilled()
	{
		return filled.get();
	}
	
	public void setFilled(boolean filled)
	{
		this.filled.set(filled);
		this.processEvent(eventType.FILLED,new CircleActionEvent(this, eventType.FILLED.toString()));
	}
	
	public Color getColor()
	{
		return color.get();
	}
	
	public boolean getArea()
	{
		return area.get();
	}
	
	public void setArea(boolean area)
	{
		this.area.set(area);
		this.processEvent(eventType.AREA,new CircleActionEvent(this, eventType.AREA.toString()));
	}
	
	
	 public void setColor (Color color)
	 {
		 this.color.set(color);
		 this.processEvent(eventType.COLOR,new CircleActionEvent(this,eventType.COLOR.toString()));
	 }
	 
	public synchronized void addEventHandler (EventHandler<CircleActionEvent> h, eventType et)
	{
		if (eventHandlerMap == null)
			eventHandlerMap = FXCollections.observableHashMap();
		if (!eventHandlerMap.containsKey(et))
		{
			ObservableList<EventHandler<CircleActionEvent>> eventHandlerList = FXCollections.observableArrayList();
			eventHandlerList.add(h);
			eventHandlerMap.put(et, eventHandlerList);
		}
   	 } 	
		
		public synchronized void removeEventHandler (eventType et)
		{
			if (eventHandlerMap!=null && eventHandlerMap.containsKey(et))
				eventHandlerMap.remove(et);
		}
		
		// handle event, print num of model, size of map and event message
		 private synchronized void processEvent (eventType et, CircleActionEvent e)
		 {
			 System.out.println("Circle Model: "+(count+1));
			 System.out.println("Size of eventHandlerMap is: "+eventHandlerMap.size());
			 ObservableList<EventHandler<CircleActionEvent>> eventHandlers = eventHandlerMap.get(et);
			 for (int i=0; i<eventHandlers.size();i++)
			 {
				 eventHandlers.get(i).handle(e);
				 System.out.println("Event is: "+et.toString());
			 }
			 
		 }
}
