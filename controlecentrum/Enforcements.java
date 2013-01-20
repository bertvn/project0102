import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enforcements extends Actor{

    private boolean fireTruckIsBusy;
    private boolean policeCarIsBusy;
    private boolean ambulanceCarIsBusy;
    
    public void act(){
        // Add your action code here.
    }
    
    public void setIsBusy(String value, boolean status){
        if(status){
            setImage(value + "Used.png");
        }else{
            setImage(value + ".png");
        }
    
        if(value == "fireTruck"){
            fireTruckIsBusy = status;
        }else if(value == "policeCar"){
            policeCarIsBusy = status; 
        }else if(value == "ambulanceCar"){
            ambulanceCarIsBusy = status;
        }
        
        /* Switches worden niet ondersteund met Strings.
        switch(value){
            case "fireTruck": 
                fireTruckIsBusy = true; break;
            case "policeCar": 
                policeCarIsBusy = true; break;
            case "ambulance": 
                ambulanceCarIsBusy = true; break;
            default: 
                System.out.println("Enforcement type is not recognized"); break;
        }*/
    }
}
