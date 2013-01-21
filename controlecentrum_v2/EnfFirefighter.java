import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class EnfFirefighter extends Enforcements {
    
    public EnfFirefighter(){
        super();
        setImage("fireTruck.png");
    }
    
    // Change status to input.
    public void setIsBusy(boolean status){
        setIsBusy("fireTruck", status);
        createTimer(396);
    }
    
    public void act(){
        if(enforcementTimer != null){
            long currentTimeLeft = super.getTimeLeft();
            if(currentTimeLeft <= 0){
                removeEnforcementTimer();
                setIsBusy("fireTruck", false);
            }else{
                enforcementTimer.setCurrentValue(super.getTimeLeft());
            }
        }
    }
}
