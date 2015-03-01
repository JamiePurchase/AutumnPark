package ap;

import ap.inventory.Inventory;
import ap.journal.Journal;
import ap.quests.QuestLog;

public class Session
{
	private static String filePath;
	public static Inventory inventory;
	public static Journal journal;
	public static QuestLog questLog;
	
	public Session()
	{
		
	}
	
	public String getFilePath()
	{
		return filePath;
	}
	
	public void setFilePath(String path)
	{
		filePath = path;
	}
	
	public static void setInventory(Inventory newInventory)
	{
		inventory = newInventory;
	}
	
	public static void setJournal(Journal newJournal)
	{
		journal = newJournal;
	}
	
	public static void setQuestLog(QuestLog newQuestLog)
	{
		questLog = newQuestLog;
	}
}