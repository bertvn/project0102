import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author      RU Development
 * @version     1.0
 * @since       26-01-2013
 */
public class CalCarCrash extends Calamities{

    private boolean firstAct;

    /**
     * Constructor for this object, to set it's default image and firstAct.
     */
    public CalCarCrash(){
        setImage("controlecentrum/carCrash.png");
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
            createTimer(32, "Gewonden bij ongeval: ", "EnfAmbulance", this);
            firstAct = false;
        }
    }
}
