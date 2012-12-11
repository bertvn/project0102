import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CalamiteitenIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CalamiteitenIcon extends Actor
{
    /**
     * Act - do whatever the TopPanel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage backGround;
    
    public CalamiteitenIcon() {
        
        backGround = new GreenfootImage("icons/calamiteiten.png"); // prepare panel image
        setImage(backGround); // set MenuPanel image
    }
    
    public void act() 
    {
        // Add your action code here.
    }     
}
