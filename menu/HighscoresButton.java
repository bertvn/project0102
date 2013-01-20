import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TopPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighscoresButton extends Actor
{
    /**
     * Act - do whatever the TopPanel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage backGround;
    
    public HighscoresButton() {
        
        backGround = new GreenfootImage("opmaak/highscoresButton.png"); // prepare background image
        setImage(backGround); // set background image
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
