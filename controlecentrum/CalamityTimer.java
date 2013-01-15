import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CalamityTimer extends BusyTimer{
    
    private int belongsToFloodNumber;

    public CalamityTimer(String prefix, long currentValue, long targetValue, int floodNumber){
        super(prefix, currentValue, targetValue);
        belongsToFloodNumber = floodNumber;
    }
    
    public void act(){
        // Add your action code here.
    }
    
    public void setCurrentValue(long newTime){
        super.setCurrentValue(newTime);
    }
}
