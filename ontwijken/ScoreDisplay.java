import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;
/**
 * Write a description of class ScoreDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreDisplay extends Actor
{
    /**
     * Act - do whatever the ScoreDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage image;
    private Font font;
    private Color color;
    private int score = 0;
    
    private final float FONT_SIZE = 20.0f;
    private final int WIDTH = 108;
    private final int HEIGHT = 30;
    
    
    public ScoreDisplay(){
        
        updateScore();
    }
    
    public void act() 
    {
        // Add your action code here.
        WorldWorker ww = (WorldWorker) getWorld();
        score = ww.getScore();
        updateScore();
    }    
    
    public void updateScore(){
        WorldWorker ww = (WorldWorker) getWorld();
        image = new GreenfootImage(WIDTH, HEIGHT);  // prepare image
        image.setColor(new Color(176, 176, 176)); // set color
        image.fill(); // fill with current color
        image.setColor(Color.WHITE);  // reset col9or
        image.fillRect(2, 2, image.getWidth() -4, image.getHeight() -4);  // fill rectangle with color set
        font = image.getFont();  // get current font
        font = font.deriveFont(FONT_SIZE);  // set font size
        image.setFont(font);  // set font
        image.setColor(Color.BLACK);  // set font color
        image.drawString("" + score, 4, 22);   // place text
        setImage(image); 
        
    }
    
}
