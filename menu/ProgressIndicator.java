import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProgressIndicator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProgressIndicator extends Actor
{

    private int counter = 0;

    public ProgressIndicator(){
        setImage("ontwijken/progressCar" + Ontwijken.random + ".png");
    }
    /**
     * Act - do whatever the ProgressIndicator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(counter == 70){
            setLocation(getX()+ Ontwijken.speed,getY());
            counter = 0;
        } else{
            counter++;
        }
        
    }    
}
