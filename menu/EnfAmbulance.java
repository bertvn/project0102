import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * the ambulance enforcer class
 * 
 * @author  RU development 
 * @version 1.0
 */
public class EnfAmbulance extends Enforcements {
    
    /**
     * Constructor for this class. Sets default image and his type.
     */
    public EnfAmbulance(){
        super("EnfAmbulance");
        setImage("controlecentrum/EnfAmbulance.png");
    }
    
    /**
     * Method to change the current status.
     * @param status contains wheter or not ambulance is busy
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