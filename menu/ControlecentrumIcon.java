import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Child of Icons
 * Sets the background of the Icon
 * 
 * @author  RU development 
 * @version 1.0
 */
public class ControlecentrumIcon extends Icons{
    private GreenfootImage backGround;
    
    /**
     * constructor 
     */
    public ControlecentrumIcon(){
        setBackground();        
        setImage(backGround); // set MenuPanel image
    }       
    /**
     * sets background
     */
    @Override
    public void setBackground() {
        backGround = new GreenfootImage("icons/controlecentrum.png"); // prepare panel image
    }
}
