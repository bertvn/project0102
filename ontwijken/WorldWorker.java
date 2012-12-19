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

    public static int speed;
    private int speedTimer = 0;
    private int spawnTimer = 0;
    public static int score = 0;
    
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
        
        //add scoreDisplay
        addObject(new ScoreDisplay(), 580, 34);
        
        //choose speed
        speed = 1;
        //spawn obstacles
        randomSpawner();
    }
    
    public void act(){
        speedUp();
        spawnRate();
        if(score < 0){
            score = 0;
        }
    }
    //return speed
    public int getSpeed(){
        return speed;
    }
    //set speed
    public void setSpeed(int speed){
        this.speed = speed;
    }
    //choses when to spawn
    public void spawnRate(){
        spawnTimer++;
        if(spawnTimer >= (260 - 10 * speed)){
            randomSpawner();
            spawnTimer = 0;
        }
    }
    //increases speed
    public void speedUp(){
        speedTimer++;
        
        if(speedTimer == 300){
            // if speed lower than max, increase speed
            if(speed < 25){
                speed++;
            }
            speedTimer = 0;
        }
    }
    //spawns obstacles
    public void randomSpawner(){
        int amount = (int) (Math.random()*5);
        for(int i = 0; i < amount; i++){
            addObject(new ObsCar(), (int) (Math.random() * 408)+118, 0);
        }
    }
    
    //return score
    public int getScore(){
        return score;
    }
    //return score as string
    public String getScoreString(){
        return "" + score;
    }
}
