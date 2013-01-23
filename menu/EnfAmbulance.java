import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class EnfAmbulance extends Enforcements {
    
    public EnfAmbulance(){
        super("EnfAmbulance");
        setImage("controlecentrum/EnfAmbulance.png");
    }
    
    // Change status to input.
    public void setIsBusy(boolean status){
        isNowBusy(status);
    }
    
    // Update the timer and start removing procedure if it reached 0.
    public void act(){
        if(enforcementTimer != null){
            long currentTimeLeft = super.getTimeLeft();
            if(currentTimeLeft <= 0){
                removeEnforcementTimer();
                setIsBusy(false); // reset status to available
            }else{
                enforcementTimer.setCurrentValue(super.getTimeLeft());
            }
        }
    }
}