import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grass extends DesignObjects
{
    /**
     * Act - do whatever the Grass wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Grass() {
        // get variables from parent
        super();
        
        // prepare the image
        img = new GreenfootImage("grass01.jpg");
        setImage(img); // set the image
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
