import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class CalCarCrash extends Calamities{

    private boolean firstAct;

    public CalCarCrash(){
        setImage("carCrash.png");
        firstAct = true;
    }
    
    public void act(){
        super.act();
        
        // Creating a new timer in the first act (this can't be done in constructor
        // because the object does not exist yet).
        if(firstAct == true){
            createTimer(32, "Cars have crashed:   ", "EnfAmbulance", this);
            firstAct = false;
        }
    }
    
    // Method to remove the timer and allow CalStreetFlooding to create a new
    // car crash in this street.
    public void removeCalamity(){
        removeCalamityTimer();
        CalStreetFlooding myStreetFlooding = (CalStreetFlooding) getOneObjectAtOffset(8, 8, CalStreetFlooding.class);
        myStreetFlooding.resetHasCarCrash();
        getWorld().removeObject(this);
    }
    
    // Method to return wheter this is his first act or not.
    public boolean getFirstAct(){
        return firstAct;
    }
}
