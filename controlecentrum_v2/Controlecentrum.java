import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
import java.awt.Font;

public class Controlecentrum extends World{
    
    private int totalStreetFloodings;
    private int[] streetFloodingSpots; // Spots where they can spawn.
    private int[] usedSpots; // Whether spots are taken or not.
    
    // Vars with information for a next Flood spawn.
    private int currentNewSpot;
    private int newSpotX;
    private int newSpotY;
    
    // Enforcements
    public EnfFirefighter fireTruck;
    public EnfPolice policeCar;    
    public EnfAmbulance ambulanceCar;
    
    // Clicked items
    private int clickedItems;
    private CalamityTimer clickedCalamity;
    private Enforcements clickedEnforcement;
    
    // Timer controls
    private static int nextTimerPosition;
    public static boolean maxTimersReached;
    public static int calamitiesRemoved;
    
    // Score
    private int scoreControl;

    public Controlecentrum(){    
        // Create a new world with 640x640 cells with a cell size of 1x1 pixels.
        super(640, 640, 1);
        populate();
        
        totalStreetFloodings = 0; //Initial street floodings to 0
        streetFloodingSpots = new int[]{ // Filling array with possible spots.
            0, 184, 330, 1, 425, 390,
            2, 366, 165, 3, 40, 369,
            4, 59, 119, 5, 137, 51,
            6, 545, 162, 7, 457, 128
        };
        
        usedSpots = new int[]{ // Making array with spots still open.
            0, 3, 6, 9, 12, 15, 18, 21
        };
        
        nextTimerPosition = 500;
        
        clickedItems = 0;
        clickedCalamity = null;
        clickedEnforcement = null;
        
        calamitiesRemoved = 0;
    }
    
    public void populate(){
        setBackground("controlecentrum.jpg"); // Setting background image
        
        // Headertext aanmaken voor kopje Calamiteiten
        addObject(new HeaderText("Calamiteiten"), 175, 476);
        
        // Headertext aanmaken voor kopje Hulpdiensten
        addObject(new HeaderText("Hulpdiensten"), 550, 476);
        
        // Adding enforcements to the world.
        fireTruck = new EnfFirefighter();
        
        addObject(fireTruck, 375, 550);
        
        policeCar = new EnfPolice();
        addObject(policeCar, 480, 550);
        
        ambulanceCar = new EnfAmbulance();
        addObject(ambulanceCar, 585, 550);
    }
    
    public void act(){
        if(calamitiesRemoved < 25){
            if(totalStreetFloodings == 0){ // Spawn first flooding directly.
                while(totalStreetFloodings == 0){ // Keep searching until we found 1.
                    createNewFlood(); // Searches for a spot and then adds 1 to total floodings.
                }
                
                // Adding the new flood to the world.
                addObject(new CalStreetFlooding(currentNewSpot), newSpotX, newSpotY);
            }else{ // If we already have 1 flooding.
                // Checks wheter we can create a new flooding (true = 1/600th chance).
                if(createNewFlood()){
                    // Adding the new flood to the world.
                    addObject(new CalStreetFlooding(currentNewSpot), newSpotX, newSpotY);
                }
            }
            
            updateNextTimerPosition(); // update positions.
            
            mouseInteraction(); // run checks for mouse input.
            
            showScore();
        }else{
            System.out.println("Ending game");
            // Endgame here
        }
    }
    
    public boolean createNewFlood(){
        if(maxTimersReached){
            return false;
        }else if(totalStreetFloodings >= 8){
            // If we have 8, or somehow more, floodings we will not create a new one.
            return false;
        }else if((int) (Math.random() * 600) != 1){
            // If number != 1 abort creating a new one.
            return false;
        }else{
            int randomSpot; // initialize temporary var
            boolean foundSpot = false; // start state of foundSpot will be false.
            
            do{
                // Finding a new spot in the array which is not taken yet.
                randomSpot = (int) (Math.random() * 8); // We have 8 spots.
                if(usedSpots[randomSpot] != -1){ // -1 spots are already taken.
                    // We found a new spot and save our information for later.
                    currentNewSpot = randomSpot + 1;
                    newSpotX = streetFloodingSpots[usedSpots[randomSpot] + 1];
                    newSpotY = streetFloodingSpots[usedSpots[randomSpot] + 2];
                    
                    // Make this spot unavailable by setting it with -1.
                    usedSpots[randomSpot] = -1;
                    foundSpot = true; 
                }
            }while(!foundSpot);
            
            totalStreetFloodings++; // We found a new flooding so add 1 to total.
            return true;
        }
    }
    
    public void updateNextTimerPosition(){
        int counter = getObjects(CalamityTimer.class).size(); // Amount of timers 
        if(counter < 9){
            maxTimersReached = false;
            nextTimerPosition = counter * 15 + 500;
        }else{
            maxTimersReached = true;
        }
    }
    
    public static int getNextTimerPosition(){
        return nextTimerPosition;
    }
    
    public void mouseInteraction(){
        if(Greenfoot.mouseClicked(null)) { // when mouse button is pressed
            MouseInfo mouse = Greenfoot.getMouseInfo(); // get mouse info
            List<CalamityTimer> calTimer = getObjectsAt(mouse.getX(), mouse.getY(), CalamityTimer.class);
            List<Enforcements> enfItems = getObjectsAt(mouse.getX(), mouse.getY(), Enforcements.class);

            if(!calTimer.isEmpty()){
                if(clickedCalamity == null){
                    clickedItems++;
                }
                clickedCalamity = calTimer.get(0);
            }
            
            if(!enfItems.isEmpty()){
                if(!enfItems.get(0).getStatus()){
                    if(clickedEnforcement == null){
                        clickedItems++;
                    }
                    clickedEnforcement = enfItems.get(0);
                }else{
                    System.out.println("Enforcement is busy");
                }
            }
            
            if(clickedItems == 2){
                checkForCombinations();
            }
        }
    }
    
    public void checkForCombinations(){
        if(clickedCalamity.getBelongsTo().getCalamityTimer() == null){
            clickedCalamity = null;
            clickedItems--;
        }else if(clickedCalamity.getCalamityType() == clickedEnforcement.getEnfType()){
            if(clickedCalamity.getBelongsTo().getClass() != CalStreetFlooding.class){
                removeObject(clickedCalamity.getBelongsTo());
                clickedCalamity.removeCalamityTimer();
            }else{
                clickedCalamity.getBelongsTo().removeCalamityTimer();
                // clickedCalamity.getBelongsTo().setCalamityTimer(null);
            }

            clickedEnforcement.isNowBusy(true);
            
            clickedCalamity = null;
            clickedEnforcement = null;
            clickedItems = 0;
        }
    }
    
    public void showScore(){
        GreenfootImage image = new GreenfootImage(120,24);  // place background image
        Font font = image.getFont();  // get current font
        font = font.deriveFont(20.0F);  // set font size
        image.setFont(font);  // set font
        image.setColor(Color.BLACK);  // set font color
        image.drawString("score: " + scoreControl, 10, 17);   // place score
        //setImage(image);  
    }
    
    public void addScore(int amount){
        scoreControl += amount;
    }
}






