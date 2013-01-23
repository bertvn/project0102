import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ObsCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObsCar extends Obstacles
{
    /**
     * Act - do whatever the ObsCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public ObsCar(){
        //chooses random number between 0 and 5
        int random = (int) Math.round(Math.random()*5);
        
        //chooses image depending on number
        setImage("ontwijken/obstacle" + random + ".png");
        
        //sets random rotation
        setRotation((int)(Math.random() * 360));
        
        //sets score increase for when car is evaded
        setScoreIncrease(10);
    }
    
    public void act() 
    {
        // Add your action code here.
        //calls the act of Obstacles
        super.act();
    }    
}
