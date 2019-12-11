import javafx.event.Event;

// ActionEvent class for circle events 
public class CircleActionEvent extends Event {


	private static final long serialVersionUID = 1L;
	private String msg;
	
	public CircleActionEvent(Object source, String msg)
	{
		super(source,null,null);
		this.msg=msg;
	}
	
	public String getMessage()
	{
		return msg;
	}

}
