package ap;
import ap.audio.AudioManager;
import ap.audio.AudioPlayer;
import ap.battle.BattleEngine;
import ap.dialogue.Conversation;
import ap.display.Display;
import ap.gfx.Assets;
import ap.gfx.Board;
import ap.gfx.BoardCinematic;
import ap.message.MessagePrompt;
import ap.message.MessageSpeech;
import ap.message.MessageStandard;
import ap.message.MessageTutorial;
import ap.states.DebugState;
import ap.states.StateDevMenu;
import ap.states.GameNewState;
import ap.states.State;
import ap.states.AboutState;
import ap.states.BattleState;
import ap.states.CharacterState;
import ap.states.GameState;
import ap.states.IntroState;
import ap.states.MenuState;
import ap.states.OptionsState;
import ap.states.ShopState;
import ap.states.TitleState;
import ap.states.TutorialState;
import ap.datafiles.FileManager;
import ap.datafiles.ReadFile;
import ap.datafiles.WriteFile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JPanel;

public class Game extends JPanel implements Runnable
{
	private static final long serialVersionUID = 1L;
	public static Display display;
	public String title;
	public int width, height;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	
	// Note: Consider where this should be
	public static boolean chat = false;
	
	// State Management
	private static String boardChange = "none";
	public static String stateChange = "none";
	
	// Development Features
	public static boolean devAccelerateTime = false;
	public static boolean devBoardInfo = false;
	public static boolean devLaunchDebug = false;
	public static boolean devQuickstart = false;
	
	// Session
	public static Session session;
	
	// Audio
	public static AudioManager audio;
	
	// Board Object
	public static Board world;
	
	// Campaign Data
	public static int campaignStage = 0;
	
	// Backpack (consider moving to it's own class?)
	public static int backpackGarnets = 0;
	public static int backpackMushrooms = 0;
	public static int backpackTreasure = 0;
	
	// Test
	public static String playerClass = "";
	
	// States
	private State stateAbout, stateCharacter, stateIntro, stateOptions, stateTitle, stateTutorial;
	private State stateGame, stateGameNew, stateMenu, stateShop;
	private State stateBattle;
	private State stateDebug, stateDevMenu;
	
	// Messages
	public static boolean messageActive = false;
	public static String messageType = "None";
	public static int messageChainRemainder = 0;
	public static String[][] messageChainText = new String[10][4];
	public static MessageStandard messageObjectStandard;
	public static MessagePrompt messageObjectPrompt;
	public static MessageSpeech messageObjectSpeech;
	public static MessageTutorial messageObjectTutorial;
	
	// Battle
	public static BattleEngine battleEngine;
	
	// Conversation
	public static boolean conversationActive = false;
	public static Conversation conversationObject;
	
	// Clock
	public static boolean clockActive = true;
	public static int clockTick = 0;
	private static int clockDay;
	private static int clockMonth;
	private static int clockYear;
	private static int clockHour;
	private static int clockMinute;
	
	// Random Generator
	public static Random random;
	
	// Test
	public static boolean testTickActive = false;
	public static int testTickCount = 0;

	public Game(String title, int width, int height, String append)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		// Random Generator
		random = new Random();
		
