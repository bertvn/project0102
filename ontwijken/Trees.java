import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trees here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trees extends SpeedIndicators
{
    
    public Trees(){
        int random = (int) Math.round(Math.random()*2) + 1;
        
        //chooses image depending on number
        setImage("boom" + random + ".png");
        
        //sets random rotation
        setRotation((int)(Math.random() * 360));
        
    }
    /**
     * Act - do whatever the Trees wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        super.act();
    }    
}
