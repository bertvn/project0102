import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TopPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuPanel extends Actor
{
    /**
     * Act - do whatever the TopPanel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage backGround;
    
    public MenuPanel() {
        
        backGround = new GreenfootImage("opmaak/menuPanel.png"); // prepare panel image
        setImage(backGround); // set MenuPanel image
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}