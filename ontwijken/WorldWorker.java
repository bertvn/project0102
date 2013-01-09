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
    public static GreenfootSound music;
    
    /**
     * Constructor for objects of class WorldWorde.
     * 
     */
    public WorldWorker()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 640, 1); 
        
        //populate world
        populate();
        
        //sets order in which objects are drawn
        setPaintOrder(ProgressIndicator.class,ProgressBar.class,BAM.class,Car.class,BurningCar.class,ScoreDisplay.class,TimerDisplay.class,ObsCar.class,Cracks.class,RoadMarking.class,Trees.class,Road.class,Grass.class);
        
        //play music
        music = new GreenfootSound("Breakdown.mp3");
        
    }
    
    public void act(){
        speedUp(); // call the speed up function
        spawnRate(); // call the spawn function
        decreaseDistance(); //decreases distance to finish
        music.play(); //starts music
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
            if(speed < 20){
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
        
        if(amount == 0){
            addObject(new Cracks(), (int) (Math.random() * 408)+118, 0);
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
   //decreases distance to win state
   public void decreaseDistance(){
       distance -= speed;
       //if distance is 0 place object in world
       // boolean placed to make sure it is only placed once
       if(distance <= 0 && !placed){
           addObject(new BurningCar(),320,0);
           placed = true;
        }
    }
    
    //fills world
    public void populate(){
        // add the grass on the left
        addObject(new Grass(), 59, 320);
        
        // add the road
        addObject(new Road(), 320, 320);
        
        // add the grass on the right
        addObject(new Grass(), 583, 320);
        
        // add the car
        addObject(new Car(), 320, 500);
        
        //add scoreDisplay
        addObject(new ScoreDisplay(), 580, 34);
        
        //choose speed
        speed = 1;
        
        //set distance
        distance = 40000;

        //set Timer
        addObject(new TimerDisplay(),60,34);
        
        //add RoadMarkings
        addObject(new RoadMarking(),320,0);
        addObject(new RoadMarking(),320,320);
        
        //add trees
        //right hand side
        addObject(new Trees(),567,65);
        addObject(new Trees(),605,143);
        addObject(new Trees(),564,221);
        addObject(new Trees(),605,301);
        addObject(new Trees(),565,404);
        addObject(new Trees(),614,477);
        addObject(new Trees(),567,538);
        addObject(new Trees(),610,608);
        
        //left hand side
        addObject(new Trees(),81,59);
        addObject(new Trees(),37,128);
        addObject(new Trees(),79,183);
        addObject(new Trees(),29,264);
        addObject(new Trees(),77,364);
        addObject(new Trees(),27,434);
        addObject(new Trees(),95,517);
        addObject(new Trees(),37,620);
        
        //add progressbar
        addObject(new ProgressBar(),320,542);
        addObject(new ProgressIndicator(),28,625);
        
        randomSpawner(); // call random spawner 
    }
}
