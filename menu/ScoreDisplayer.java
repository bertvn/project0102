import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

/**
 * Write a description of class ScoreDisplayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreDisplayer extends Actor
{
    private GreenfootImage image;
    private Font font;
    private Color color;
    private int scoreOld = 0;
    private int scoreNew = 0;
    
    private final float FONT_SIZE = 20.0F;
    private final int HEIGHT = 24;
    private final int WIDTH = 120;
    
    /**
     * constructor of the class ScoreDisplayer 
     */
    public ScoreDisplayer(){
        updateScore();
    }
    
    /**
     * Act - do whatever the ScoreDisplayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        scoreNew = Dijkdoorbraak.score;
        if(scoreOld != scoreNew){
            updateScore();
            scoreOld = scoreNew;
        }
    }    
    
    /**
     * updates image with scoreNew
     */
    public void updateScore(){
        image = new GreenfootImage(WIDTH,HEIGHT);  // place background image
        font = image.getFont();  // get current font
        font = font.deriveFont(FONT_SIZE);  // set font size
        image.setFont(font);  // set font
        image.setColor(Color.BLACK);  // set font color
        image.drawString("score: " + scoreNew, 10, 17);   // place score
        setImage(image); 
        
    }    
}
