package ap.message;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import ap.gfx.Assets;

public class MessageSpeech extends Message
{
	private boolean portraitActive;
	private BufferedImage portraitImage;
	private String speakerName;
	
	public MessageSpeech(String speaker, String speech1, String speech2, String speech3)
	{
		setMessageText(1, speech1);
		setMessageText(2, speech2);
		setMessageText(3, speech3);
		speakerName = speaker;
		portraitActive = false;
	}
	
	public void render(Graphics g)
	{
		// Shadow
		g.setColor(Color.GRAY);
		g.fillRect(51, 569, 1266, 150);
		g.fillRect(52, 570, 1266, 150);
		g.fillRect(53, 571, 1266, 150);
		g.fillRect(54, 572, 1266, 150);
		
		// Background
		g.setColor(Color.WHITE);
		g.fillRect(50, 568, 1266, 150);
		
		// Border
		g.setColor(Color.BLACK);
		g.drawRect(50, 568, 1266, 150);
		
		// Portrait
		if(portraitActive==true)
		{
			g.drawImage(portraitImage, 50, 568, null);
		}
		
		// Speaker
		g.setColor(Color.BLACK);
		g.setFont(Assets.fontStandardBold);
		g.drawString(speakerName, 75, 615);
		
		// Text
		g.setColor(Color.BLACK);
		g.setFont(Assets.fontStandard);
		g.drawString(getMessageText(1), 175, 615);
		g.drawString(getMessageText(2), 175, 655);
		g.drawString(getMessageText(3), 175, 695);
	}
	
	public void setPortrait(BufferedImage portrait)
	{
		portraitActive = true;
		portraitImage = portrait;
	}

}