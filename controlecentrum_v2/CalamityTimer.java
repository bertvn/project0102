import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CalamityTimer extends Timers{

    private int streetFloodingRefNr;

    public CalamityTimer(String prefix, long timeLeft, long timeEnd, int streetFloodingRefNr){
        //super(prefix, timeLeft, timeEnd);
        this.streetFloodingRefNr = streetFloodingRefNr;
    }
    
    /* public void setCurrentValue(long newTime){
        super.setCurrentValue(newTime);
    } */
}
