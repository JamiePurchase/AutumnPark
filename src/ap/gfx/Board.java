package ap.gfx;
import ap.Game;
import ap.datafiles.WriteFile;
import ap.entities.BoardNpc;
import ap.entities.BoardScenery;
import ap.entities.NpcCreatureEntity;
import ap.world.JvExterior;
import ap.world.JvGooseberryManor;
import ap.world.JvLaboratoryMain;
import ap.world.JvPlayerBedroom;
import ap.world.JvPlayerHouse;
import ap.world.JvPotionShop;
import ap.world.PyExterior;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Board
{
	// Details
	private static String boardName;
	private static String locationName;
	
	// Grid
	private static int gridWidth;
	private static int gridHeight;
	private static boolean gridScroll = false;
	private static boolean gridScrollAction = false;
	private static String gridScrollDirection;
	private static int gridScrollFrame;
	private static int gridScrollTick;
	private static int gridOffsetX = 0;
	private static int gridOffsetY = 0;
	
	// Cinematic
	private static boolean cinematicActive = false;
	private static BoardCinematic cinematicObject;
	
	// Listeners
	private static boolean listenKey = true;
	private static int listenKeyTick = 0;
	
	// Background
	private static boolean bkgHasImage = false;
	private static BufferedImage bkgImage;
	
	// Tiles
	private static BufferedImage[ ][ ] tileImage = new BufferedImage[101][81];
	private static int[ ][ ] tileType = new int[101][81];
	private static String[ ][ ] tileEntity = new String[101][81];
	private static int[ ][ ] tileEntityID = new int[101][81];
	
	// Timer (scenery remove)
	public int timerSceneryRemoveCount;
	public boolean[] timerSceneryRemoveActive = new boolean[50];
	public int[] timerSceneryRemoveTicks = new int[50];
	public int[] timerSceneryRemoveX = new int[50];
	public int[] timerSceneryRemoveY = new int[50];

	// Timer (tile transform)
	public int timerTileTransformCount;
	public boolean[] timerTileTransformActive = new boolean[50];
	public int[] timerTileTransformTicks = new int[50];
	public int[] timerTileTransformX = new int[50];
	public int[] timerTileTransformY = new int[50];
	public int[] timerTileTransformType = new int[50];
	public BufferedImage[] timerTileTransformImage = new BufferedImage[50];
	
	// Lighting
	private static boolean lightingActive = true;
	private static String lightingStyle;
	
	// NPCs
	public static int npcCount = 0;
	//public static NpcCreatureEntity[] npcObject = new NpcCreatureEntity[10];
	public static BoardNpc[] npcObject = new BoardNpc[10];
	
	// Portals
	public static int portalCount = 0;
	//public static Portal[] = new Portal[10];
	public static String[] portalType = new String[10];
	public static int[] portalPosX = new int[10];
	public static int[] portalPosY = new int[10];
	public static String[] portalSendBoard = new String[10];
	public static String[] portalSendDirection = new String[10];
	public static int[] portalSendX = new int[10];
	public static int[] portalSendY = new int[10];
	public static int[] portalOffsetX = new int[10];
	public static int[] portalOffsetY = new int[10];

	// Scenery
	private static int sceneryCount = 0;
	private static int[] sceneryPosX = new int[50];
	private static int[] sceneryPosY = new int[50];
	public static BoardScenery[] sceneryObject = new BoardScenery[50];
	public static String[] sceneryFile = new String[50];
	
	// Signs
	private static int signCount = 0;
	private static int[] signPosX = new int[50];
	private static int[] signPosY = new int[50];
	private static String[] signHeader = new String[50];
	private static String[] signText = new String[50];
	
	// Elevation
	private static int elevationCount = 0;
	private static int[] elevationPosX = new int[50];
	private static int[] elevationPosY = new int[50];
	private static int[] elevationPosZ = new int[50];
	
	// Footsteps
	private static String[][] footstepFile = new String[101][81];
	
	// Treasure
	private static int treasureCount = 0;
	private static int[] treasureFind = new int[10];
	private static int[] treasurePosX = new int[10];
	private static int[] treasurePosY = new int[10];
	
	public Board()
	{
		
	}
	
	public static void getData(String name)
	{
		if(name=="JvExterior"){JvExterior boardLoader = new JvExterior();}
		if(name=="JvGooseberryManor"){JvGooseberryManor boardLoader = new JvGooseberryManor();}
		if(name=="JvLaboratoryMain"){JvLaboratoryMain boardLoader = new JvLaboratoryMain();}
		if(name=="JvPlayerBedroom"){JvPlayerBedroom boardLoader = new JvPlayerBedroom();}
		if(name=="JvPlayerHouse"){JvPlayerHouse boardLoader = new JvPlayerHouse();}
		if(name=="JvPotionShop"){JvPotionShop boardLoader = new JvPotionShop();}
		if(name=="PyExterior"){PyExterior boardLoader = new PyExterior();}
	}
	
	public static int getElevation(int x, int y)
	{
		for(int e=1;e<=Game.world.elevationCount;e+=1)
		{
			if(Game.world.elevationPosX[e]==x && Game.world.elevationPosY[e]==y)
			{
				return Game.world.elevationPosZ[e];
			}
		}
		return 0;
	}

	public static String getFootstep(int x, int y)
	{
		int rand = Game.random.nextInt(Game.audio.getFootstepVariations(footstepFile[x][y])) + 1;
		return "sfxFootstep" + footstepFile[x][y] + rand;
	}
	
	public static int getGridEdgeE()
	{
		return gridOffsetX + 42;
	}
	
	public static int getGridEdgeN()
	{
		return gridOffsetY;
	}
	
	public static int getGridEdgeS()
	{
		return gridOffsetY + 42;
	}
	
	public static int getGridEdgeW()
	{
		return gridOffsetX;
	}
	
	public static int getGridHeight()
	{
		return gridHeight;
	}
	
	public static int getGridOffsetX()
	{
		return gridOffsetX;
	}
	
	public static int getGridOffsetXMax()
	{
		return gridWidth - 42;
	}
	
	public static int getGridOffsetY()
	{
		return gridOffsetY;
	}
	
	public static int getGridOffsetYMax()
	{
		return gridHeight - 23;
	}
	
	public static boolean getGridScroll()
	{
		return gridScroll;
	}
	
	public static boolean getGridScrollAction()
	{
		return gridScrollAction;
	}
	
	public static String getGridScrollDirection()
	{
		return gridScrollDirection;
	}
	
	public static int getGridScrollFrame()
	{
		return gridScrollFrame;
	}
	
	public static int getGridWidth()
	{
		return gridWidth;
	}
	
	public static boolean getListenKey()
	{
		return listenKey;
	}
	
	public static String getLocation()
	{
		return locationName;
	}
	
	public static boolean getOnScreen(int x, int y)
	{
		if(x>=getGridEdgeW() && x<=getGridEdgeE())
		{
			if(y>=getGridEdgeN() && y<=getGridEdgeS())
			{
				return true;
			}
		}
		return false;
	}
	
	public static String getName()
	{
		return boardName;
	}
	
	public static String getSceneryFile(int id)
	{
		return sceneryFile[id];
	}
	
	public static String getTileEntity(int x, int y)
	{
		return tileEntity[x][y];
	}
	
	public static int getTileEntityID(int x, int y)
	{
		return tileEntityID[x][y];
	}
	
	public static BufferedImage getTileImage(int x, int y)
	{
		return tileImage[x][y];
	}
	
	public static int getTilePortal(int x, int y)
	{
		for(int p=1;p<=Game.world.portalCount;p+=1)
		{
			if(Game.world.portalPosX[p]==x && Game.world.portalPosY[p]==y)
			{
				return p;
			}
		}
		return 0;
	}
	
	public static int getTileScenery(int x, int y)
	{
		for(int s=1;s<=Game.world.sceneryCount;s+=1)
		{
			if(Game.world.sceneryPosX[s]==x && Game.world.sceneryPosY[s]==y)
			{
				return s;
			}
		}
		return 0;
	}
	
	public static int getTileType(int x, int y)
	{
		return tileType[x][y];
	}
	
	public static int getTreasureCount()
	{
		return treasureCount;
	}
	
	public static boolean removeScenery(int x, int y)
	{
		// Check if there is a piece of scenery at this location
		int scnID = getTileScenery(x, y);
		int scnOld;
		if(scnID>0)
		{
			// Shift all scenery objects up the list
			for(scnOld=scnID+1;scnOld<Game.world.sceneryCount;scnOld+=1)
			{
				int scnNew = scnOld - 1;
				sceneryPosX[scnNew] = sceneryPosX[scnOld];
				sceneryPosY[scnNew] = sceneryPosY[scnOld];
				sceneryObject[scnNew] = sceneryObject[scnOld];
				int scnNewX = sceneryPosX[scnNew];
				int scnNewY = sceneryPosY[scnNew];
				tileEntityID[scnNewX][scnNewY] = scnNew;
			}
			// Clear the final scenery object
			scnOld = Game.world.sceneryCount;
			int scnOldX = sceneryPosX[scnOld];
			int scnOldY = sceneryPosY[scnOld];
			tileEntity[scnOldX][scnOldY] = "None";
			tileEntityID[scnOldX][scnOldY] = 0;
			sceneryPosX[scnOld] = 0;
			sceneryPosY[scnOld] = 0;
			sceneryFile[scnOld] = "";
			// Set the new count
			Game.world.sceneryCount = scnOld - 1;
			return true;
		}
		return false;
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderTiles(g);
		if(lightingActive==true){renderLighting(g);}
		renderPlayer(g);
		renderNPCs(g);
		renderTreasure(g);
		// Note: Create an object for settings that the player can modify
		//if(Game.settings.clockRender==true){renderClock(g);}
		renderClock(g);
		if(Game.messageActive==true){renderMessage(g);}
		if(Game.conversationActive==true){Game.conversationObject.render(g);}
		
		// Cinematic
		if(cinematicActive==true){cinematicObject.render(g);}
		
		// Temp
		if(Game.devBoardInfo==true){renderDevInfo(g);}
		
		// Test (should loop through all NPCs and draw those that are on the visible area of the board
		//g.drawImage(Assets.npcAnnaS, 256, 184, null);
	}
	
	public static void renderBackground(Graphics g)
	{
		g.drawImage(Assets.uiGameBorder, 0, 0, null);
		g.setColor(Color.BLACK);
		g.fillRect(11, 16, 1344, 736);
		if(bkgHasImage){g.drawImage(bkgImage, 11, 16, null);}
		// Note: Should the background image be larger than the screen when the board is?
	}
	
	public void renderClock(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(1197, 21, 150, 30);
		g.fillRect(1198, 22, 150, 30);
		g.setColor(Color.WHITE);
		g.fillRect(1196, 20, 150, 30);
		g.setColor(Color.BLACK);
		g.drawRect(1196, 20, 150, 30);
		g.drawRect(1197, 21, 148, 28);
		g.setColor(Color.BLACK);
		g.setFont(Assets.fontDebugStandard);
		String clock = "";
		if(Game.getClock("Hour")<10){clock += "0";}
		clock += Game.getClock("Hour") + ":";
		if(Game.getClock("Minute")<10){clock += "0";}
		clock += Game.getClock("Minute");
		g.drawString(clock, 1230, 45);
	}
	
	public void renderDevInfo(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(1097, 71, 250, 180);
		g.fillRect(1098, 72, 250, 180);
		g.setColor(Color.WHITE);
		g.fillRect(1096, 70, 250, 180);
		g.setColor(Color.BLACK);
		g.drawRect(1096, 70, 250, 180);
		g.drawRect(1097, 71, 248, 178);
		g.setColor(Color.BLACK);
		g.setFont(Assets.fontDebugMini);
		g.drawString("OFS:", 1110, 123);
		g.drawString("POS:", 1110, 153);
		g.drawString("ELV:", 1110, 183);
		g.drawString("POR:", 1110, 213);
		g.drawString("ENT:", 1110, 243);
		g.setFont(Assets.fontDebugStandard);
		g.drawString("Development Info", 1110, 95);
		String offset = "" + Game.world.getGridOffsetX() + ", " + Game.world.getGridOffsetY();
		String posXY = "" + Assets.entPlayer.getPositionX() + ", " + Assets.entPlayer.getPositionY();
		String posZ = "" + getElevation(Assets.entPlayer.getPositionX(), Assets.entPlayer.getPositionY());
		String portal = "none";
		String entity = "none";
		g.drawString(offset, 1170, 125);
		g.drawString(posXY, 1170, 155);
		g.drawString(posZ, 1170, 185);
		g.drawString(portal, 1170, 215);
		g.drawString(entity, 1170, 245);
	}
	
	public void renderLighting(Graphics g)
	{		
		/*if(lightingStyle=="Afternoon"){Drawing.drawImageOpaque(g, Assets.lightBlack, 0, 0, 0.25f);}
		if(lightingStyle=="Night"){Drawing.drawImageOpaque(g, Assets.lightBlack, 0, 0, 0.75f);}*/

		// Temp
		int hour = Game.getClock("Hour");
		int min = Game.getClock("Minute");
		float opacity = 0.00f;
		String debug = "Day: 0.00";
		if(hour<3 || hour>=21)
		{
			Drawing.drawImageOpaque(g, Assets.lightBlack, 0, 0, 0.75f);
			debug = "Night: 0.75f";
		}
		if(hour>=3 && hour<6)
		{
			float minutes = ((hour - 3) * 60) + min;
			float percent = (minutes / 180) * 100; 
			opacity = (float) (0.75 - (0.0075 * percent));
			Drawing.drawImageOpaque(g, Assets.lightBlack, 0, 0, opacity);
			debug = "Morning: " + opacity;
		}
		if(hour>=18 && hour<21)
		{
			float minutes = ((hour - 18) * 60) + min;
			float percent = (minutes / 180) * 100; 
			opacity = (float) (0.0075 * percent);
			Drawing.drawImageOpaque(g, Assets.lightBlack, 0, 0, opacity);
			debug = "Evening: " + opacity;
		}
		//System.out.println(debug);
	}
	
	public void renderMessage(Graphics g)
	{
		if(Game.messageType=="Prompt"){Game.messageObjectPrompt.render(g);}
		if(Game.messageType=="Speech"){Game.messageObjectSpeech.render(g);}
		if(Game.messageType=="Standard"){Game.messageObjectStandard.render(g);}
		if(Game.messageType=="Tutorial"){Game.messageObjectTutorial.render(g);}
	}
	
	public void renderNPCs(Graphics g)
	{
		if(cinematicActive==true)
		{
			if(cinematicObject.renderNPCs==true){renderNPCsAll(g);}
		}
		else{renderNPCsAll(g);}
	}
	
	public void renderNPCsAll(Graphics g)
	{
		for(int x=1;x<=Game.world.npcCount;x+=1)
		{
			// Note: Is the entity idle? What about actions?
			int drawX = ((npcObject[x].positionX - Game.world.getGridOffsetX()) * 32) - 21;
			int drawY = ((npcObject[x].positionY - Game.world.getGridOffsetY()) * 32) - 16;
			g.drawImage(npcObject[x].getImageIdle(npcObject[x].positionD), drawX, drawY, null);
			
			// Debug
			/*String debug = "The npc is positioned at " + npcObject[x].positionX + ", " + npcObject[x].positionY; 
			System.out.println(debug);*/
		}
	}
	
	public void renderPlayer(Graphics g)
	{
		if(cinematicActive==true)
		{
			if(cinematicObject.renderPlayer==true){Assets.entPlayer.render(g);}
		}
		else{Assets.entPlayer.render(g);}
	}
	
	public void renderTile(Graphics g, int x, int y)
	{
		int drawX = (x * 32) - 21 - (gridOffsetX * 32);
		int drawY = (y * 32) - 16 - (gridOffsetY * 32);
		
		// Debug
		/*String debug1 = "renderTile from board coords " + x + "," + y;
		String debug2 = "drawX = " + drawX + " and drawY = " + drawY;
		System.out.println(debug1);
		System.out.println(debug2);*/
		//g.drawImage(tileImage[x][y], drawX, drawY, null);
	}
	
	public void renderTileAt(Graphics g, int tileX, int tileY, int posX, int posY)
	{
		renderTileAt(g, tileX, tileY, posX, posY, "");
	}
	
	public void renderTileAt(Graphics g, int tileX, int tileY, int posX, int posY, String scrollDirection)
	{
		// Temp
		/*float scrollTick = (float) Game.testTickCount;
		float scrollPercent = (Game.testTickCount / 43) * 100;
		float scrollFrame = (32 / 100) * scrollPercent;*/
		
		// Temp
		int scrollFrame = 0;
		
		// Debug
		if(gridScrollAction==true)
		{
			/*String debug1 = "Ticks = " + Game.testTickCount + " / " + scrollPercent + "% of 43";
			String debug2 = "which is " + scrollFrame + "% of 32";
			System.out.println(debug1);
			System.out.println(debug2);*/
		
			// Temp
			if(Game.testTickCount>=5){scrollFrame += 4;}
			if(Game.testTickCount>=10){scrollFrame += 4;}
			if(Game.testTickCount>=15){scrollFrame += 4;}
			if(Game.testTickCount>=20){scrollFrame += 4;}
			if(Game.testTickCount>=25){scrollFrame += 4;}
			if(Game.testTickCount>=30){scrollFrame += 4;}
			if(Game.testTickCount>=35){scrollFrame += 4;}
			if(Game.testTickCount>=40){scrollFrame += 4;}

			String debug1 = "scrollFrame = " + scrollFrame;
			System.out.println(debug1);
		}
		
		int drawX = (posX * 32) - 21;
		int drawY = (posY * 32) - 12;
		if(scrollDirection=="N"){drawY-=scrollFrame;}
		if(scrollDirection=="E"){drawX+=scrollFrame;}
		if(scrollDirection=="S"){drawY+=scrollFrame;}
		if(scrollDirection=="W"){drawX-=scrollFrame;}
		g.drawImage(tileImage[tileX][tileY], drawX, drawY, null);
		
		// Debug
		/*String debug1 = "scrollFrame = " + scrollFrame;
		System.out.println(debug1);*/
	}
	
	public void renderTiles(Graphics g)
	{
		// Defaults for standard drawing
		int gridCols = 42;
		int gridRows = 23;
		int gridOffX = gridOffsetX;
		int gridOffY = gridOffsetY;
		
		// Adjustments for movement
		if(gridScrollAction==true)
		{
			if(gridScrollDirection=="N")
			{
				gridRows += 1;
				gridOffY -= 1;
			}
			if(gridScrollDirection=="E")
			{
				gridCols += 1;
				gridOffX += 1;
			}
			if(gridScrollDirection=="S")
			{
				gridRows += 1;
				gridOffY += 1;
			}
			if(gridScrollDirection=="W")
			{
				gridCols += 1;
				gridOffX -= 1;
			}
		}

		// Draw all tiles that are on the screen
		for(int x=1;x<=gridCols;x+=1)
		{
			for(int y=1;y<=gridRows;y+=1)
			{
				int tileX = x + gridOffX;
				int tileY = y + gridOffY;
				if(cinematicActive==true)
				{
					tileX = x + cinematicObject.getOffsetPosX();
					tileY = y + cinematicObject.getOffsetPosY();
				}
				if(gridScrollAction==true){renderTileAt(g, tileX, tileY, x, y, gridScrollDirection);}
				else{renderTileAt(g, tileX, tileY, x, y);}
			}
		}
		
		// Redraw the border to tidy edges
		//if(gridScrollAction==true)
		//{
			g.drawImage(Assets.uiGameBorderW2, 0, 0, null);
			g.drawImage(Assets.uiGameBorderE2, 1339, 0, null);
			g.drawImage(Assets.uiGameBorderN2, 0, 0, null);
			g.drawImage(Assets.uiGameBorderS2, 0, 736, null);
		//}
	}
	
	public static void renderTreasure(Graphics g)
	{
		for(int treasure=1;treasure<=getTreasureCount();treasure+=1)
		{
			if(treasureFind[treasure]<1)
			{
				int posX = 32 * treasurePosX[treasure] - 32;
				int posY = 32 * treasurePosY[treasure] - 32;
				g.drawImage(Assets.itemChest1, posX, posY, null);
			}
		}
	}
	
	public static void setBackground()
	{
		bkgHasImage = false;
	}
	
	public static void setBackground(BufferedImage image)
	{
		bkgHasImage = true;
		bkgImage = image;
	}
	
	public static void setCinematicActive(boolean active)
	{
		cinematicActive = active;
	}
	
	public static void setCinematicObject(BoardCinematic newObject)
	{
		cinematicObject = newObject;
	}
	
	public static void setElevation(int posX, int posY, int posZ)
	{
		elevationCount += 1;
		elevationPosX[elevationCount] = posX;
		elevationPosY[elevationCount] = posY;
		elevationPosZ[elevationCount] = posZ;
	}
	
	public static void setFootstep(int posX, int posY, String file)
	{
		footstepFile[posX][posY] = file;
	}
	
	public static void setFootstepInit(String file)
	{
		for(int x=1;x<=gridWidth;x+=1)
		{
			for(int y=1;y<=gridHeight;y+=1)
			{
				footstepFile[x][y] = file;
			}
		}
	}
	
	public static void setGridHeight(int height)
	{
		gridHeight = height;
	}
	
	public static void setGridOffset()
	{
		if(gridWidth<=42 && gridHeight<=23){gridScroll=false;}
		else
		{
			gridScroll = true;
			int offsetMaxX = gridWidth - 42;
			int offsetX = Assets.entPlayer.getPositionX() - 21;
			if(offsetX<0){offsetX=0;}
			if(offsetX>offsetMaxX){offsetX=offsetMaxX;}
			int offsetMaxY = gridHeight - 23;
			int offsetY = Assets.entPlayer.getPositionY() - 12;
			if(offsetY<0){offsetY=0;}
			if(offsetY>offsetMaxY){offsetY=offsetMaxY;}
			setGridOffset(offsetX,offsetY);
		}
	}
	
	public static void setGridOffset(int x, int y)
	{
		setGridOffsetX(x);
		setGridOffsetY(y);
	}
	
	public static void setGridOffsetMove(String direction)
	{
		if(direction=="N" && gridOffsetY>0){gridOffsetY-=1;}
		if(direction=="E" && gridOffsetX<getGridOffsetXMax()){gridOffsetX+=1;}
		if(direction=="S" && gridOffsetY<getGridOffsetYMax()){gridOffsetY+=1;}
		if(direction=="W" && gridOffsetX>0){gridOffsetX-=1;}
	}
	
	public static void setGridOffsetX(int x)
	{
		gridOffsetX = x;
	}
	
	public static void setGridOffsetY(int y)
	{
		gridOffsetY = y;
	}
	
	public static void setGridScroll(boolean scroll)
	{
		gridScroll = scroll;
	}
	
	public static void setGridScrollDone()
	{
		gridScrollAction = false;
		gridScrollDirection = "";
		gridScrollFrame = 0;
		gridScrollTick = 0;
	}
	
	public static void setGridScrollNew(String direction)
	{
		gridScrollAction = true;
		gridScrollDirection = direction;
		gridScrollFrame = 1;
		gridScrollTick = 0;
	}
	
	public static void setGridWidth(int width)
	{
		gridWidth = width;
	}
	
	public static void setListenKey(boolean enable)
	{
		listenKey = enable;
	}
	
	public static void setListenKey(boolean enable, int tick)
	{
		listenKey = enable;
		listenKeyTick = tick;
	}
	
	public static void setLocation(String location)
	{
		locationName = location;
	}
	
	public static void setName(String name)
	{
		boardName = name;
	}
	
	//public static void setNpc(NpcCreatureEntity object)
	public static int setNpc(BoardNpc object)
	{
		npcCount += 1;
		npcObject[npcCount] = object;
		tileEntity[object.positionX][object.positionY] = "NPC";
		tileEntityID[object.positionX][object.positionY] = npcCount;
		
		// Debug
		/*String debug = "Adding an npc to the board at " + object.positionX + ", " + object.positionY;
		System.out.println(debug);*/
		
		return npcCount;
	}
	
	public static void setPortal(String type, int posX, int posY, String sendBoard, int sendX, int sendY, String sendDirection)
	{
		setPortal(type, posX, posY, sendBoard, sendX, sendY, sendDirection, 0, 0);
	}
	
	public static void setPortal(String type, int posX, int posY, String sendBoard, int sendX, int sendY, String sendDirection, int offsetX, int offsetY)
	{
		portalCount += 1;
		portalType[portalCount] = type;
		portalPosX[portalCount] = posX;
		portalPosY[portalCount] = posY;
		portalSendBoard[portalCount] = sendBoard;
		portalSendDirection[portalCount] = sendDirection;
		portalSendX[portalCount] = sendX;
		portalSendY[portalCount] = sendY;
		portalOffsetX[portalCount] = offsetX;
		portalOffsetY[portalCount] = offsetY;
		tileEntity[posX][posY] = "Portal";
		tileEntityID[posX][posY] = portalCount;
	}
	
	public static void setScenery(int posX, int posY, String file)
	{
		// OLD
		sceneryCount += 1;
		sceneryPosX[sceneryCount] = posX;
		sceneryPosY[sceneryCount] = posY;
		sceneryFile[sceneryCount] = file;
		tileEntity[posX][posY] = "Scenery";
		tileEntityID[posX][posY] = sceneryCount;
	}
	
	public static int setScenery(BoardScenery object)
	{
		// NEW
		sceneryCount += 1;
		sceneryPosX[sceneryCount] = object.positionX;
		sceneryPosY[sceneryCount] = object.positionY;
		sceneryObject[sceneryCount] = object;
		tileEntity[object.positionX][object.positionY] = "Scenery";
		tileEntityID[object.positionX][object.positionY] = sceneryCount;
		return sceneryCount;
	}
	
	public static void setSign(int posX, int posY, String header, String text)
	{
		signCount += 1;
		signPosX[signCount] = posX;
		signPosY[signCount] = posY;
		signHeader[signCount] = header;
		signText[signCount] = text;
	}
	
	public static void setTile(int x, int y, String image, int type)
	{
		tileImage[x][y] = BoardTiles.getTileFile(image);
		tileType[x][y] = type;
	}
	
	public static void setTile(int x, int y, BufferedImage image)
	{
		tileImage[x][y] = image;
	}
	
	public static void setTile(int x, int y, BufferedImage image, int type)
	{
		tileImage[x][y] = image;
		tileType[x][y] = type;
	}
	
	public int setTimerSceneryRemove(int x, int y, int ticks)
	{
		timerSceneryRemoveCount+=1;
		timerSceneryRemoveActive[timerSceneryRemoveCount] = true;
		timerSceneryRemoveTicks[timerSceneryRemoveCount] = ticks;
		timerSceneryRemoveX[timerSceneryRemoveCount] = x;
		timerSceneryRemoveY[timerSceneryRemoveCount] = y;
		return timerSceneryRemoveCount;
	}
	
	public int setTimerTileTransform(int x, int y, int ticks, BufferedImage image, int type)
	{
		timerTileTransformCount+=1;
		timerTileTransformActive[timerTileTransformCount] = true;
		timerTileTransformTicks[timerTileTransformCount] = ticks;
		timerTileTransformX[timerTileTransformCount] = x;
		timerTileTransformY[timerTileTransformCount] = y;
		timerTileTransformType[timerTileTransformCount] = type;
		timerTileTransformImage[timerTileTransformCount] = image;
		return timerTileTransformCount;
	}
	
	public static void setTreasure(int x, int y)
	{
		treasureCount += 1;
		treasureFind[treasureCount] = 0;
		treasurePosX[treasureCount] = x;
		treasurePosY[treasureCount] = y;
		tileEntity[x][y] = "Treasure";
		tileEntityID[x][y] = treasureCount;
	}
	
	public static void setTreasureFound(int ID)
	{
		treasureFind[ID] = 1;
		int posX = treasurePosX[ID];
		int posY = treasurePosY[ID];
		tileEntity[posX][posY] = "None";
		tileEntityID[posX][posY] = 0;
		Game.backpackTreasure += 1;
	}
	
	public void tick()
	{
		// Clock
		if(Game.clockActive==true){tickClock();}
		
		// Cinematic
		if(cinematicActive==true){cinematicObject.tick();}
		
		// Conversation
		if(Game.conversationActive==true)
		{
			Game.conversationObject.tick();
		}
		
		// Board Scrolling
		if(gridScrollAction==true)
		{
			gridScrollTick+=1;
			int gridScrollTickMax = 10;
			if(Assets.entPlayer.getWalkSpeed()==2){gridScrollTickMax = 5;}
			if(gridScrollTick>=gridScrollTickMax)
			{
				gridScrollFrame+=1;
				if(gridScrollFrame==4)
				{
					gridScrollAction = false;
					Game.world.gridScrollDirection = "";
					Game.world.gridScrollFrame = 0;
				}
			}
		}
		
		// Timers
		tickTimers();
		
		// Player
		Assets.entPlayer.tick();
	}
	
	public void tickClock()
	{
		// How fast minutes go by
		int tickMinute = 600;
		if(Game.devAccelerateTime==true){tickMinute=2;}
		
		// Advance time
		Game.clockTick += 1;
		if(Game.clockTick>=tickMinute)
		{
			Game.setClockAdvance();
			Game.clockTick = 0;
		}
	}
	
	public void tickTimers()
	{
		if(listenKeyTick>0){tickTimersListen();}
		tickTimersSceneryRemove();
		tickTimersTileTransform();
	}
	
	public void tickTimersListen()
	{
		listenKeyTick-=1;
		if(listenKeyTick==0)
		{
			listenKey = true;
		}
	}
	
	public void tickTimersSceneryRemove()
	{
		for(int x=1;x<=Game.world.timerSceneryRemoveCount;x+=1)
		{
			if(Game.world.timerSceneryRemoveActive[x]==true)
			{
				Game.world.timerSceneryRemoveTicks[x]-=1;
				if(Game.world.timerSceneryRemoveTicks[x]<1)
				{
					Game.world.removeScenery(Game.world.timerSceneryRemoveX[x], Game.world.timerSceneryRemoveX[x]);
					Game.world.timerSceneryRemoveActive[x] = false;
				}
			}
		}
	}
	
	public void tickTimersTileTransform()
	{
		for(int x=1;x<=Game.world.timerTileTransformCount;x+=1)
		{
			if(Game.world.timerTileTransformActive[x]==true)
			{
				Game.world.timerTileTransformTicks[x]-=1;
				if(Game.world.timerTileTransformTicks[x]<1)
				{
					Game.world.setTile(Game.world.timerTileTransformX[x], Game.world.timerTileTransformY[x], Game.world.timerTileTransformImage[x], Game.world.timerTileTransformType[x]);
					Game.world.timerTileTransformActive[x] = false;
				}
			}
		}
	}
	
	public static void tileInit(String fill, int type)
	{
		for(int x=1;x<=gridWidth;x+=1)
		{
			for(int y=1;y<=gridHeight;y+=1)
			{
				tileEntity[x][y] = "None";
				tileEntityID[x][y] = 0;
				tileImage[x][y] = BoardTiles.getTileFile(fill);
				tileType[x][y] = type;
			}
		}
		
		// Debug
		/*String debug1 = "tileInit(" + fill + ", " + type + ")";
		String debug2 = "gridWidth = " + gridWidth + " and gridHeight = " + gridHeight;
		String debug3 = "image = " + BoardTiles.getTileFile(fill);
		System.out.println(debug1);
		System.out.println(debug2);
		System.out.println(debug3);*/
	}
	
	public static void tileInit(BufferedImage image, int type)
	{
		for(int x=1;x<=gridWidth;x+=1)
		{
			for(int y=1;y<=gridHeight;y+=1)
			{
				tileEntity[x][y] = "None";
				tileEntityID[x][y] = 0;
				tileImage[x][y] = image;
				tileType[x][y] = type;
			}
		}
		
		// Debug
		/*String debug1 = "tileInit(" + image + ", " + type + ")";
		String debug2 = "gridWidth = " + gridWidth + " and gridHeight = " + gridHeight;
		System.out.println(debug1);
		System.out.println(debug2);*/
	}

}