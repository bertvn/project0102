import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BurningCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BurningCar extends Actor
{
    /**
     * Act - do whatever the BurningCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public BurningCar(){
        setImage("burningCar.png");
    }
    
    public void act() 
    {
        // Add your action code here.
        if(getY() >= 320){
            WorldWorker.music.stop();
            endGame();
        } else{
            move();
        }
    }
    
    public void move(){
        setLocation(getX(),getY()+ WorldWorker.speed);
    }
    
    public void endGame(){
        //adding timeleft to score
        WorldWorker.score += ((TimerDisplay.currentValue/60)*39.1); 
        //code to send score to menu here
        System.out.println(WorldWorker.score);
        //return to menu here
        
        Greenfoot.stop();
    }
}
