import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * HighscoreButton
 * 
 * @author  RU development: Patrick Aleman 
 * @version 1.0
 */
public class HighscoresButton extends Actor {
   
    private GreenfootImage backGround;
    
    /**
     * Constructor updates backGround
     * and invokes setImage() to place the background
     */
    public HighscoresButton() {
        
        backGround = new GreenfootImage("opmaak/highscoresButton.png"); // prepare background image
        setImage(backGround); // set background image
    }
}
