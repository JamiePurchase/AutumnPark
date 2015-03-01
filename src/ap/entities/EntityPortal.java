package ap.entities;

public class EntityPortal extends Entity
{
	private String destBoard;
	private String destDirection;
	private int destX;
	private int destY;
	
	public EntityPortal()
	{
		
	}
	
	public String getDestinationBoard()
	{
		return destBoard;
	}
	
	public String getDestinationDirection()
	{
		return destDirection;
	}
	
	public int getDestinationX()
	{
		return destX;
	}
	
	public int getDestinationY()
	{
		return destY;
	}
}