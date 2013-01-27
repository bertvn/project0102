import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * moves objects that are used to make it seem like the Car in Ontwijken is moving forward
 * if object reaches the bottom of the screen it is placed at the top
 * 
 * @author  RU development 
 * @version 1.0
 */
public abstract class SpeedIndicators extends Actor{
    /**
     * Act - do whatever the SpeedIndicators wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        //move
        setLocation(getX(),getY()+ Ontwijken.speed);
        //if at bottom respawn at top
        if(getY() == 639){
            setLocation(getX(),0);
        }
    }    
}

