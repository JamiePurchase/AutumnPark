package ap.battle;

public class BattleAction
{
	// Action
	public boolean actionActive;
	public int actionTick;
	public int actionFrame;
	public int actionFrameMax;
	
	// Source
	public String sourceForce;
	public int sourceUnit;
	
	// Target
	public String targetType;
	public int targetCount;
	public String[] targetForce;
	public int[] targetUnit;
	public int[] targetDamage;
	
	// Damage
	public boolean damageInflict;
	public boolean damageRender;
	public String damageType;
	public int damageFrameCount;
	public int damageFrameStart;
	public boolean damageReflect;

	public BattleAction()
	{
		actionActive = false;
		actionTick = 0;
		actionFrame = 0;
		actionFrameMax = 0;
		
		targetType = "Single";
		targetCount = 0;
	}
	
	public void actionStart()
	{
		actionActive = true;
	}
	
	public void setDamage(String type)
	{
		// Note: Be aware that there is an array of targets (damage can be different for each)
		damageFrameStart = 0;
		damageType = "Melee";
	}
	
	public void setSource(String force, int unit)
	{
		sourceForce = force;
		sourceUnit = unit;
	}
	
	public void setTarget(String force, int unit)
	{
		targetCount += 1;
		targetForce[targetCount] = force;
		targetUnit[targetCount] = unit;
	}
	
	public void tick()
	{
		actionTick += 1;
		if(actionTick>=10)
		{
			actionTick = 0;
			actionFrame += 1;

			// Damage
			if(actionFrame==damageFrameStart)
			{
				damageRender = true;
				damageFrameCount = 0;
			}
			
			// Done
			if(actionFrame>=actionFrameMax)
			{
				actionActive = false;
			}
		}
	}
}