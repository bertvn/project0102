import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class CalStreetFlooding extends Calamities{

    // Creating a boolean to check for first act.
    private boolean firstAct;
    private boolean streetIsOpen;
        
    // Variables for short circuit
    private int waitForShortCircuit;
    private boolean hasShortCircuit;
    private CalShortCircuit shortCircuit;
    
    // Variables for car crashes
    private int waitForCarCrash;
    private boolean hasCarCrash;
    private CalCarCrash carCrash;
    
    // Variables or looters
    private int waitForLooters;
    private boolean hasLooters;
    private CalLooters looters;

    public CalStreetFlooding(int imgNr){
        setImage("overstroming" + imgNr + ".png");

        firstAct = true;
        streetIsOpen = true;
        
        // Default time for waiting with a new Short Circuit is about 10s.
        waitForShortCircuit = 600;
        waitForCarCrash = 300;
        waitForLooters = 300;
        hasShortCircuit = false;
        hasCarCrash = false;
        hasLooters = false;
    }
    
    public void act(){
        super.act();
        
        // Creating a new timer in the first act (this can't be done in constructor
        // because the object does not exist yet).
        if(firstAct == true){
            createTimer(60, "Flooded street open: ", "EnfPolice", this);
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
        if(waitForShortCircuit == 0 && !hasShortCircuit){
            if(!Controlecentrum.maxTimersReached){
                if((int) (Math.random() * 600) == 0){ // 1/500th chance on new calamity
                    shortCircuit = new CalShortCircuit();
                    getWorld().addObject(shortCircuit, getX()+9, getY()-21);
                    hasShortCircuit = true;
                }
            }
        }else if(!hasShortCircuit){ // Else if we do not have a short circuit
            waitForShortCircuit--; // decrease waiting time.
        }else{ // We have a short circuit in this street already
            // Check if the timer is not there and it is not his first act.
            if(!shortCircuit.getFirstAct() && shortCircuit.getCalamityTimer() == null){
                // If true it means the timer has reached beyond 0 and is therefor removed.
                getWorld().removeObject(shortCircuit);
                resetHasShortCircuit();
            }
        }
    }
    
    public void carCrashAct(){
        // If the street is open and we do not yet have a car crash.
        if(streetIsOpen){
            if(waitForCarCrash == 0 && !hasCarCrash){
                if(!Controlecentrum.maxTimersReached){
                    if((int) (Math.random() * 1000) == 0){ // spawn 1 with a 1/1200th chance.
                        carCrash = new CalCarCrash();
                        getWorld().addObject(carCrash, getX()+26, getY()+8);
                        hasCarCrash = true;
                    }
                }
            }else if(!hasCarCrash && streetIsOpen){
                waitForCarCrash--;
            }else{
                if(!carCrash.getFirstAct() && carCrash.getCalamityTimer() == null){
                    System.out.println("True");
                    // If true it means the timer has reached beyond 0 and is therefor removed.
                    getWorld().removeObject(carCrash);
                    resetHasCarCrash();
                }
            }
        }
    }
    
    public void lootersAct(){
        // If the street is closed and we do not yet have a car crash.
        if(!streetIsOpen){
            if(waitForLooters == 0 && !hasLooters){
                if(!Controlecentrum.maxTimersReached){
                    if((int) (Math.random() * 1100) == 0){ // spawn 1 with a 1/1200th chance.
                        looters = new CalLooters();
                        getWorld().addObject(looters, getX()-8, getY()+8);
                        hasLooters = true;
                    }
                }
            }else if(!hasLooters){
                waitForLooters--;
            }else{ // if we have a car crash
                if(!looters.getFirstAct() && looters.getCalamityTimer() == null){
                    // If true it means the timer has reached beyond 0 and is therefor removed.
                    getWorld().removeObject(looters);
                    resetHasLooters();
                }
            }
        }
    }
    
    public void closeStreet(){
        streetIsOpen = false;
    }
    
    public void resetHasCarCrash(){
        hasCarCrash = false;
        waitForCarCrash = 350; // Create waiting time of about 5s.
    }
    
    public void resetHasShortCircuit(){
        hasShortCircuit = false;
        waitForShortCircuit = 400; // Create waiting time of about 5s.
    }
    
    public void resetHasLooters(){
        hasLooters = false;
        waitForLooters = 400; // Create waiting time of about 5s.
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