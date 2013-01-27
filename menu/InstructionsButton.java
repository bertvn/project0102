import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * class that makes the instructions button in menu
 * 
 * @author  RU development 
 * @version 1.0
 */
public class InstructionsButton extends Actor{

    private GreenfootImage backGround;
    
    /**
     * Constructor
     */
    public InstructionsButton() {
        backGround = new GreenfootImage("opmaak/instructionsButton.png"); // prepare background image
        setImage(backGround); // set background image
    }
}
