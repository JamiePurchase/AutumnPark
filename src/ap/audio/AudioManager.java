package ap.audio;

public class AudioManager
{
	private static boolean active = true;
	private static AudioFootsteps footstepVariations;
	private static boolean musicActive = false;
	private static String musicFile;
	private static boolean soundActive = false;
	private static String soundFile;
	private static int soundTick;
	private static int volume = 100;

	public AudioManager()
	{
		AudioPlayer.init();
		initFootsteps();
		initMusic();
		initSounds();
	}
	
	public int getFootstepVariations(String file)
	{
		return footstepVariations.getVariations(file);
	}

	public boolean getMusicActive()
	{
		return musicActive;
	}
	
	public boolean getSoundActive()
	{
		return soundActive;
	}
	
	public void initFootsteps()
	{
		footstepVariations = new AudioFootsteps();
		AudioPlayer.load("/sounds/footstepGrass1.wav", "sfxFootstepGrass1");
		AudioPlayer.load("/sounds/footstepGrass2.wav", "sfxFootstepGrass2");
		AudioPlayer.load("/sounds/footstepWood1.wav", "sfxFootstepWood1");
		AudioPlayer.load("/sounds/footstepWood2.wav", "sfxFootstepWood2");
	}
	
	public void initMusic()
	{
		AudioPlayer.load("/music/bgm1.wav", "music1");
		AudioPlayer.load("/music/bgm2.wav", "music2");
	}
	
	public void initSounds()
	{
		// Note: Do we need these?
		AudioPlayer.load("/sounds/collectGarnet.wav", "Garnet");
		AudioPlayer.load("/sounds/collectMushroom.wav", "Mushroom");
		AudioPlayer.load("/sounds/collectTreasure.wav", "Treasure");
	}
	
	public void playMusic(String music)
	{
		AudioPlayer.play(music);
		musicActive = true;
		musicFile = music;
	}
	
	public void playSound(String sound)
	{
		AudioPlayer.play(sound);
		soundActive = true;
		soundFile = sound;
		soundTick = 0;
	}
	
	public void setVolume(int newVolume)
	{
		volume = newVolume;
		if(newVolume<1){active = false;}
		else{active = true;}
	}
	
	public void stopMusic()
	{
		AudioPlayer.stop(musicFile);
		musicActive = false;
		musicFile = "";
	}
	
	public void stopSound()
	{
		//AudioPlayer.stop(soundFile);
		soundActive = false;
		soundFile = "";
	}
	
	public void tick()
	{
		if(getSoundActive())
		{
			soundTick += 1;
			//if(soundTick>1){stopSound();}
		}
	}
}