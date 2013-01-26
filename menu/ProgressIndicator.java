import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProgressIndicator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProgressIndicator extends Actor{
    private int counter = 0;

    /**
     * constructor of the class ProgressIndicator
     */
    public ProgressIndicator(){
        setImage("ontwijken/progressCar" + Ontwijken.random + ".png");
    }
    
    /**
     * Act - do whatever the ProgressIndicator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        //every 70 acts
        if(counter == 70){
            //move indicator ontwijken.speed pixels to the right
            setLocation(getX()+ Ontwijken.speed,getY());
            //reset counter
            counter = 0;
        } else{
            counter++;
        }
    }    
}
