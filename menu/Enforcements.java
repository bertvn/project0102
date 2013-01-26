import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author      RU Development
 * @version     1.0
 * @since       26-01-2013
 */
public class Enforcements extends TimeInformation{
    
    private EnforcementTimer enforcementTimer;
    private boolean isBusy;
    private String enfType;
    
    /**
     * Constructor for this class that sets the type of enforcement associated with it.
     * @param Requires a string based value of what enforcement it belongs to.
     */
    public Enforcements(String enfTypeVal){
        enfType = enfTypeVal;
    }
    
    /**
     * Method to create a timer in the world we are in.
     * @param Requires a X coordinate and the minimum running time in seconds 
     */
    public void createTimer(int xCoordinate, int minimumTime){ // create timer on given xCoordinate
        createTimeInformation(minimumTime, 5);
        
        enforcementTimer = new EnforcementTimer("Bezig: ", super.getTimeLeft(), super.getTimeEnd());
        getWorld().addObject(enforcementTimer, xCoordinate, 585);
    }
    
    /**
     * Method to remove the timer linked to this object.
     */
    public void removeEnforcementTimer(){
        getWorld().removeObject(enforcementTimer);
        enforcementTimer = null;
    }
    
    /**
     * Method to set the enforcement status (will also chance image and create timer if needed).
     * @params Requires the new true or false status of this enforcement..
     */
    public void isNowBusy(boolean status){
        if(status){
            newStatus(status); // True = busy image + new timer.
        }else{
            resetStatus(status); // False = reset the image to available.
        }
    }

    /**
     * Method will set the image busy and create a new timer.
     * @params Requires the new true or false status of this enforcement.
     */
    private void newStatus(boolean status){
        setImage("controlecentrum/" + enfType + "Used.png"); // display normal image.
        isBusy = status;
        
        if(enfType == "EnfFirefighter"){
            createTimer(396, 12);
        }else if(enfType == "EnfPolice"){
            createTimer(497, 8);
        }else if(enfType == "EnfAmbulance"){
            createTimer(600, 15);
        }
    }
    
    /**
     * Method will make the enforcement available agian.
     * @params Requires the new true or false status of this enforcement..
     */
    private void resetStatus(boolean status){
        setImage("controlecentrum/" + enfType + ".png"); // display used image.
        isBusy = status;
    }
    
    /**
     * Method to get the enforcement type it belongs to as string.
     */
    public String getEnfType(){
        return enfType;
    }
    
    /**
     * Method to get current status of this enforcment.
     */
    public boolean getStatus(){
        return isBusy;
    }
    
    /**
     * Method to get timer belonging to this enforcement.
     */
    public EnforcementTimer getEnforcementTimer(){
        return enforcementTimer;
    }
}
