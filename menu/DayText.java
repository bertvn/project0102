import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class ScoreTextfield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DayText extends Actor
{
    private GreenfootImage image;
    private Font font;
    private Color color;
    private int day;

    private final float FONT_SIZE = 20.0f;
    private final int WIDTH = 220;
    private final int HEIGHT = 30;
    
    public DayText() {       
       makeImage(Map.DAY);
    }
    
    public void makeImage(int day)   {  
        image = new GreenfootImage("opmaak/topPanel.png");  // prepare image
        image.setColor(new Color(176, 176, 176)); // set color of image
        image.setColor(Color.WHITE);   // set color of text
        font = image.getFont();  // get current font
        font = font.deriveFont(FONT_SIZE);  // set font size
        image.setFont(font);   // set font 
        image.setColor(Color.BLACK);  // set font color
        image.drawString("Dag" + day, 4, 22);  // place text
        setImage(image);  // place image
    }  
    /**
     * Act - do whatever the ScoreTextfield wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
