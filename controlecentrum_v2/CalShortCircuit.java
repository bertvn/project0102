import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class CalShortCircuit extends Calamities{

    // Creating a boolean to check for first act.
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
        
        if(firstAct == true){
            createTimer("Short circuit, fire: "); // Creating new timer.
            firstAct = false;
        }
        
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
    
    public boolean getFirstAct(){
        return firstAct;
    }
}
