package ap.message;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Message
{
	private static String[] messageText = new String[5]; 

	public Message()
	{
		
	}
	
	public String getMessageText(int pos)
	{
		return messageText[pos];
	}
	
	public void setMessageText(int pos, String addText)
	{
		messageText[pos] = addText;
	}

}