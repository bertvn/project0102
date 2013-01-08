import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CalamityTimer extends BusyTimer{

    public CalamityTimer(String prefix, long currentValue, long targetValue){
        super(prefix, currentValue, targetValue);
    }
    
    public void act(){
        // Add your action code here.
    }
    
    public void setCurrentValue(long newTime){
        super.setCurrentValue(newTime);
    }
}
