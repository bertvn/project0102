import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Child of Icons
 * Sets the background of the Icon
 * 
 * @author  RU development
 * @version 1.0
 */
public class DoolhofIcon extends Icons{

    private GreenfootImage backGround;
    
    /**
     * constructor
     */
    public DoolhofIcon(){
        setBackground();
        setImage(backGround); // set MenuPanel image
    }
    
    /**
     * sets background
     */
    @Override
    public void setBackground() {
        backGround = new GreenfootImage("icons/doolhof.png"); // prepare panel image
    }
}
