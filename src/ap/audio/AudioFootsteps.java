package ap.audio;

public class AudioFootsteps
{
	public AudioFootsteps()
	{
		
	}
	
	public int getVariations(String file)
	{
		if(file=="Grass"){return 2;}
		if(file=="Wood"){return 2;}
		return 0;
	}
}