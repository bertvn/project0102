import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Cracks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cracks extends Actor
{
    /**
     * Act - do whatever the Cracks wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    
    public Cracks(){
               
        setImage("cracks.png");
        setRotation((int)(Math.random() * 360));
    }
    
   public void act() 
    {
        move();
        if(getY() == 639){
            getWorld().removeObject(this);
            return;
        }
        isHit();
    }    
    
    public void move(){
        WorldWorker ww = (WorldWorker) getWorld();
        setLocation(getX(),getY()+ ww.getSpeed());
    }
    
    public void isHit(){
        List<Car> cr = getObjectsInRange(98, Car.class);
        if(!cr.isEmpty()){
            WorldWorker ww = (WorldWorker) getWorld();
            ww.setSpeed(1);
            getWorld().removeObject(this);
        }
    }   
}
