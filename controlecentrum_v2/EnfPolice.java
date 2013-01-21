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
    
    public void act(){
        if(enforcementTimer != null){
            long currentTimeLeft = super.getTimeLeft();
            if(currentTimeLeft <= 0){
                removeEnforcementTimer();
                setIsBusy("policeCar", false);
            }else{
                enforcementTimer.setCurrentValue(super.getTimeLeft());
            }
        }
    }
}
