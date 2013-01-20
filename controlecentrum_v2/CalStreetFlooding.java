import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class CalStreetFlooding extends Calamities{

    // Properties of the flooding.
    private boolean streetIsOpen;
    
    // Creating a boolean to check for first act.
    private boolean firstAct;

    public CalStreetFlooding(int imgNr){
        setImage("overstroming" + imgNr + ".png");
        streetIsOpen = true;
        
        firstAct = true;
    }
    
    public void act(){
        super.act();
        
        if(firstAct == true){
            createTimer(); // Creating new timer.
            firstAct = false;
        }
    }
    
     public void closeStreet(){
        streetIsOpen = false;
        removeCalamityTimer();
    }
}