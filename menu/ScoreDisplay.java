import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

/**
 * scoreDisplay displays the score for minigame ontwijken
 * 
 * @author  RU development 
 * @version 1.0
 */
public class ScoreDisplay extends Actor{
        
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
