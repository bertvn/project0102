import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Cracks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cracks extends Obstacles
{
    /**
     * Act - do whatever the Cracks wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    
    public Cracks(){
        setImage("cracks.png");
        setRotation((int)(Math.random() * 360));
        setRange(57);
        setScoreIncrease(20);
        setScoreDecrease(-100);
    }
    
   public void act() 
    {
        super.act();
    }    
       
}
