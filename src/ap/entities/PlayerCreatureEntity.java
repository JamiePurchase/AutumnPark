package ap.entities;
import ap.Game;
import ap.Keyboard;
import ap.audio.AudioPlayer;
import ap.dialogue.Conversation;
import ap.gfx.Assets;
import ap.gfx.Board;
import ap.message.MessageStandard;
import ap.scenery.Scenery;
import ap.states.State;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class PlayerCreatureEntity extends CreatureEntity
{
	private int calloutTick = 0;
	private int calloutFrame = 1;
	
	public PlayerCreatureEntity()
	{
		
	}
	
	public int getAdjacentPortal(String direction)
	{
		int posX = getPositionX();
		int posY = getPositionY();
		if(direction=="N"){posY-=1;}
		if(direction=="E"){posX+=1;}
		if(direction=="W"){posX-=1;}
		if(direction=="S"){posY+=1;}
		return Game.world.getTilePortal(posX, posY);
	}
	
	public String getFacingEntity()
	{
		return Game.world.getTileEntity(getFacingTileX(), getFacingTileY());
	}
	
	public int getFacingEntityID()
	{
		return Game.world.getTileEntityID(getFacingTileX(), getFacingTileY());
	}
	
	public int getFacingPortal()
	{
		return Game.world.getTilePortal(getFacingTileX(), getFacingTileY());
	}
	
	public int getFacingTileX()
	{
		int tileX = getPositionX();
		if(getDirection()=="E"){tileX+=1;}
		if(getDirection()=="W"){tileX-=1;}
		return tileX;
	}
	
	public int getFacingTileY()
	{
		int tileY = getPositionY();
		if(getDirection()=="N"){tileY-=1;}
		if(getDirection()=="S"){tileY+=1;}
		return tileY;
	}
	
	public static BufferedImage getImage()
	{
		if(getAction()=="Idle")
		{
			if(Game.playerClass=="Warmonger")
			{
				if(getDirection()=="N"){return Assets.charPlayer1N1;}
				if(getDirection()=="E"){return Assets.charPlayer1E1;}
				if(getDirection()=="S"){return Assets.charPlayer1S1;}
				if(getDirection()=="W"){return Assets.charPlayer1W1;}
			}
			if(Game.playerClass=="Stalker")
			{
				if(getDirection()=="N"){return Assets.charPlayer2N1;}
				if(getDirection()=="E"){return Assets.charPlayer2E1;}
				if(getDirection()=="S"){return Assets.charPlayer2S1;}
				if(getDirection()=="W"){return Assets.charPlayer2W1;}
			}
			if(Game.playerClass=="Spellweaver")
			{
				if(getDirection()=="N"){return Assets.charPlayer3N1;}
				if(getDirection()=="E"){return Assets.charPlayer3E1;}
				if(getDirection()=="S"){return Assets.charPlayer3S1;}
				if(getDirection()=="W"){return Assets.charPlayer3W1;}
			}
		}
		if(getAction()=="Walk")
		{
			if(Game.playerClass=="Warmonger")
			{
				if(getDirection()=="N")
				{
					if(getWalkFrame()==1){return Assets.charPlayer1N2;}
					if(getWalkFrame()==2){return Assets.charPlayer1N1;}
					if(getWalkFrame()==3){return Assets.charPlayer1N3;}
					if(getWalkFrame()==4){return Assets.charPlayer1N1;}
				}
				if(getDirection()=="E")
				{
					if(getWalkFrame()==1){return Assets.charPlayer1E2;}
					if(getWalkFrame()==2){return Assets.charPlayer1E1;}
					if(getWalkFrame()==3){return Assets.charPlayer1E3;}
					if(getWalkFrame()==4){return Assets.charPlayer1E1;}
				}
				if(getDirection()=="S")
				{
					if(getWalkFrame()==1){return Assets.charPlayer1S2;}
					if(getWalkFrame()==2){return Assets.charPlayer1S1;}
					if(getWalkFrame()==3){return Assets.charPlayer1S3;}
					if(getWalkFrame()==4){return Assets.charPlayer1S1;}
				}
				if(getDirection()=="W")
				{
					if(getWalkFrame()==1){return Assets.charPlayer1W2;}
					if(getWalkFrame()==2){return Assets.charPlayer1W1;}
					if(getWalkFrame()==3){return Assets.charPlayer1W3;}
					if(getWalkFrame()==4){return Assets.charPlayer1W1;}
				}
			}
			if(Game.playerClass=="Stalker")
			{
				if(getDirection()=="N")
				{
					if(getWalkFrame()==1){return Assets.charPlayer2N2;}
					if(getWalkFrame()==2){return Assets.charPlayer2N1;}
					if(getWalkFrame()==3){return Assets.charPlayer2N3;}
					if(getWalkFrame()==4){return Assets.charPlayer2N1;}
				}
				if(getDirection()=="E")
				{
					if(getWalkFrame()==1){return Assets.charPlayer2E2;}
					if(getWalkFrame()==2){return Assets.charPlayer2E1;}
					if(getWalkFrame()==3){return Assets.charPlayer2E3;}
					if(getWalkFrame()==4){return Assets.charPlayer2E1;}
				}
				if(getDirection()=="S")
				{
					if(getWalkFrame()==1){return Assets.charPlayer2S2;}
					if(getWalkFrame()==2){return Assets.charPlayer2S1;}
					if(getWalkFrame()==3){return Assets.charPlayer2S3;}
					if(getWalkFrame()==4){return Assets.charPlayer2S1;}
				}
				if(getDirection()=="W")
				{
					if(getWalkFrame()==1){return Assets.charPlayer2W2;}
					if(getWalkFrame()==2){return Assets.charPlayer2W1;}
					if(getWalkFrame()==3){return Assets.charPlayer2W3;}
					if(getWalkFrame()==4){return Assets.charPlayer2W1;}
				}
			}
			if(Game.playerClass=="Spellweaver")
			{
				if(getDirection()=="N")
				{
					if(getWalkFrame()==1){return Assets.charPlayer3N2;}
					if(getWalkFrame()==2){return Assets.charPlayer3N1;}
					if(getWalkFrame()==3){return Assets.charPlayer3N3;}
					if(getWalkFrame()==4){return Assets.charPlayer3N1;}
				}
				if(getDirection()=="E")
				{
					if(getWalkFrame()==1){return Assets.charPlayer3E2;}
					if(getWalkFrame()==2){return Assets.charPlayer3E1;}
					if(getWalkFrame()==3){return Assets.charPlayer3E3;}
					if(getWalkFrame()==4){return Assets.charPlayer3E1;}
				}
				if(getDirection()=="S")
				{
					if(getWalkFrame()==1){return Assets.charPlayer3S2;}
					if(getWalkFrame()==2){return Assets.charPlayer3S1;}
					if(getWalkFrame()==3){return Assets.charPlayer3S3;}
					if(getWalkFrame()==4){return Assets.charPlayer3S1;}
				}
				if(getDirection()=="W")
				{
					if(getWalkFrame()==1){return Assets.charPlayer3W2;}
					if(getWalkFrame()==2){return Assets.charPlayer3W1;}
					if(getWalkFrame()==3){return Assets.charPlayer3W3;}
					if(getWalkFrame()==4){return Assets.charPlayer3W1;}
				}
			}
		}
		return null;
	}
	
	public void render(Graphics g)
	{
		renderPlayer(g);
		renderCallout(g);
	}
	
	public void renderCallout(Graphics g)
	{
		// Scenery and Signs
		if(getFacingEntity()=="Scenery" || getFacingEntity()=="Sign"){renderCalloutBubble(g, Assets.uiCalloutQ);}
		
		// Portal
		renderCalloutPortal(g, "N");
		renderCalloutPortal(g, "E");
		renderCalloutPortal(g, "S");
		renderCalloutPortal(g, "W");
	}
	
	public void renderCalloutBubble(Graphics g, BufferedImage callout)
	{
		int drawX = ((getPositionX() - Game.world.getGridOffsetX()) * 32) - 11;
		int drawY = ((getPositionY() - Game.world.getGridOffsetY()) * 32) - 54;
		if(calloutFrame==1){drawX-=2;}
		if(calloutFrame==2 || calloutFrame==8){drawX-=1;}
		if(calloutFrame==4 || calloutFrame==6){drawX+=1;}
		if(calloutFrame==5){drawX+=2;}
		g.drawImage(callout, drawX, drawY, null);
	}
	
	public void renderCalloutPortal(Graphics g, String direction)
	{
		int id = getAdjacentPortal(direction);
		if(Game.world.portalType[id]=="Collide"){renderCalloutPortalArrow(g, direction);}
		if(Game.world.portalType[id]=="Interact" && getDirection()==direction){renderCalloutBubble(g, Assets.uiCalloutE);}
	}
	
	public void renderCalloutPortalArrow(Graphics g, String direction)
	{
		BufferedImage drawImage = Assets.uiCalloutPS;
		// Note: create multiple portal callouts for different directions
		//if(getDirection()=="E"){drawImage = Assets.uiCalloutPE;}
		int drawX = ((getPositionX() - Game.world.getGridOffsetX()) * 32) - 11;
		int drawY = ((getPositionY() - Game.world.getGridOffsetY()) * 32) - 16;
		if(direction=="N"){drawY-=32;}
		if(direction=="E"){drawX+=32;}
		if(direction=="W"){drawX-=32;}
		if(direction=="S"){drawY+=32;}
		if(calloutFrame==1){drawX-=2;}
		if(calloutFrame==2 || calloutFrame==8){drawX-=1;}
		if(calloutFrame==4 || calloutFrame==6){drawX+=1;}
		if(calloutFrame==5){drawX+=2;}
		g.drawImage(drawImage, drawX, drawY, null);
	}
	
	public void renderPlayer(Graphics g)
	{
		BufferedImage drawImage = getImage();
		int drawX = ((getPositionX() - Game.world.getGridOffsetX()) * 32) - 21;
		int drawY = ((getPositionY() - Game.world.getGridOffsetY()) * 32) - 16;
		
		// Actions
		if(getAction()=="Walk")
		{
			int offset = getWalkFrame() * 8;
			if(getDirection()=="N"){drawY -= offset;}
			if(getDirection()=="E"){drawX += offset;}
			if(getDirection()=="S"){drawY += offset;}
			if(getDirection()=="W"){drawX -= offset;}
			renderPlayerFootstepPlay();
		}
		else{renderPlayerFootstepStop();}
		
		// Draw Image
		drawY -= Game.world.getElevation(getPositionX(), getPositionY());
		g.drawImage(drawImage, drawX, drawY, null);
	}
	
	public void renderPlayerFootstepPlay()
	{
		if(Game.audio.getSoundActive()==false)
		{
			Game.audio.playSound(Game.world.getFootstep(getFacingTileX(), getFacingTileY()));
		}
	}
	
	public void renderPlayerFootstepStop()
	{
		Game.audio.stopSound();
	}
	
	public void setBoardNew(String newBoard, int newX, int newY, String newDirection, int offsetX, int offsetY)
	{
		Game.world.getData(newBoard);
		Assets.entPlayer.setPosition(newX,newY);
		Assets.entPlayer.setDirection(newDirection);
		Game.world.setGridOffset(offsetX, offsetY);
		
		// Temp
		if(Game.world.getGridScroll()==false)
		{
			Game.world.setGridOffset(0, 0);
		}
	}
	
	public void tick()
	{
		tickCallout();
		if(getAction()=="Idle"){tickKeyEvents();}
		tickMovement();
	}
	
	public void tickCallout()
	{
		calloutTick+=1;
		if(calloutTick>=15)
		{
			calloutTick = 0;
			calloutFrame+=1;
			if(calloutFrame>8)
			{
				calloutFrame = 1;
			}
		}
	}
	
	public void tickKeyEntity()
	{
		if(Game.world.getTileEntity(getFacingTileX(),getFacingTileY())=="NPC")
		{
			//Game.chat = true;
			
			// Debug
			/*String debug1 = "Interacted with an npc at " + getFacingTileX() + ", " + getFacingTileY();
			System.out.println(debug1);*/			
			
			int npcID = Game.world.getTileEntityID(getFacingTileX(),getFacingTileY());
			Game.world.npcObject[npcID].dialogue.talk();
		}
		if(Game.world.getTileEntity(getFacingTileX(),getFacingTileY())=="Portal")
		{
			if(Game.world.portalType[Game.world.getTileEntityID(getFacingTileX(), getFacingTileY())]=="Interact")
			{
				// Change Board
				setBoardNew(Game.world.portalSendBoard[Game.world.getTileEntityID(getFacingTileX(), getFacingTileY())], Game.world.portalSendX[Game.world.getTileEntityID(getFacingTileX(), getFacingTileY())], Game.world.portalSendY[Game.world.getTileEntityID(getFacingTileX(), getFacingTileY())], Game.world.portalSendDirection[Game.world.getTileEntityID(getFacingTileX(), getFacingTileY())], Game.world.portalOffsetX[Game.world.getTileEntityID(getFacingTileX(), getFacingTileY())], Game.world.portalOffsetY[Game.world.getTileEntityID(getFacingTileX(), getFacingTileY())]);
			}
		}
		if(Game.world.getTileEntity(getFacingTileX(),getFacingTileY())=="Scenery")
		{
			int scnID = Game.world.getTileEntityID(getFacingTileX(),getFacingTileY());
			
			// Test
			new Scenery().interact(Game.world.sceneryFile[scnID]);
			
			//Game.world.sceneryObject[scnID].script.interact();
			// Note: it may be a possibility to have a large JvScenery class that contains interaction details for lots of different scenery entities
			
			/*try
			{
				tickKeyEntityScenery(Game.world.getSceneryFile(Game.world.getTileEntityID(getFacingTileX(),getFacingTileY())));
			}
			catch (IOException e)
			{
				System.out.println("Error loading scenery data");
			}*/
			
			// Debug
			/*String debug1 = "Interacted with scenery at " + getFacingTileX() + ", " + getFacingTileY();
			System.out.println(debug1);*/
		}
		if(Game.world.getTileEntity(getFacingTileX(),getFacingTileY())=="Sign")
		{
			/*Conversation newConversation = new Conversation();
			newConversation.pieceAddSign();
			newConversation.advance();
			Game.conversationStart(newConversation);*/
		}
	}
	
	public void tickKeyEntityScenery(String filename) throws IOException
	{
		String filePath = "C:/Eclipse/Workspace/AutumnPark/res/scenery/" + filename + ".txt";
		FileReader fr = new FileReader(filePath);
		BufferedReader textReader = new BufferedReader(fr);
		int done = 0;
		int line = 0;
		while(done<1)
		{
			line+=1;
			String textData = textReader.readLine();
			
			// Debug
			String debug1 = "" + line + " " + textData;
			System.out.println(debug1);
			
			if(textData.equals("END")){done = 1;}
			
			// Temp
			MessageStandard message = new MessageStandard(textData,"","");
			Game.setMessage(message);
		}
		textReader.close();
	}
	
	public void tickKeyEvents()
	{		
		// Temp
		if(Keyboard.getKeyPressed()=="D")
		{
			Keyboard.setKeyDone();
			State.setStateChange("DevMenu");
		}
		
		// Chat
		if(Game.chat==true){tickKeyEventsChat();}
		else if(Game.messageActive==true){tickKeyEventsMessage();}
		
		// Standard
		else{tickKeyEventsStandard();}
	}
	
	public void tickKeyEventsChat()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			Game.chat = false;
		}
	}
	
	public void tickKeyEventsMessage()
	{
		if(Keyboard.getKeyPressed()=="Enter" || Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			if(Game.messageChainRemainder>0)
			Game.messageActive = false;
		}
	}
		
	public void tickKeyEventsStandard()
	{
		if(Keyboard.getKeyPressed()=="Enter")
		{
			Keyboard.setKeyDone();
			State.setStateChange("Menu");
		}
		if(Keyboard.getKeyPressed()=="Space")
		{
			Keyboard.setKeyDone();
			if(!getFacingEntity().equals("None")){tickKeyEntity();}
		}
		if(Keyboard.getKeyPressed()=="Up")
		{
			Assets.entPlayer.setDirection("N");
			if(getPositionY()>1)
			{
				int newPosX = Assets.entPlayer.getPositionX();
				int newPosY = Assets.entPlayer.getPositionY() - 1;
				tickKeyPush("N", newPosX, newPosY);
			}
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Down")
		{
			Assets.entPlayer.setDirection("S");
			if(getPositionY()<Game.world.getGridHeight())
			{
				int newPosX = Assets.entPlayer.getPositionX();
				int newPosY = Assets.entPlayer.getPositionY() + 1;
				tickKeyPush("S", newPosX, newPosY);
			}
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Left")
		{
			Assets.entPlayer.setDirection("W");
			if(getPositionX()>1)
			{
				int newPosX = Assets.entPlayer.getPositionX() - 1;
				int newPosY = Assets.entPlayer.getPositionY();
				tickKeyPush("W", newPosX, newPosY);
			}
			Keyboard.setKeyDone();
		}
		if(Keyboard.getKeyPressed()=="Right")
		{
			Assets.entPlayer.setDirection("E");
			if(getPositionX()<Game.world.getGridWidth())
			{
				int newPosX = Assets.entPlayer.getPositionX() + 1;
				int newPosY = Assets.entPlayer.getPositionY();
				tickKeyPush("E", newPosX, newPosY);
			}
			Keyboard.setKeyDone();
		}
	}
	
	public void tickKeyPush(String direction, int newPosX, int newPosY)
	{
		if(Game.world.getTileType(newPosX, newPosY)==0 && Game.world.getTileEntity(newPosX, newPosY)=="None")
		{
			walk(direction);
			
			// Temp [jsp]
			Game.testTickActive = true;
			
			if(Game.world.getGridScroll()==true){Game.world.setGridScrollNew(direction);}
		}
		if(Game.world.getTileEntity(newPosX, newPosY)=="Portal" && Game.world.portalType[Game.world.getTileEntityID(getFacingTileX(), getFacingTileY())]=="Collide")
		{
			setBoardNew(Game.world.portalSendBoard[Game.world.getTileEntityID(newPosX, newPosY)], Game.world.portalSendX[Game.world.getTileEntityID(newPosX, newPosY)], Game.world.portalSendY[Game.world.getTileEntityID(newPosX, newPosY)], Game.world.portalSendDirection[Game.world.getTileEntityID(newPosX, newPosY)], Game.world.portalOffsetX[Game.world.getTileEntityID(newPosX, newPosY)], Game.world.portalOffsetY[Game.world.getTileEntityID(newPosX, newPosY)]);
		}
	}
	
	public void tickMovement()
	{
		if(getAction()=="Walk")
		{
			// Each time this is called we might advance to the next frame (based on movement speed)
			setWalkFrameTick();
			
			// Scroll the board if necessary
			if(Game.world.getGridScrollAction()==true && getWalkFrame()==2)
			{
				Game.world.setGridOffsetMove(getDirection());
				Game.world.setGridScrollDone();
			}
			
			// Walking finished
			if(getWalkFrame()>4)
			{
				int walkPosX = getPositionX();
				int walkPosY = getPositionY();
				if(getDirection()=="N"){walkPosY -= 1;}
				if(getDirection()=="E"){walkPosX += 1;}
				if(getDirection()=="S"){walkPosY += 1;}
				if(getDirection()=="W"){walkPosX -= 1;}
				Assets.entPlayer.setPositionX(walkPosX);
				Assets.entPlayer.setPositionY(walkPosY);
				Assets.entPlayer.setAction("Idle");
				Assets.entPlayer.setWalkFrame(0);
				
				// Temp
				Game.testTickActive = false;
				Game.testTickCount = 0;
			}
		}
	}
	
	public static void walk(String direction)
	{
		setAction("Walk");
		setDirection(direction);
		setWalkFrame(1);
		int tileX = Assets.entPlayer.getPositionX();
		int tileY = Assets.entPlayer.getPositionY();
		if(direction=="N"){tileY -= 1;}
		if(direction=="E"){tileX += 1;}
		if(direction=="S"){tileY += 1;}
		if(direction=="W"){tileX -= 1;}
		/*if(Game.world.getTileEntity(tileX, tileY)=="Treasure")
		{
			int ID = Game.world.getTileEntityID(tileX, tileY);
			Game.world.setTreasureFound(ID);
			AudioPlayer.play("Treasure");
		}*/
	}

}