import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Obstacels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Obstacles extends Actor{
    
    /**
     * Act - do whatever the Obstacels wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */  
    private int scoreIncrease;
    
    /**
     * method that is run every act, this is contains everything that makes the class do what it does
     */
    public void act(){
        move();
        if(getY() == 639){
            Ontwijken.score += scoreIncrease;
            getWorld().removeObject(this);
            return;
        }        
    }    
    
    /**
     * moves the obstacles down with Ontwijken.speed pixels
     */
    private void move(){
        setLocation(getX(),getY()+ Ontwijken.speed);
    }
    
    /**
     * sets scoreIncrease
     * @param val its value is used to set scoreIncrease
     */
    public void setScoreIncrease(int val){
        scoreIncrease = val;
    }
}