		// Append development features
		if(append=="dev1"){this.devLaunchDebug = true;}
		if(append=="quickstart"){this.devQuickstart = true;}
	}
	
	public static void boardChange(String board)
	{
		boardChange = board;
	}
	
	public static void conversationStart(Conversation object)
	{
		conversationActive = true;
		conversationObject = object;
	}
	
	public static int getClock(String element)
	{
		if(element=="Day"){return clockDay;}
		if(element=="Month"){return clockMonth;}
		if(element=="Year"){return clockYear;}
		if(element=="Hour"){return clockHour;}
		if(element=="Minute"){return clockMinute;}
		return 0;
	}
	
	public String getClockDayAsString()
	{
		switch (clockDay)
		{
			case 1:
				return "Monday";
			case 2:
				return "Tuesday";
			case 3:
				return "Wednesday";
			case 4:
				return "Thursday";
			case 5:
				return "Friday";
			case 6:
				return "Saturday";
			case 7:
				return "Sunday";
			default:
				return "Error";
		}
	}
	
	public String getClockMonthAsString()
	{
		switch (clockMonth)
		{
			case 1:
				return "January";
			case 2:
				return "February";
			case 3:
				return "March";
			case 4:
				return "April";
			case 5:
				return "May";
			case 6:
				return "June";
			case 7:
				return "July";
			case 8:
				return "August";
			case 9:
				return "September";
			case 10:
				return "October";
			case 11:
				return "November";
			case 12:
				return "December";
		default:
			return "Error";
		}
	}
	
	private void init()
	{
		// Create Display
		display = new Display(title, width, height);
		
		// Load Resources
		Assets.init();
		initStates();
		initWorld();
		initAudio();
		
		// Development Menu
		if(devLaunchDebug==true){State.setState(stateDebug);}
		
		// Quickstart
		else if(devQuickstart==true){quickstart();}
		
		// Introduction
		else
		{
			audio.playMusic("music1");
			State.setState(stateIntro);
		}
	}
	
	private void initAudio()
	{
		audio = new AudioManager();
	}

	private void initStates()
	{
		stateAbout = new AboutState();
		stateCharacter = new CharacterState();
		stateDebug = new DebugState();
		stateDevMenu = new StateDevMenu();
		stateGame = new GameState();
		stateGameNew = new GameNewState();
		stateIntro = new IntroState();
		stateMenu = new MenuState();
		stateOptions = new OptionsState();
		stateShop = new ShopState();
		stateTitle = new TitleState();
		stateTutorial = new TutorialState();
		
		// Test
		stateBattle = new BattleState();
	}
	
	private void initWorld()
	{
		world = new Board();
		//setClock(1, 1, 1, 6, 0);
		setClock(1, 1, 1, 16, 0);
	}
	
	private void render()
	{
		// Buffer strategy
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		// Graphics start
		g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		// Graphics draw
		if(State.getState() != null)
		{
			State.getState().render(g);
		}

		// Graphics done
		bs.show();
		g.dispose();
	}
	
	public void run()
	{
		// Render speed
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		// Create window
		init();
		
		// Main game loop
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1)
			{
				// Test
				if(testTickActive==true)
				{
					testTickCount += 1;
					String debug1 = "Tick " + testTickCount;
					System.out.println(debug1);
				}
				
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000)
			{
				//System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		// End game
		stop();
	}
	
	public void saveGame() throws IOException
	{
		String file_name = "C:/Users/Jamie/Documents/My Workshop/Autumn Park/Datafiles/Data.txt";
		WriteFile data = new WriteFile(file_name, false);
		data.writeToFile("Hello world");
	}
	
	public static void setClock(int day, int month, int year, int hour, int minute)
	{
		clockDay = day;
		clockMonth = month;
		clockYear =year;
		clockHour = hour;
		clockMinute = minute;
	}
	
	public static void setClockActive(boolean active)
	{
		clockActive = active;
	}
	
	public static void setClockAdvance()
	{
		clockMinute += 1;
		if(clockMinute>60)
		{
			clockHour += 1;
			clockMinute = 0;
			if(clockHour>=24)
			{
				clockDay += 1;
				clockHour = 0;

				// Maximum days in month
				int dayMax = 0;
				if (clockMonth == 4 || clockMonth == 6 || clockMonth == 9 || clockMonth == 11){dayMax = 30;}
				else 
				{
					// Ignoring leap years for now
					if (clockMonth == 2){dayMax = 29;}
					else{dayMax = 31;}
				}
				if(clockDay>dayMax)
				{
					clockMonth += 1;
					clockDay = 1;
					if(clockMonth>12)
					{
						clockYear += 1;
						clockMonth = 1;
					}
				}
			}
		}
	}
	
	public static void setMessage(MessagePrompt message)
	{
		messageActive = true;
		messageType = "Prompt";
		messageObjectPrompt = message; 
	}
	
	public static void setMessage(MessageSpeech message)
	{
		messageActive = true;
		messageType = "Speech";
		messageObjectSpeech = message; 
	}
	
	public static void setMessage(MessageStandard message)
	{
		messageActive = true;
		messageType = "Standard";
		messageObjectStandard = message; 
	}
	
	public static void setMessage(MessageTutorial message)
	{
		messageActive = true;
		messageType = "Tutorial";
		messageObjectTutorial = message; 
	}
	
	public static void setSession(Session newSession)
	{
		session = newSession;
	}
	
	private void tick()
	{
		// Audio
		audio.tick();

		// Change state
		if(State.getStateChange() == "About")
		{
			State.setState(stateAbout);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "Character")
		{
			State.setState(stateCharacter);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "Debug")
		{
			State.setState(stateDebug);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "DevMenu")
		{
			State.setState(stateDevMenu,true);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "Game")
		{
			State.setState(stateGame);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "GameNew")
		{
			State.setState(stateGameNew);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "Menu")
		{
			State.setState(stateMenu);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "Options")
		{
			State.setState(stateOptions);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "Shop")
		{
			State.setState(stateShop);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "Title")
		{
			State.setState(stateTitle);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		if(State.getStateChange() == "Tutorial")
		{
			State.setState(stateTutorial);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		
		// Temp
		if(State.getStateChange() == "Battle")
		{
			State.setState(stateBattle);
			State.setStateChange("");
			Keyboard.setKeyDone();
		}
		
		// Change Board
		if(boardChange!="none")
		{
			world = new Board();
			world.getData(boardChange);
			boardChange = "none";
		}
		
		// Tick state
		if(State.getState() != null)
		{
			State.getState().tick();
		}
	}
	
	public synchronized void start()
	{
		if(running==false)
		{
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public synchronized void stop()
	{
		if(running==true)
		{
			try
			{
				thread.join();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void quickstart()
	{
		Game.playerClass = "Spellweaver";
		State.setState(stateGameNew);
		
		// Temp
		/*BoardCinematic newCinematic = new BoardCinematic();
		newCinematic.setOffsetPos(1, 1);
		newCinematic.setOffsetMove(1, 1, 10);
		newCinematic.renderPlayer = false;
		newCinematic.renderNPCs = false;
		newCinematic.setLogoFrames(5, 400);
		newCinematic.setLogoImage("JharvaVillage");
		newCinematic.setLogoPosition(393, 319);
		newCinematic.logoActive = true;
		newCinematic.setTickMax(600);
		Game.world.setCinematicObject(newCinematic);
		Game.world.setCinematicActive(true);*/
	}

}