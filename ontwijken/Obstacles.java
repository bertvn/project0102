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
    private int range;
    private int scoreReduce;
    private int scoreIncrease;
    
    public void act() 
    {
        move();
        if(getY() == 639){
            WorldWorker ww = (WorldWorker) getWorld();
            ww.addScore(scoreIncrease);
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
        List<Car> cr = getObjectsInRange(range, Car.class);
        if(!cr.isEmpty()){
            WorldWorker ww = (WorldWorker) getWorld();
            ww.setSpeed(1);
            ww.addScore(scoreReduce);
            getWorld().removeObject(this);
        }
    }
    
    public void setRange(int val){
        range = val;
    }
    
    public void setScoreDecrease(int val){
        scoreReduce = val;
    }
    
    public void setScoreIncrease(int val){
        scoreIncrease = val;
    }
    
}
