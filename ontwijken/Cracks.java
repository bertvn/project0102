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
        //sets image
        setImage("cracks.png");
        //sets random rotation
        setRotation((int)(Math.random() * 360));
        //sets range for hitdetection
        setRange(57);
        //sets score increase for when crack is evaded
        setScoreIncrease(20);
        //sets score decrease for when crack is hit
        setScoreDecrease(-100);
    }
    
   public void act() 
    {
        //calls the act of Obstacles
        super.act();
    }    
       
}
