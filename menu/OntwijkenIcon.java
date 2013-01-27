import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Child of Icons
 * Sets the background of the Icon
 * 
 * @author  RU development 
 * @version 1.0
 */
public class OntwijkenIcon extends Icons{
    
    private GreenfootImage backGround;
    
    /**
     * constructor
     */
    public OntwijkenIcon() {
        setBackground();
        setImage(backGround); // set MenuPanel image
    }
    /**
     * sets background
     */
    @Override
    public void setBackground() {
        backGround = new GreenfootImage("icons/ontwijken.png"); // prepare panel image
    }
}
