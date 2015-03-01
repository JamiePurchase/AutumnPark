package ap.scenery;

import java.awt.image.BufferedImage;

import ap.Game;
import ap.dialogue.Conversation;
import ap.gfx.Assets;

public class Scenery
{
	public Scenery()
	{
		
	}
	
	public void interact(String ref)
	{
		if(ref=="BedRest")
		{
			Conversation newConversation = new Conversation();
			newConversation.pieceAddStandard("There's nothing like your own warm, cozy bed...","You could rest here for a while.","");
			// Note: make a yes/no piece so the player can choose to rest
			newConversation.advance();
			Game.conversationStart(newConversation);
		}
		if(ref=="JvGateWooden")
		{
			// Disable Actions
			Game.world.setListenKey(false, 60);
			
			// Frame 1
			Game.world.setTimerTileTransform(57, 9, 15, Assets.tlsFenceWooden[33], 1);
			Game.world.setTimerTileTransform(58, 9, 15, Assets.tlsFenceWooden[34], 1);
			Game.world.setTimerTileTransform(59, 9, 15, Assets.tlsFenceWooden[35], 1);
			Game.world.setTimerTileTransform(57, 10, 15, Assets.tlsFenceWooden[45], 1);
			Game.world.setTimerTileTransform(58, 10, 15, Assets.tlsFenceWooden[46], 1);
			Game.world.setTimerTileTransform(59, 10, 15, Assets.tlsFenceWooden[47], 1);

			// Frame 2
			Game.world.setTimerTileTransform(57, 9, 30, Assets.tlsFenceWooden[30], 1);
			Game.world.setTimerTileTransform(58, 9, 30, Assets.tlsFenceWooden[31], 1);
			Game.world.setTimerTileTransform(59, 9, 30, Assets.tlsFenceWooden[32], 1);
			Game.world.setTimerTileTransform(57, 10, 30, Assets.tlsFenceWooden[42], 1);
			Game.world.setTimerTileTransform(58, 10, 30, Assets.tlsFenceWooden[43], 1);
			Game.world.setTimerTileTransform(59, 10, 30, Assets.tlsFenceWooden[44], 1);

			// Frame 3
			Game.world.setTimerTileTransform(57, 9, 45, Assets.tlsFenceWooden[6], 1);
			Game.world.setTimerTileTransform(58, 9, 45, Assets.tlsFenceWooden[7], 1);
			Game.world.setTimerTileTransform(59, 9, 45, Assets.tlsFenceWooden[8], 1);
			Game.world.setTimerTileTransform(57, 10, 45, Assets.tlsFenceWooden[18], 1);
			Game.world.setTimerTileTransform(58, 10, 45, Assets.tlsFenceWooden[19], 1);
			Game.world.setTimerTileTransform(59, 10, 45, Assets.tlsFenceWooden[20], 1);

			// Frame 4
			Game.world.setTimerTileTransform(57, 9, 60, Assets.tlsFenceWooden[3], 0);
			Game.world.setTimerTileTransform(58, 9, 60, Assets.tlsFenceWooden[4], 0);
			Game.world.setTimerTileTransform(59, 9, 60, Assets.tlsFenceWooden[5], 0);
			Game.world.setTimerTileTransform(57, 10, 60, Assets.tlsFenceWooden[15], 0);
			Game.world.setTimerTileTransform(58, 10, 60, Assets.tlsFenceWooden[16], 0);
			Game.world.setTimerTileTransform(59, 10, 60, Assets.tlsFenceWooden[17], 0);
			
			// Remove Scenery
			Game.world.setTimerSceneryRemove(57, 10, 60);
			Game.world.setTimerSceneryRemove(58, 10, 60);
			Game.world.setTimerSceneryRemove(59, 10, 60);
		}
		if(ref=="JvJobBoard")
		{
			Conversation newConversation = new Conversation();
			newConversation.pieceAddStandard("Jharva Temple Notice Board","There's nothing of interest at the moment...","");
			// Note: start some quests here
			newConversation.advance();
			Game.conversationStart(newConversation);
		}
	}
}