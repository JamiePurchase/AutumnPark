package ap.dialogue;

import java.awt.Graphics;

import ap.Game;
import ap.Keyboard;
import ap.message.MessageSpeech;
import ap.message.MessageStandard;

public class Conversation
{
	public int pieceActive = 0;
	public int pieceCount = 0;
	public String[][] pieceDialogue = new String[100][4];
	public String[] pieceEvent = new String[100];
	public String[] pieceType = new String[100];
	public String[] pieceSpeaker = new String[100];
	
	// Temp
	public MessageStandard[] pieceMessage = new MessageStandard[100];
	
	public Conversation()
	{
		pieceActive = 0;
	}
	
	public void advance()
	{
		pieceActive += 1;
		if(pieceActive<=pieceCount)
		{
			if(pieceType[pieceActive]=="Standard")
			{
				pieceMessage[pieceActive] = new MessageStandard(pieceDialogue[pieceActive][1],pieceDialogue[pieceActive][2],pieceDialogue[pieceActive][3]);
			}
			/*if(pieceType[pieceActive]=="Speech")
			{
				MessageSpeech newMessage = new MessageSpeech(pieceSpeaker[pieceActive],pieceDialogue[pieceActive][1],pieceDialogue[pieceActive][2],pieceDialogue[pieceActive][3]);
				Game.messageObjectSpeech = newMessage;
			}*/
		}
		else
		{
			Game.conversationActive = false;
		}
	}
	
	/*public void pieceAddSpeech(String speaker, String dialogue1, String dialogue2, String dialogue3)
	{
		pieceCount += 1;
		pieceDialogue[pieceCount][1] = dialogue1;
		pieceDialogue[pieceCount][2] = dialogue2;
		pieceDialogue[pieceCount][3] = dialogue3;
		pieceEvent[pieceCount] = "Standard";
		pieceType[pieceCount] = "Standard";
		pieceSpeaker[pieceCount] = speaker;
	}*/
	
	public void pieceAddStandard(String dialogue1, String dialogue2, String dialogue3)
	{
		pieceCount += 1;
		pieceDialogue[pieceCount][1] = dialogue1;
		pieceDialogue[pieceCount][2] = dialogue2;
		pieceDialogue[pieceCount][3] = dialogue3;
		pieceEvent[pieceCount] = "Standard";
		pieceType[pieceCount] = "Standard";
	}
	
	public void render(Graphics g)
	{
		if(pieceType[pieceActive]=="Standard")
		{
			pieceMessage[pieceActive].render(g);
		}
		/*if(pieceType[pieceActive]=="Speech")
		{
			Game.messageObjectSpeech.render(g);
		}*/
	}
	
	public void tick()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			advance();
		}
	}
}