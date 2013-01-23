import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class CalCarCrash extends Calamities{

    private boolean firstAct;

    public CalCarCrash(){
        setImage("controlecentrum/carCrash.png");
        firstAct = true;
    }
    
    public void act(){
        super.act();
        
        // Creating a new timer in the first act (this can't be done in constructor
        // because the object does not exist yet).
        if(firstAct == true){
            createTimer(32, "Gewonen bij ongeval: ", "EnfAmbulance", this);
            firstAct = false;
        }
    }
    
    // Method to return wheter this is his first act or not.
    public boolean getFirstAct(){
        return firstAct;
    }
}
