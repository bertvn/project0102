import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * image of the car that moves along the Progressbar
 * is used to indicate progress in the ontwijken minigame
 * 
 * @author  RU development 
 * @version 1.0
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
