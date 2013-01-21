import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Power here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Power extends Actor
{

   private int speedChange; 

    /**
     * Act - do whatever the Power wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move();
        if(getY() == 639){
            getWorld().removeObject(this);
            return;
        }
        
    }    
    //move down speed amount of pixels
    public void move(){
        setLocation(getX(),getY()+ WorldWorker.speed);
    
    }    
    
    public void setSpeedChange(int v){
        speedChange = v;
    }
    
}
