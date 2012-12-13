import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class TopPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TopPanel extends Actor
{
    /**
     * Act - do whatever the TopPanel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage image;
    public int day;
    
    public static final float FONT_SIZE = 20.0f;
    public static final int WIDTH = 220;
    public static final int HEIGHT = 30;
    
    public TopPanel() {
        day = Map.DAY; // start at day 1;
        
        image = new GreenfootImage("opmaak/topPanel.png"); // prepare background image
        Font font = image.getFont();  // get current font
        font = font.deriveFont(FONT_SIZE);  // acolate font size
        image.setFont(font);  // set font
        image.setColor(Color.WHITE);  // make text white
        image.drawString("Dag " + day, 40, 28); // place text
        setImage(image); // set background image
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
