package ap.gfx;

import java.awt.image.BufferedImage;

public class BoardTiles
{
	public static BufferedImage getTileFile(String image)
	{
		if(image=="Grass"){return Assets.txtGrass;}
		if(image=="Tree"){return Assets.txtTree1a;}
		if(image=="TreeB"){return Assets.txtTree1b;}
		if(image=="TreeC"){return Assets.txtTree1c;}
		if(image=="Shrub"){return Assets.txtTree2a;}
		if(image=="ShrubB"){return Assets.txtTree2b;}
		if(image=="TreesL"){return Assets.txtTree3aL;}
		if(image=="TreesR"){return Assets.txtTree3aR;}
		if(image=="TreesBL"){return Assets.txtTree3bL;}
		if(image=="TreesBR"){return Assets.txtTree3bR;}
		if(image=="TreesCL"){return Assets.txtTree4aL;}
		if(image=="TreesCR"){return Assets.txtTree4aR;}
		if(image=="TreesDL"){return Assets.txtTree5aL;}
		if(image=="TreesDR"){return Assets.txtTree5aR;}
		if(image=="Fence1L"){return Assets.txtFence1L;}
		if(image=="Fence1M"){return Assets.txtFence1M;}
		if(image=="Fence1MS"){return Assets.txtFence1MS;}
		if(image=="Fence1R"){return Assets.txtFence1R;}
		if(image=="Tree6TL"){return Assets.txtTree6TL;}
		if(image=="Tree6TR"){return Assets.txtTree6TR;}
		if(image=="Tree6BL"){return Assets.txtTree6BL;}
		if(image=="Tree6BR"){return Assets.txtTree6BR;}
		if(image=="Tree7aT"){return Assets.txtTree7aT;}
		if(image=="Tree7aB"){return Assets.txtTree7aB;}
		if(image=="Tree7bT"){return Assets.txtTree7bT;}
		if(image=="Tree7bB"){return Assets.txtTree7bB;}
		return Assets.txtGrass;
	}
}