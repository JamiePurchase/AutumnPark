package ap.dialogue;

import ap.Game;
import ap.message.MessageStandard;

public class talkHofmann
{
	// Persistent
	public int approval;
	public boolean introduction;
	
	// Temporary
	private String[] dialogue = new String[4];
	
	public talkHofmann()
	{
		approval = 0;
		introduction = false;
	}
	
	public void talk()
	{
		if(introduction==false)
		{
			dialogue[1] = "...then by adding extract of moten jagervine, we significantly reduce the...";
			dialogue[2] = "...oh! Who are you? What are you doing in my lab?";
			dialogue[3] = "Are you here to answer my request for an alchemical assistant?";
			
			MessageStandard message = new MessageStandard(dialogue[1],dialogue[2],dialogue[3]);
			Game.setMessage(message);
			//Game.messageChainRemainder
			introduction = true;
		}
	}
	
}