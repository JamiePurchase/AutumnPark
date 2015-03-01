package ap.states;
import java.awt.Graphics;

public abstract class State
{	
	public abstract void tick();
	public abstract void render(Graphics g);
	private static State currentState = null;
	private static String changeState = null;
	private static boolean reinitState = false;
	
	public static State getState()
	{
		return currentState;
	}
	
	public static String getStateChange()
	{
		return changeState;
	}
	
	public static boolean getStateReinit()
	{
		return reinitState;
	}
	
	public static void setState(State state)
	{
		setState(state, false);
	}
	
	public static void setState(State state, boolean init)
	{
		currentState = state;
		reinitState = init;
	}
	
	public static void setStateChange(String change)
	{
		changeState = change;
	}
	
	public static void setStateReinit(boolean init)
	{
		reinitState = init;
	}
}