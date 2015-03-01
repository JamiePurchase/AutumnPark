package ap.entities;

public abstract class CreatureEntity extends Entity
{
	private static String action;
	private static String direction;
	private static int walkFrame;
	private static int walkFrameTick;
	private static int walkSpeed;
	private static int statHealth;
	
	public CreatureEntity()
	{
		action = "Idle";
		direction = "S";
		walkFrame = 0;
		walkFrameTick = 0;
		walkSpeed = 1;
	}
	
	public static String getAction()
	{
		return action;
	}
	
	public static String getDirection()
	{
		return direction;
	}
	
	public static int getStatHealth()
	{
		return statHealth;
	}
	
	public static int getWalkFrame()
	{
		return walkFrame;
	}
	
	public static int getWalkFrameTick()
	{
		return walkFrameTick;
	}
	
	public static int getWalkFrameTickCount(int speed)
	{
		return 11 - speed;
	}
	
	public static int getWalkSpeed()
	{
		return walkSpeed;
	}
	
	public static void setAction(String act)
	{
		action = act;
	}
	
	public static void setDirection(String dir)
	{
		direction = dir;
	}
	
	public static void setStatHealth(int health)
	{
		statHealth = health;
	}
	
	public static void setWalkFrame(int value)
	{
		walkFrame = value;
	}
	
	public static void setWalkFrameTick()
	{
		walkFrameTick = walkFrameTick + 1;
		//if(walkFrameTick>getWalkFrameTickCount(walkSpeed))
		if(walkFrameTick>10)
		{
			walkFrame = walkFrame + 1;
			walkFrameTick = 0;
		}
	}
	
	public static void setWalkSpeed(int speed)
	{
		walkSpeed = speed;
	}
	
	public static void walk(String direction)
	{
		setAction("Walk");
		setDirection(direction);
		setWalkFrame(1);
	}
}