import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
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

    public CalStreetFlooding(int imgNr){
        setImage("controlecentrum/overstroming" + imgNr + ".png");

        firstAct = true;
        streetIsOpen = true;
        
        // Default time for waiting with a new Short Circuit is about 10s.
        waitForShortCircuit = 750;
        waitForCarCrash = 438;
        waitForLooters = 500;
    }
    
    public void act(){
        super.act();
        
        // Creating a new timer in the first act (this can't be done in constructor
        // because the object does not exist yet).
        if(firstAct == true){
            createTimer(75, "Ondergelopen straat: ", "EnfPolice", this);
            firstAct = false;
        }
        
        if(streetIsOpen){
            if(getCalamityTimer() == null){
                closeStreet();
            }
        }
        
        shortCircuitAct(); // Update things that have something to do with the short circuit calamity.
        carCrashAct(); // Update things that have something to do with the car crash calamity.
        lootersAct(); // Update things that have something to do with the looters calamity.
    }
    
    public void shortCircuitAct(){
        // If the waiting time has reached zero and we do not yet have a short circuit
        if(waitForShortCircuit == 0){
            if(!Controlecentrum.maxTimersReached){
                if((int) (Math.random() * 750) == 0){ // 1/500th chance on new calamity
                    shortCircuit = new CalShortCircuit();
                    getWorld().addObject(shortCircuit, getX()+9, getY()-21);
                    waitForShortCircuit = 1700;
                }
            }
        }else{ // Else if we do not have a short circuit
            waitForShortCircuit--; // decrease waiting time.
        }
    }
    
    public void carCrashAct(){
        // If the street is open and we do not yet have a car crash.
        if(streetIsOpen){
            if(waitForCarCrash == 0){
                if(!Controlecentrum.maxTimersReached){
                    if((int) (Math.random() * 1250) == 0){ // spawn 1 with a 1/1200th chance.
                        carCrash = new CalCarCrash();
                        getWorld().addObject(carCrash, getX()+26, getY()+8);
                        waitForCarCrash = 1000;
                    }
                }
            }else{
                waitForCarCrash--;
            }
        }
    }
    
    public void lootersAct(){
        // If the street is closed and we do not yet have a car crash.
        if(!streetIsOpen){
            if(waitForLooters == 0){
                if(!Controlecentrum.maxTimersReached){
                    if((int) (Math.random() * 1375) == 0){ // spawn 1 with a 1/1200th chance.
                        looters = new CalLooters();
                        getWorld().addObject(looters, getX()-8, getY()+8);
                        waitForLooters = 1700;
                    }
                }
            }else{
                waitForLooters--;
            }
        }
    }
    
    public void closeStreet(){
        streetIsOpen = false;
    }
    
    public void removeAllObjects(){
        if(looters != null){
            if(looters.getCalamityTimer() != null){
                getWorld().removeObject(looters.getCalamityTimer());
            }
            
            getWorld().removeObject(looters);
        }
        
        if(carCrash != null){
            if(carCrash.getCalamityTimer() != null){
                getWorld().removeObject(carCrash.getCalamityTimer());
            }
            
            getWorld().removeObject(carCrash);
        }
        
        if(shortCircuit != null){
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