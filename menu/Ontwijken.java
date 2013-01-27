import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;

/**
 * Onwijken is the very main of the minigame: ontwijken
 * it will place the objects, start the timer and start the game
 * Also keeps check on score
 * 
 * @author  RU development
 * @version 1.2
 */
public class Ontwijken extends World{

    public static int speed; // set speed as global variable
    public static int distance; //distance to goal
    public static int score;// sets score
    public static int random; //selects player car image
    public static boolean go; //game runs if go == true
    
    private TimerDisplay td;
    private TextDisplay theMessage;

    private int speedTimer = 0;
    private int spawnTimer = 0;
    
    private boolean placed = false; //true if finish is placed
    
    public static GreenfootSound music; //music object
    
    /**
     * Constructor for objects of class Ontwijken.
     * 
     */
    public Ontwijken(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 640, 1); 
        random = (int) Math.round(Math.random()*2)+1; //choice game images
        populate(); //populate world
        
        //sets order in which objects are drawn
        setPaintOrder(Instructions.class,TextDisplay.class,ProgressIndicator.class,ProgressBar.class,BAM.class,Car.class,BurningCar.class,ScoreDisplay.class,TimerDisplay.class,ObsCar.class,Cracks.class,RoadMarking.class,Trees.class,Road.class,Grass.class);
        music = new GreenfootSound("Breakdown.mp3"); //play music
        
        speedTimer = 0;
        spawnTimer = 0;
        
        speed = 0; //choose speed
        distance = 40000; //set distance
        
        //set score
        score = 0;
        
        //set starter
        go = false;
    }
    
    /**
     * method that is run every act, this is contains everything that makes the class do what it does
     */
    public void act(){
        if(Greenfoot.mouseClicked(null)) {//when mouse button is pressed
            MouseInfo mouse = Greenfoot.getMouseInfo(); // get mouse info
            int x = mouse.getX();
            int y = mouse.getY();
            //zet hier nog de lose win text ding geval
            List<Instructions> instructionsPanel = getObjectsAt(x, y, Instructions.class); // get the object that hits mouse of instructions (panel)
            List<TextDisplay> textPanel = getObjectsAt(x, y, TextDisplay.class); // get the object that hits mouse of instructions (panel)
            
            if(!instructionsPanel.isEmpty()){ // if there is an object hit (if pressed on instructions panel
                removeObject(instructionsPanel.get(0));
                td.startTimer(); // starts the initialezed timer 
                go = true; // set boolean to start the game to true 
                speed = 1; // init speed at 1
            }
            
            if(!textPanel.isEmpty()) { // if there is an object hit (if pressed on TextDisplay panel
                //go back to menu
                Greenfoot.setWorld(new Menu());
            }
        }
        
        if(go){
            speedUp(); // call the speed up function
            spawnRate(); // call the spawn function
            decreaseDistance(); //decreases distance to finish
            music.play(); //starts music
        }else{
            music.stop();//stops music
            speed = 0;
            td.stopTimer();
        }
    }
    
    /**
     * counts untill it is time to spawn new obstacles
     */
    private void spawnRate(){
        spawnTimer++; // add 1 to spawnTimer
     
        int condition = 200 - (12 * speed); // define the condition

        if(spawnTimer >= condition){ // if spawn timer = at current needed amount
            randomSpawner(); // spawn obstacles
            spawnTimer = 0; // reset spawnTimer
        }
    }

    /**
     * Increases speed
     * if speedTimer = 200 the speed is increased by 1
     * if speed >= 20 speed is not increased
     */
    private void speedUp(){
        speedTimer++; // add speed to timer
        
        if(speedTimer == 200){ //when speed timer = 200, speed up
            // if speed lower than max, increase speed
            if(speed < 20){
                speed++;
            }
            speedTimer = 0; // reset speed timer
        }
    }

    /**
     * spawns new obstacles to evade
     * randomly spawns 1-5 cars or 1 crack
     */
    private void randomSpawner(){
        int amount = (int) (Math.random()*5); // get random amount of obstakels to place
        for(int i = 0; i < amount; i++){
            // place row of obstakels on random positions till random amount is achieved 
            addObject(new ObsCar(), (int) (Math.random() * 408) + 118, 0); 
        }
        
        if(amount == 0){
            addObject(new Cracks(), (int) (Math.random() * 408) + 118, 0);
        }
    }
        
    /**
    * decreases distance to win state with the amount of speed
    */
    //decreases distance to win state
    public void decreaseDistance(){
        distance -= speed;
        //if distance is 0 place object in world
        // boolean placed to make sure it is only placed once
        if(distance <= 0 && !placed){
            addObject(new BurningCar(), 320, 0);
            placed = true;
        }
    }
    
    /**
     * fills world
     */
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

        //set Timer
        td = new TimerDisplay();
        addObject(td, 60, 34);
        
        //add RoadMarkings
        addObject(new RoadMarking(), 320, 0);
        addObject(new RoadMarking(), 320, 320);
        
        //add trees
        //right hand side
        addObject(new Trees(), 567, 65);
        addObject(new Trees(), 605, 143);
        addObject(new Trees(), 564, 221);
        addObject(new Trees(), 605, 301);
        addObject(new Trees(), 565, 404);
        addObject(new Trees(), 614, 477);
        addObject(new Trees(), 567, 538);
        addObject(new Trees(), 610, 608);
        
        //left hand side
        addObject(new Trees(), 81, 59);
        addObject(new Trees(), 37, 128);
        addObject(new Trees(), 79, 183);
        addObject(new Trees(), 29, 264);
        addObject(new Trees(), 77, 364);
        addObject(new Trees(), 27, 434);
        addObject(new Trees(), 95, 517);
        addObject(new Trees(), 37, 620);
        
        //add progressbar
        addObject(new ProgressBar(), 320, 542);
        addObject(new ProgressIndicator(), 28, 625);
        
        addObject(new Instructions(3), 320, 320);
        
        randomSpawner(); // call random spawner 
    }
    
    /**
     * creates message image
     * @param xCoord The x coord of where the image will spawn
     * @param yCoord The y coord of where the image will spawn
     * @param message The message that will be shown
     */
    public void createMessage(int xCoord, int yCoord, String message){
        theMessage = new TextDisplay();
        theMessage.setBackgroundColor(255, 255, 255, 160);
        theMessage.setBorderColor(0, 0, 0, 160);
        theMessage.setField(480, 150);
        theMessage.setFontSize(30.0f);
        theMessage.setBorder(5, 5);
        theMessage.setDrawString(50, 90);
        theMessage.setInput(message);
        theMessage.setHasBackground(true);
        
        theMessage.createTextBox();
        addObject(theMessage, xCoord, yCoord);
    }
}
