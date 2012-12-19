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
            WorldWorker.score += scoreIncrease;
            getWorld().removeObject(this);
            return;
        }
        isHit();
    }    
    //move down speed amount of pixels
    public void move(){
        setLocation(getX(),getY()+ WorldWorker.speed);
    }
    
    //checks if hit, and if so removes this object and slows the game down to speed 1
    public void isHit(){
        List<Car> cr = getObjectsInRange(range, Car.class);
        if(!cr.isEmpty()){
            WorldWorker.speed = 1;
            WorldWorker.score += scoreReduce;
            getWorld().removeObject(this);
        }
    }
    //set range
    public void setRange(int val){
        range = val;
    }
    //set scoreDecrease
    public void setScoreDecrease(int val){
        scoreReduce = val;
    }
    //set scoreIncrease
    public void setScoreIncrease(int val){
        scoreIncrease = val;
    }
    
}
