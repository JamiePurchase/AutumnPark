package ap.quests;

public class QuestLog
{
	public Quest[] questCollection = new Quest[1];
	public int questCount =0;
	
	public QuestLog()
	{
		
	}
	
	public void init()
	{
		//Quest tutorial = new Quest("Tutorial");
		//addQuest(tutorial);
	}
	
	public void addQuest(Quest newQuest)
	{
		questCount+=1;
		//questCollection[questCount] = newQuest;
	}
	
	public int getQuestCount()
	{
		return questCount;
	}
}