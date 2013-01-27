import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

/**
 * class that displays score in Controlecentrum
 * 
 * @author  RU development 
 * @version 1.0
 */
public class ScoreDisp extends Actor{

    private GreenfootImage image;
    private Font font;
    private Color color;
    private int scoreOld;
    private int scoreNew;
    
    private final float FONT_SIZE;
    private final int HEIGHT;
    private final int WIDTH;
    
    /**
     * constructor for the class ScoreDisp
     */
    public ScoreDisp(){
        scoreOld = 0;
        scoreNew = 0;
        FONT_SIZE = 18.0F;
        HEIGHT = 24;
        WIDTH = 120;
        
        updateScore();
    }
    
    /**
     * method that is run every act, this is contains everything that makes the class do what it does
     */
    public void act(){
        scoreNew = Controlecentrum.scoreControl;
        if(scoreOld != scoreNew){
            updateScore();
            scoreOld = scoreNew;
        }
    }    
    
    /**
     * makes image with the new score
     */
    private void updateScore(){
        image = new GreenfootImage(WIDTH,HEIGHT);  // place background image
        font = image.getFont();  // get current font
        font = font.deriveFont(FONT_SIZE);  // set font size
        image.setFont(font);  // set font
        image.setColor(Color.BLACK);  // set font color
        image.drawString("Score: " + scoreNew, 10, 17);   // place score
        setImage(image);
    }    
}