import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Child of Icons
 * Sets the background of the Icon
 * 
 * @author  RU development: Patrick Aleman 
 * @version 1.0
 */
public class DijkdoorbraakIcon extends Icons{

    private GreenfootImage backGround;
    
    /**
     * constructor 
     * invokes setBackground
     * place image
     */
    public DijkdoorbraakIcon(){
        setBackground(); 
        setImage(backGround); // set MenuPanel image
    }     
    /**
     * sets background
     */
    public void setBackground() {
        backGround = new GreenfootImage("icons/dijkdoorbraak.png"); // prepare panel image
    }
}
