import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class CalamityTimer extends Timers{

    public CalamityTimer(String prefix, long timeLeft, long timeEnd){//, int streetFloodingRefNr){
        super(prefix, timeLeft, timeEnd);
    }
    
    public void moveTimerBelow(){
        if(getOneObjectAtOffset(0, 15, CalamityTimer.class) != null){
            CalamityTimer timer = (CalamityTimer) getOneObjectAtOffset(0, 15, CalamityTimer.class);
            timer.moveTimerBelow();
            timer.setLocation(getX(), getY());
        }
    }
}
