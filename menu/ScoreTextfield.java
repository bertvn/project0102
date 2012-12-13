import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class ScoreTextfield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreTextfield extends Actor
{
    private GreenfootImage image;
    private Font font;
    private Color color;
    private int score;

    private final float FONT_SIZE = 20.0f;
    private final int WIDTH = 220;
    private final int HEIGHT = 30;
    
    public ScoreTextfield() {       
        
       score = Score.score;
       makeImage(score);
       
    }
    
    
    public void makeImage(int score)   {  
        image = new GreenfootImage(WIDTH, HEIGHT);  // prepare image
        image.setColor(new Color(176, 176, 176)); // set color
        image.fill(); // fill with current color
        image.setColor(Color.WHITE);  // reset color
        image.fillRect(2, 2, image.getWidth() -4, image.getHeight() -4);  // fill rectangle with color set
        font = image.getFont();  // get current font
        font = font.deriveFont(FONT_SIZE);  // set font size
        image.setFont(font);  // set font
        image.setColor(Color.BLACK);  // set font color
        image.drawString("" + score, 4, 22);   // place text
        setImage(image);  // set image
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
