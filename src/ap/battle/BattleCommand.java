package ap.battle;

public class BattleCommand
{
	// Details
	public String commandName;
	public String commandType;
	public boolean commandDisabled = false;
	
	// Hint
	public boolean commandHintShow;
	public String commandHintText;
	
	// Action
	public Action commandAction;
	
	// Menu
	public Action[] commandMenuAction;
	
	public BattleCommand(String name)
	{
		commandName = name;
	}
}