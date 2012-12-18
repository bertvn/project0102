import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Car() {       
        // prepare image
        GreenfootImage img = new GreenfootImage("car.png");
        setImage(img); // set image
    }
    
    public void act() 
    {          
        if(Greenfoot.isKeyDown("left")) {
            move(0);
        } else if(Greenfoot.isKeyDown("right")) {
            move(1);
        }
        
    }    
    
    public void move(int direction) {
        
        switch(direction) {
            case 0 :
                setLocation(getX() - 1, getY());
                break;
            case 1 :
                setLocation(getX() + 1, getY());
                break;
                
        }
    }
}
