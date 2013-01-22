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
    
    private int scoreIncrease;
    
    
    public void act() 
    {
        move();
        if(getY() == 639){
            Ontwijken.score += scoreIncrease;
            getWorld().removeObject(this);
            return;
        }
        
    }    
    //move down speed amount of pixels
    public void move(){
        setLocation(getX(),getY()+ Ontwijken.speed);
    }
    
   
    
    //set scoreIncrease
    public void setScoreIncrease(int val){
        scoreIncrease = val;
    }
    
}
