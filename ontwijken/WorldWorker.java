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

    public static int speed; // set speed as global variable
    public static int distance; //distance to goal

    private int speedTimer = 0;
    private int spawnTimer = 0;
    public static int score = 0;
    private boolean placed = false; //true if finish is placed
    
    
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
        
        //set distance
        distance = 43200;

        //set Timer
        addObject(new TimerDisplay(),60,34);
        
        randomSpawner(); // call random spawner 
    }
    
    public void act(){
        speedUp(); // call the speed up function
        spawnRate(); // call the spawn function
        decreaseDistance(); //decreases distance to finish

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
        spawnTimer++; // add 1 to spawnTimer
        
        int condition = 200 - (12 * speed); // define the condition
        if(spawnTimer >= condition){ // if spawn timer = at current needed amount
            randomSpawner(); // spawn obstakels
            spawnTimer = 0; // reset spawnTimer
        }
    }
    //increases speed
    public void speedUp(){
        speedTimer++; // add speed to timer
        
        if(speedTimer == 200){ //when speed timer = 200, speed up
            // if speed lower than max, increase speed
            if(speed < 25){
                speed++;
            }
            speedTimer = 0; // reset speed timer
        }
    }
    //spawns obstacles
    public void randomSpawner(){

        int amount = (int) (Math.random()*5); // get random amount of obstakels to place
        for(int i = 0; i < amount; i++){
            addObject(new ObsCar(), (int) (Math.random() * 408)+118, 0); /* place row of obstakels
                                                                          * on random positions
                                                                          * till random amount is 
                                                                          * achieved 
                                                                          */
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
   
   public void decreaseDistance(){
       distance -= speed;
       
       if(distance <= 0 && !placed){
           addObject(new BurningCar(),320,0);
           placed = true;
        }
    }
}
