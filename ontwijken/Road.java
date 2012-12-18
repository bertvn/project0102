import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Road here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Road extends DesignObjects
{
    /**
     * Act - do whatever the Road wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Road() {
        // get variables from parent
        super();
        
        // prepare the image
        img = new GreenfootImage("road.jpg");
        setImage(img); // set the image    
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
