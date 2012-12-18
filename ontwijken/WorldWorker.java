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

    private int speed;
    private int timer = 0;
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
        
        //choose speed
        speed = 1;
        
        randomSpawner();
    }
    
    public void act(){
        speedUp();
    }
    
    public int getSpeed(){
        return speed;
    }
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public void speedUp(){
        timer++;
        if(timer == 150){
            randomSpawner();
        }
        if(timer == 300){
            speed++;
            timer = 0;
            randomSpawner();
        }
    }
    
    public void randomSpawner(){
        int amount = (int) (Math.random()*5)+1;
        for(int i = 0; i < amount; i++){
            addObject(new Obstacles(), (int) (Math.random() * 408)+118, 0);
        }
    }
}
