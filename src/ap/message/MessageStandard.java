package ap.message;

import java.awt.Color;
import java.awt.Graphics;

import ap.gfx.Assets;

public class MessageStandard extends Message
{
	
	public MessageStandard(String text1, String text2, String text3)
	{
		setMessageText(1, text1);
		setMessageText(2, text2);
		setMessageText(3, text3);
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
		
		// Text
		g.setColor(Color.BLACK);
		g.setFont(Assets.fontStandard);
		g.drawString(getMessageText(1), 75, 615);
		g.drawString(getMessageText(2), 75, 655);
		g.drawString(getMessageText(3), 75, 695);
	}
}