import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class CalCarCrash extends Calamities{

    // Creating a boolean to check for first act.
    private boolean firstAct;

    public CalCarCrash(){
        setImage("carCrash.png");
        firstAct = true;
    }
    
    public void act(){
        super.act();
        
        if(firstAct == true){
            createTimer("Cars have crashed:   "); // Creating new timer.
            firstAct = false;
        }
    }
    
    public void removeCalamity(){
        removeCalamityTimer();
        CalStreetFlooding myStreetFlooding = (CalStreetFlooding) getOneObjectAtOffset(8, 8, CalStreetFlooding.class);
        myStreetFlooding.resetHasCarCrash();
        getWorld().removeObject(this);
    }
    
    public boolean getFirstAct(){
        return firstAct;
    }
    
    // If removed: reset hasCarCrash in CalStreetFlooding (so we can spawn new ones).
}
