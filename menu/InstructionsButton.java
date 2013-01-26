import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TopPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionsButton extends Actor{

    private GreenfootImage backGround;
    
    /**
     * Constructor
     * updates backGround
     * invokes setImage()
     */
    public InstructionsButton() {
        backGround = new GreenfootImage("opmaak/instructionsButton.png"); // prepare background image
        setImage(backGround); // set background image
    }
}
