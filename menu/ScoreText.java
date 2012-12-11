import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class ScoreTextfield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreText extends Actor
{
    private GreenfootImage image;
    private Font font;
    private Color color;

    private final float FONT_SIZE = 20.0f;
    private final int WIDTH = 220;
    private final int HEIGHT = 30;
    
    public ScoreText() {       
       image = new GreenfootImage(WIDTH, HEIGHT);  // prepare image
       Font font = image.getFont();  // get current font
       font = font.deriveFont(FONT_SIZE);  // set font size
       image.setFont(font);  // set font
       image.setColor(Color.WHITE);  // set font color
       image.drawString("Score", 4, 22);   // place text
       setImage(image);  // place image
    }
}
