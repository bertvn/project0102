import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author      RU Development
 * @version     1.0
 * @since       26-01-2013
 */
public class CalStreetFlooding extends Calamities{

    // Creating a boolean to check for first act.
    private boolean firstAct;
    private boolean streetIsOpen;
        
    // Variables for short circuit
    private int waitForShortCircuit;
    private CalShortCircuit shortCircuit;
    
    // Variables for car crashes
    private int waitForCarCrash;
    private CalCarCrash carCrash;
    
    // Variables or looters
    private int waitForLooters;
    private CalLooters looters;

    /**
     * Constructor for this class.
     * @param Requires an image number to set the correct image for this 
     * flooding.
     */
    public CalStreetFlooding(int imgNr){
        setImage("controlecentrum/overstroming" + imgNr + ".png");

        firstAct = true;
        streetIsOpen = true;
        
        // Default time for waiting with a new Short Circuit is about 10s.
        waitForShortCircuit = 750;
        waitForCarCrash = 438;
        waitForLooters = 500;
    }

    /**
     * This method runs every act and updates the information needed
     * to create other calamities.
     */
    public void act(){
        super.act();
        
        // Creating a new timer in the first act (can't be done in constructor
        // because the object does not exist yet).
        if(firstAct == true){
            createTimer(75, "Ondergelopen straat:  ", "EnfPolice", this);
            firstAct = false;
        }
        
        if(streetIsOpen){
            if(getCalamityTimer() == null){
                closeStreet();
            }
        }
        
        shortCircuitAct(); // Run seperate act for short circuit calamities.
        carCrashAct(); // Run seperate act for car crash calamities.
        lootersAct(); // Run seperate act for looters calamities.
    }

    /**
     * This method runs every act and controls the creation of new calamities
     * of the short circuit type.
     */
    private void shortCircuitAct(){
        if(waitForShortCircuit == 0){ // If we do not need to wait any longer.
            if(!Controlecentrum.maxTimersReached){
                // 1/750 chance on new calamity
                if((int) (Math.random() * 750) == 0){ 
                    shortCircuit = new CalShortCircuit();
                    getWorld().addObject(shortCircuit, getX()+9, getY()-21);
                    waitForShortCircuit = 1700; // Set waiting time to spawn new ones.
                }
            }
        }else{ // if there is a waiting time.
            waitForShortCircuit--; // decrease waiting time.
        }
    }
    
    /**
     * This method runs every act and controls the creation of new calamities
     * of the car crash type.
     */
    private void carCrashAct(){
        if(streetIsOpen){ // If we do not need to wait any longer.
            if(waitForCarCrash == 0){
                if(!Controlecentrum.maxTimersReached){
                    // 1/1250 chance on new calamity
                    if((int) (Math.random() * 1250) == 0){ 
                        carCrash = new CalCarCrash();
                        getWorld().addObject(carCrash, getX()+26, getY()+8);
                        waitForCarCrash = 1000; // Set waiting time to spawn new ones.
                    }
                }
            }else{ // if there is a waiting time.
                waitForCarCrash--; // decrease waiting time.
            }
        }
    }

    /**
     * This method runs every act and controls the creation of new calamities
     * of the looters type.
     */
    private void lootersAct(){
        // If the street is closed and we do not need to wait any longer
        if(!streetIsOpen){
            if(waitForLooters == 0){
                if(!Controlecentrum.maxTimersReached){
                    // 1/1375 chance on new calamity
                    if((int) (Math.random() * 1375) == 0){ 
                        looters = new CalLooters();
                        getWorld().addObject(looters, getX()-8, getY()+8);
                        waitForLooters = 1700; // Set waiting time to spawn new ones.
                    }
                }
            }else{ // if there is a waiting time.
                waitForLooters--; // decrease waiting time.
            }
        }
    }
    
    /**
     * A method to close the street (sets status to false).
     */
    private void closeStreet(){
        streetIsOpen = false;
    }

    /**
     * A method to create all connected objects (used for ending the game).
     */
    public void removeAllObjects(){
        if(looters != null){
            // If connected with looters, remove the looters.
            if(looters.getCalamityTimer() != null){
                getWorld().removeObject(looters.getCalamityTimer());
            }
            getWorld().removeObject(looters);
        }
        
        if(carCrash != null){
            // If connected with carCrash, remove the carCrash.
            if(carCrash.getCalamityTimer() != null){
                getWorld().removeObject(carCrash.getCalamityTimer());
            }
            getWorld().removeObject(carCrash);
        }
        
        if(shortCircuit != null){
            // If connected with shortCircuit, remove the shortCircuit.
            if(shortCircuit.getCalamityTimer() != null){
                getWorld().removeObject(shortCircuit.getCalamityTimer());
            }
            getWorld().removeObject(shortCircuit);
        }
        
        if(getCalamityTimer() != null){
            getWorld().removeObject(getCalamityTimer());
        }
    }
}