import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author      RU Development
 * @version     1.0
 * @since       26-01-2013
 */
public class CalShortCircuit extends Calamities{

    private boolean firstAct;
    private int imageChanger;
    private int imageSwitch;
    
    /**
     * Constructor for this object, to set it's default image and firstAct.
     */
    public CalShortCircuit(){
        setImage("controlecentrum/shortCircuit.png");
        firstAct = true;
        imageChanger = 0;
        imageSwitch = 0;
    }

    /**
     * A method that calls for the parents' act, creates a timer on first act,
     * and blinks the image for the first couple of seconds.
     */
    public void act(){
        super.act();
        
        // Creating a new timer in the first act (this can't be done in constructor
        // because the object does not exist yet).
        if(firstAct == true){
            createTimer(32, "Kortsluiting, brand:  ", "EnfFirefighter", this);
            firstAct = false;
        }
        
        // Blinking image on start
        if(imageChanger < 360){
            if(imageChanger % 30 == 0){
                switch(imageSwitch){
                    case 0: setImage("controlecentrum/shortCircuit.png"); imageSwitch = 1; break;
                    case 1: setImage("controlecentrum/burningImage.png"); imageSwitch = 0; break;
                }
            }
            imageChanger++;
        }
    }
}
