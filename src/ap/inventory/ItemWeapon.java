package ap.inventory;

public class ItemWeapon extends Item
{
	public static int weaponCondition;
	public static int weaponDamage;
	public static String weaponElement;
	public static String weaponType;
	
	public ItemWeapon(String template)
	{
		// Load from template?
	}
	
	public static int getWeaponCondition()
	{
		return weaponCondition;
	}
	
	public static int getWeaponDamage()
	{
		return weaponDamage;
	}
	
	public static String getWeaponElement()
	{
		return weaponElement;
	}
	
	public static String getWeaponType()
	{
		return weaponType;
	}
	
	public static void setWeaponCondition(int newCondition)
	{
		weaponCondition = newCondition;
	}
	
	public static void setWeaponDamage(int newDamage)
	{
		weaponDamage = newDamage;
	}
	
	public static void setWeaponElement(String newElement)
	{
		weaponElement = newElement;
	}
	
	public static void setWeaponType(String newType)
	{
		weaponType = newType;
	}

}