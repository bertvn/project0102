import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * abstact class that is used for extending
 * it moves done and if it has reached the bottom of the screen it will disappear 
 * and add points to the score
 * 
 * @author  RU development 
 * @version 1.0
 */
public abstract class Obstacles extends Actor{
      
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
