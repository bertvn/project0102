import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * trees speedIndicator
 * extends speedIndicators
 * 
 * @author  RU development 
 * @version 1.0
 */
public class Trees extends SpeedIndicators{
    /**
     * constructor for the class Trees
     */
    public Trees(){
        int random = (int) Math.round(Math.random()*2) + 1;
        
        //chooses image depending on number
        setImage("ontwijken/boom" + random + ".png");
        
        //sets random rotation
        setRotation((int)(Math.random() * 360));
        
    }
    
    /**
     * Act - do whatever the Trees wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        // Add your action code here.
        super.act();
    }    
}
