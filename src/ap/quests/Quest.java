package ap.quests;

public class Quest
{
	// Details
	private String infoName;
	private String infoType;
	
	// Stages
	private int stageActive;
	private String[] stageObjective;
	
	public Quest(String type, String name)
	{
		infoName = name;
		infoType = type;
		stageActive = 0;
	}
	
	public String getName()
	{
		return infoName;
	}
	
	public int getStage()
	{
		return stageActive;
	}
	
	public String getStageObjective(int stage)
	{
		return stageObjective[stage];
	}
	
	public String getType()
	{
		return infoType;
	}
	
	public void setStage(int stage)
	{
		stageActive = stage;
	}
	
	public void setStageObjective(int stage, String objective)
	{
		stageObjective[stage] = objective;
	}
}