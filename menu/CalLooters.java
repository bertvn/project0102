import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author      RU Development
 * @version     1.0
 * @since       26-01-2013
 */
public class CalLooters extends Calamities{

    private boolean firstAct;

    /**
     * Constructor for this object, to set it's default image and firstAct.
     */
    public CalLooters(){
        setImage("controlecentrum/looters.png");
        firstAct = true;
    }
    
    /**
     * A method that calls for the parents' act and creates a timer on first act.
     */
    public void act(){
        super.act();
        
        // Creating a new timer in the first act (this can't be done in constructor
        // because the object does not exist yet).
        if(firstAct == true){
            createTimer(32, "Plundering aan gang:  ", "EnfPolice", this); // Creating new timer.
            firstAct = false;
        }
    }
}
