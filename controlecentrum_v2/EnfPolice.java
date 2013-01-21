import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class EnfPolice extends Enforcements {
    
    public EnfPolice(){
        super();
        setImage("policeCar.png");
    }
    
    // Change status to input.
    public void setIsBusy(boolean status){
        setIsBusy("policeCar", status);
        createTimer(497);
    }
    
    // Update the timer and start removing procedure if it reached 0.
    public void act(){
        if(enforcementTimer != null){
            long currentTimeLeft = super.getTimeLeft();
            if(currentTimeLeft <= 0){
                removeEnforcementTimer();
                setIsBusy("policeCar", false); // reset status to available
            }else{
                enforcementTimer.setCurrentValue(super.getTimeLeft());
            }
        }
    }
}
