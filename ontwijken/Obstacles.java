import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Obstacels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacles extends Actor
{
    /**
     * Act - do whatever the Obstacels wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public Obstacles(){
        int random = (int) Math.round(Math.random()*5);
        
        switch(random){
            case 0: setImage("obstacle0.png");
                    break;
            case 1: setImage("obstacle1.png");
                    break;
            case 2: setImage("obstacle2.png");
                    break;
            case 3: setImage("obstacle3.png");
                    break;
            case 4: setImage("obstacle4.png");
                    break;
            case 5: setImage("obstacle5.png");
                    break;
        }
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
        List<Car> cr = getObjectsInRange(39, Car.class);
        if(!cr.isEmpty()){
            WorldWorker ww = (WorldWorker) getWorld();
            ww.setSpeed(1);
            getWorld().removeObject(this);
        }
    }
    
}
