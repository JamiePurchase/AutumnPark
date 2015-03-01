package ap.world;
import ap.Game;
import ap.entities.NpcCreatureEntity;
import ap.gfx.Assets;

public class PyExterior
{
	
	public PyExterior()
	{
		// Data
		Game.world.setName("PyExterior");
		Game.world.setLocation("Python City");
		Game.world.setGridScroll(true);
		
		// Dimensions
		Game.world.setGridWidth(100);
		Game.world.setGridHeight(80);
		
		// Background
		Game.world.setBackground();
		
		// Tiles
		Game.world.tileInit(Assets.tlsPythonCity[0], 0);
		Game.world.setTile(71, 33, Assets.tlsPythonCity[1], 1);
		Game.world.setTile(72, 33, Assets.tlsPythonCity[2], 1);
		Game.world.setTile(73, 33, Assets.tlsPythonCity[2], 1);
		Game.world.setTile(74, 33, Assets.tlsPythonCity[2], 1);
		Game.world.setTile(75, 33, Assets.tlsPythonCity[2], 1);
		Game.world.setTile(76, 33, Assets.tlsPythonCity[2], 1);
		Game.world.setTile(77, 33, Assets.tlsPythonCity[2], 1);
		Game.world.setTile(78, 33, Assets.tlsPythonCity[7], 1);
		Game.world.setTile(71, 34, Assets.tlsPythonCity[17], 1);
		Game.world.setTile(72, 34, Assets.tlsPythonCity[18], 1);
		Game.world.setTile(73, 34, Assets.tlsPythonCity[18], 1);
		Game.world.setTile(74, 34, Assets.tlsPythonCity[18], 1);
		Game.world.setTile(75, 34, Assets.tlsPythonCity[18], 1);
		Game.world.setTile(76, 34, Assets.tlsPythonCity[18], 1);
		Game.world.setTile(77, 34, Assets.tlsPythonCity[18], 1);
		Game.world.setTile(78, 34, Assets.tlsPythonCity[23], 1);
		Game.world.setTile(71, 35, Assets.tlsPythonCity[25], 1);
		Game.world.setTile(72, 35, Assets.tlsPythonCity[27], 1);
		Game.world.setTile(73, 35, Assets.tlsPythonCity[27], 1);
		Game.world.setTile(74, 35, Assets.tlsPythonCity[27], 1);
		Game.world.setTile(75, 35, Assets.tlsPythonCity[27], 1);
		Game.world.setTile(76, 35, Assets.tlsPythonCity[27], 1);
		Game.world.setTile(77, 35, Assets.tlsPythonCity[27], 1);
		Game.world.setTile(78, 35, Assets.tlsPythonCity[31], 1);
		Game.world.setTile(69, 36, Assets.tlsPythonCity[54], 1);
		Game.world.setTile(70, 36, Assets.tlsPythonCity[43], 1);
		Game.world.setTile(71, 36, Assets.tlsPythonCity[52], 1);
		Game.world.setTile(72, 36, Assets.tlsPythonCity[34], 1);
		Game.world.setTile(73, 36, Assets.tlsPythonCity[34], 1);
		Game.world.setTile(74, 36, Assets.tlsPythonCity[35], 1);
		Game.world.setTile(75, 36, Assets.tlsPythonCity[34], 1);
		Game.world.setTile(76, 36, Assets.tlsPythonCity[34], 1);
		Game.world.setTile(77, 36, Assets.tlsPythonCity[34], 1);
		Game.world.setTile(78, 36, Assets.tlsPythonCity[39], 1);
		Game.world.setTile(69, 37, Assets.tlsPythonCity[62], 1);
		Game.world.setTile(82, 37, Assets.tlsPythonCity[63], 1);
		Game.world.setTile(69, 38, Assets.tlsPythonCity[62], 1);
		Game.world.setTile(82, 38, Assets.tlsPythonCity[63], 1);
		Game.world.setTile(41, 39, Assets.tlsPythonCity[1], 1);
		Game.world.setTile(42, 39, Assets.tlsPythonCity[2], 1);
		Game.world.setTile(43, 39, Assets.tlsPythonCity[2], 1);
		Game.world.setTile(44, 39, Assets.tlsPythonCity[7], 1);
		Game.world.setTile(49, 39, Assets.tlsPythonCity[1], 1);
		Game.world.setTile(50, 39, Assets.tlsPythonCity[2], 1);
		Game.world.setTile(51, 39, Assets.tlsPythonCity[2], 1);
		Game.world.setTile(52, 39, Assets.tlsPythonCity[7], 1);
		Game.world.setTile(69, 39, Assets.tlsPythonCity[62], 1);
		Game.world.setTile(82, 39, Assets.tlsPythonCity[63], 1);
		Game.world.setTile(41, 40, Assets.tlsPythonCity[17], 1);
		Game.world.setTile(42, 40, Assets.tlsPythonCity[18], 1);
		Game.world.setTile(43, 40, Assets.tlsPythonCity[18], 1);
		Game.world.setTile(44, 40, Assets.tlsPythonCity[23], 1);
		Game.world.setTile(49, 40, Assets.tlsPythonCity[17], 1);
		Game.world.setTile(50, 40, Assets.tlsPythonCity[18], 1);
		Game.world.setTile(51, 40, Assets.tlsPythonCity[18], 1);
		Game.world.setTile(52, 40, Assets.tlsPythonCity[23], 1);
		Game.world.setTile(69, 40, Assets.tlsPythonCity[70], 1);
		Game.world.setTile(70, 40, Assets.tlsPythonCity[43], 1);
		Game.world.setTile(71, 40, Assets.tlsPythonCity[43], 1);
		Game.world.setTile(72, 40, Assets.tlsPythonCity[47], 1);
		Game.world.setTile(77, 40, Assets.tlsPythonCity[42], 1);
		Game.world.setTile(78, 40, Assets.tlsPythonCity[43], 1);
		Game.world.setTile(79, 40, Assets.tlsPythonCity[43], 1);
		Game.world.setTile(80, 40, Assets.tlsPythonCity[43], 1);
		Game.world.setTile(81, 40, Assets.tlsPythonCity[43], 1);
		Game.world.setTile(82, 40, Assets.tlsPythonCity[71], 1);
		Game.world.setTile(41, 41, Assets.tlsPythonCity[25], 1);
		Game.world.setTile(42, 41, Assets.tlsPythonCity[27], 1);
		Game.world.setTile(43, 41, Assets.tlsPythonCity[27], 1);
		Game.world.setTile(44, 41, Assets.tlsPythonCity[31], 1);
		Game.world.setTile(49, 41, Assets.tlsPythonCity[25], 1);
		Game.world.setTile(50, 41, Assets.tlsPythonCity[27], 1);
		Game.world.setTile(51, 41, Assets.tlsPythonCity[27], 1);
		Game.world.setTile(52, 41, Assets.tlsPythonCity[31], 1);
		Game.world.setTile(41, 42, Assets.tlsPythonCity[33], 1);
		Game.world.setTile(42, 42, Assets.tlsPythonCity[35], 1);
		Game.world.setTile(43, 42, Assets.tlsPythonCity[34], 1);
		Game.world.setTile(44, 42, Assets.tlsPythonCity[39], 1);
		Game.world.setTile(49, 42, Assets.tlsPythonCity[33], 1);
		Game.world.setTile(50, 42, Assets.tlsPythonCity[35], 1);
		Game.world.setTile(51, 42, Assets.tlsPythonCity[34], 1);
		Game.world.setTile(52, 42, Assets.tlsPythonCity[39], 1);
		
		// Portals
		//Game.world.setPortal("Interact", 50, 42, "JvPlayerHouse", 21, 18, "N");
		//Game.world.setPortal("Interact", 74, 36, "JvLaboratoryMain", 19, 18, "N");
	}
}