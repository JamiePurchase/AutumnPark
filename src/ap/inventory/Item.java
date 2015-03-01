package ap.inventory;

import java.awt.image.BufferedImage;

public abstract class Item
{
	private static BufferedImage icon;
	private static String name;
	private static String type;
	private static int value;
	
	public Item()
	{

	}
	
	public static BufferedImage getIcon()
	{
		return icon;
	}
	
	public static String getName()
	{
		return name;
	}
	
	public static String getType()
	{
		return type;
	}
	
	public static int getValue()
	{
		return value;
	}
	
	public static void setIcon(BufferedImage newIcon)
	{
		icon = newIcon;
	}
	
	public static void setName(String newName)
	{
		name = newName;
	}
	
	public static void setType(String newType)
	{
		type = newType;
	}
	
	public static void setValue(int newValue)
	{
		value = newValue;
	}

}