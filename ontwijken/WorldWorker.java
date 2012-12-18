import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class WorldWorde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldWorker extends World
{

    /**
     * Constructor for objects of class WorldWorde.
     * 
     */
    public WorldWorker()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 640, 1); 
        
        // add the grass on the left
        addObject(new Grass(), 59, 320);
        
        // add the road
        addObject(new Road(), 322, 320);
        
        // add the grass on the right
        addObject(new Grass(), 585, 320);
        
        // add the car
        addObject(new Car(), 320, 500);
    }
}
