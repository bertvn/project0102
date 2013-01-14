import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enforcements extends Actor{

    private boolean fireTruckIsBusy;
    private boolean policeCarIsBusy;
    private boolean ambulanceCarIsBusy;
    
    public void act(){
        // Add your action code here.
    }
    
    public void setIsBusy(String value){
        if(value == "fireTruck"){
            fireTruckIsBusy = true;
        }else if(value == "policeCar"){
            policeCarIsBusy = true; 
        }else if(value == "ambulanceCar"){
            ambulanceCarIsBusy = true;
        }
        
        setImage(value + "Used.png");
        
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
