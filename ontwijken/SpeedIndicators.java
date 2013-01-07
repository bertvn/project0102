import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeedIndicators here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedIndicators extends Actor
{
    /**
     * Act - do whatever the SpeedIndicators wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //move
        setLocation(getX(),getY()+ WorldWorker.speed);
        //if at bottom respawn at top
        if(getY() == 639){
            setLocation(getX(),0);
        }
    }    
}

