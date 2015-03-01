package ap;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener
{
    private static int mousePressed = 0;
    private static MouseEvent mousePressedEvent;
    private static int mousePressedPosX = 0;
    private static int mousePressedPosY = 0;
    
    public static int getMousePressed()
    {
    	return mousePressed;
    }
    
    public static MouseEvent getMousePressedEvent()
    {
    	return mousePressedEvent;
    }
    
    public static int getMousePressedPosX()
    {
    	return mousePressedPosX;
    }
    
    public static int getMousePressedPosY()
    {
    	return mousePressedPosY;
    }
    
   public void mouseClicked(MouseEvent e)
   {
	   mousePressed = 1;
	   mousePressedEvent = e;
	   mousePressedPosX = e.getX();
	   mousePressedPosY = e.getY();
   }
    
   public void mouseEntered(MouseEvent e)
   {
       //
   }
    
   public void mouseExited(MouseEvent e)
   {
       //
   }
	
    public void mousePressed(MouseEvent e)
    {
    	//
    }
     
    public void mouseReleased(MouseEvent e)
    {
        //
    }
    
    public static void setMousePressedDone()
    {
    	mousePressed = 0;
    }
}
