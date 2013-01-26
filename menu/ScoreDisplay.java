import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

/**
 * Write a description of class ScoreDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreDisplay extends Actor{
    /**
     * Act - do whatever the ScoreDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage image;
    private Font font;
    private Color color;
    private int scoreOld = 0;
    private int scoreNew = 0;
    
    private final float FONT_SIZE = 20.0f;
    
    /**
     * constructor of class ScoreDisplay
     */
    public ScoreDisplay(){
        updateScore();
    }
    
    /**
     * method that is run every act, this is contains everything that makes the class do what it does
     */
    public void act(){
        // Add your action code here.
        scoreNew = Ontwijken.score;
        if(scoreOld != scoreNew){
            updateScore();
            scoreOld = scoreNew;
        }
    }    
    
    /**
     * updates image with scoreNew
     */
    public void updateScore(){
        image = new GreenfootImage("ontwijken/scoreDisplay.png");  // place background image
        font = image.getFont();  // get current font
        font = font.deriveFont(FONT_SIZE);  // set font size
        image.setFont(font);  // set font
        image.setColor(Color.BLACK);  // set font color
        image.drawString("" + scoreNew, 10, 30);   // place score
        setImage(image); 
        
    }
}
