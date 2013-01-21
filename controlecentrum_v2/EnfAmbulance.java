import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class EnfAmbulance extends Enforcements {
    
    public EnfAmbulance(){
        super();
        setImage("ambulanceCar.png");
    }
    
    // Change status to input.
    public void setIsBusy(boolean status){
        setIsBusy("ambulanceCar", status);
        createTimer(600);
    }
    
    // Update the timer and start removing procedure if it reached 0.
    public void act(){
        if(enforcementTimer != null){
            long currentTimeLeft = super.getTimeLeft();
            if(currentTimeLeft <= 0){
                removeEnforcementTimer();
                setIsBusy("ambulanceCar", false); // reset status to available
            }else{
                enforcementTimer.setCurrentValue(super.getTimeLeft());
            }
        }
    }
}
