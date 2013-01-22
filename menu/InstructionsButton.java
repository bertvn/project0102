import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TopPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionsButton extends Actor
{
    /**
     * Act - do whatever the TopPanel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage backGround;
    
    public InstructionsButton() {
        
        backGround = new GreenfootImage("opmaak/instructionsButton.png"); // prepare background image
        setImage(backGround); // set background image
    }
}
