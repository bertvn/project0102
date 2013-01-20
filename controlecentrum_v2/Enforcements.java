import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class Enforcements extends TimeInformation{

    private boolean fireTruckIsBusy;
    private boolean policeCarIsBusy;
    private boolean ambulanceCarIsBusy;
    
    // Updating the enforcement to the correct image / status.
    public void setIsBusy(String value, boolean status){
        if(status){
            setImage(value + "Used.png"); // display used image.
        }else{
            setImage(value + ".png"); // display normal image.
        }
    
        if(value == "fireTruck"){ // update fireTruck status.
            fireTruckIsBusy = status;
        }else if(value == "policeCar"){ // update fireTruck status.
            policeCarIsBusy = status; 
        }else if(value == "ambulanceCar"){ // update fireTruck status.
            ambulanceCarIsBusy = status;
        }
    }
}
