package ap.inventory;

public class Inventory
{
	//private static ItemWeapon[ ] weaponCollection = new ItemWeapon[26];
	private static ItemWeapon[ ] weaponCollection;
	private static int weaponCount;
	
	public Inventory()
	{
		weaponCount = 0;
	}
	
	public static void addWeapon(ItemWeapon item)
	{
		weaponCount+=1; 
		weaponCollection[weaponCount] = item;
	}
	
	public static void removeWeapon(int pos)
	{
		// Create a temporary array
		int newCount = weaponCount - 1;
		ItemWeapon[] newCollection = new ItemWeapon[newCount];
		
		// Copy existing items to temporary array
		int oldPos;
		int newPos;
		for(oldPos=1;oldPos<=weaponCount;oldPos+=1)
		{
			newPos = oldPos;
			if(oldPos>pos){newPos = oldPos-1;}
			if(oldPos!=pos){newCollection[newPos] = weaponCollection[oldPos];}
		}
		
		// Replace the old array with the temporary one
		weaponCollection = newCollection;
		weaponCount = newCount;
	}
	
	public static ItemWeapon getWeapon(int pos)
	{
		return weaponCollection[pos];
	}
	
	public static int getWeaponCount()
	{
		return weaponCount;
	}
}