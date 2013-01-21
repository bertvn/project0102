import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class CalShortCircuit extends Calamities{

    private boolean firstAct;
    private int imageChanger;
    private int imageSwitch;

    public CalShortCircuit(){
        setImage("shortCircuit.png");
        firstAct = true;
        imageChanger = 0;
        imageSwitch = 0;
    }
    
    public void act(){
        super.act();
        
        // Creating a new timer in the first act (this can't be done in constructor
        // because the object does not exist yet).
        if(firstAct == true){
            createTimer("Short circuit, fire: ");
            firstAct = false;
        }
        
        // Blinking image on start to show player it is a short circuit that creates
        // a fire on this spot.
        if(imageChanger < 360){
            if(imageChanger % 30 == 0){
                switch(imageSwitch){
                    case 0: setImage("shortCircuit.png"); imageSwitch = 1; break;
                    case 1: setImage("burningImage.png"); imageSwitch = 0; break;
                }
            }
            imageChanger++;
        }
    }
    
    // Method to remove the timer and allow CalStreetFlooding to create a new
    // short circuit in this street.    
    public void removeCalamity(){
        removeCalamityTimer();
        CalStreetFlooding myStreetFlooding = (CalStreetFlooding) getOneObjectAtOffset(8, 8, CalStreetFlooding.class);
        myStreetFlooding.resetHasShortCircuit();
        getWorld().removeObject(this);
    }
    
    // Method to return wheter this is his first act or not.
    public boolean getFirstAct(){
        return firstAct;
    }
}
