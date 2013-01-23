import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class CalLooters extends Calamities{

    // Creating a boolean to check for first act.
    private boolean firstAct;

    public CalLooters(){
        setImage("looters.png");
        firstAct = true;
    }
    
    public void act(){
        super.act();
        
        // Creating a new timer in the first act (this can't be done in constructor
        // because the object does not exist yet).
        if(firstAct == true){
            createTimer(32, "Looters in building: ", "EnfPolice", this); // Creating new timer.
            firstAct = false;
        }
    }
    
    // Method to remove the timer and allow CalStreetFlooding to create a new
    // calamity with looters in this street.
    public void removeCalamity(){
        removeCalamityTimer();
        CalStreetFlooding myStreetFlooding = (CalStreetFlooding) getOneObjectAtOffset(8, 8, CalStreetFlooding.class);
        myStreetFlooding.resetHasLooters();
        getWorld().removeObject(this);
    }
    
    // Method to return wheter this is his first act or not.
    public boolean getFirstAct(){
        return firstAct;
    }
}
