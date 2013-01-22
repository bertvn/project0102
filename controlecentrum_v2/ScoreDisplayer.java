import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

public class ScoreDisplayer extends Actor{

    private GreenfootImage image;
    private Font font;
    private Color color;
    private int scoreOld = 0;
    private int scoreNew = 0;
    
    private final float FONT_SIZE = 18.0F;
    private final int HEIGHT = 24;
    private final int WIDTH = 120;
    
    //place initial score image
    public ScoreDisplayer(){
        updateScore();
    }
    
    public void act(){
        // Add your action code here.
        scoreNew = Controlecentrum.scoreControl;
        if(scoreOld != scoreNew){
            updateScore();
            scoreOld = scoreNew;
        }
    }    
    
    public void updateScore(){
        image = new GreenfootImage(WIDTH,HEIGHT);  // place background image
        font = image.getFont();  // get current font
        font = font.deriveFont(FONT_SIZE);  // set font size
        image.setFont(font);  // set font
        image.setColor(Color.BLACK);  // set font color
        image.drawString("Score: " + scoreNew, 10, 17);   // place score
        setImage(image); 
        
    }    
}