package ap.battle;

public class ActionMystic extends Action
{
	// Spell
	public int spellCost;
	public String spellElement;
	public boolean spellReflectable = true;
	
	public ActionMystic(String name)
	{
		super(name);
	}

}