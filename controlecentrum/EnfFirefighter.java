import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EnfFirefighter extends Enforcements {

    public EnfFirefighter(){
        super();
        setImage("fireTruck.png");
    }
    
    public void act(){
        // Add your action code here.
    }
    
    public void setIsBusy(boolean status){
        super.setIsBusy("fireTruck", status);
    }
}
