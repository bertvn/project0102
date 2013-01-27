import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * the police enforcer class
 * 
 * @author  RU development 
 * @version 1.0
 */
public class EnfPolice extends Enforcements {
    
    /**
     * Constructor for this class. Sets default image and his type.
     */
    public EnfPolice(){
        super("EnfPolice");
        setImage("controlecentrum/EnfPolice.png");
    }
    
    /**
     * Method to change the current status.
     * @param status contains wheter or not police is busy
     */
    private void setIsBusy(boolean status){
        isNowBusy(status);
    }
    
    /**
     * This method runs every act and will update the timer and start removing
     * procedure if it reached 0.
     */
    public void act(){
        if(getEnforcementTimer() != null){
            long currentTimeLeft = super.getTimeLeft();
            if(currentTimeLeft <= 0){
                removeEnforcementTimer();
                setIsBusy(false); // reset status to available
            }else{
                getEnforcementTimer().setCurrentValue(super.getTimeLeft());
            }
        }
    }
}