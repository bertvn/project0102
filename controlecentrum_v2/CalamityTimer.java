import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CalamityTimer extends Timers{

    //private int streetFloodingRefNr;

    public CalamityTimer(String prefix, long timeLeft, long timeEnd){//, int streetFloodingRefNr){
        super(prefix, timeLeft, timeEnd);
        //this.streetFloodingRefNr = streetFloodingRefNr;
    }
    
    public void moveTimerBelow(){
        if(getOneObjectAtOffset(0, 15, CalamityTimer.class) != null){
            CalamityTimer timer = (CalamityTimer) getOneObjectAtOffset(0, 15, CalamityTimer.class);
            timer.moveTimerBelow();
            timer.setLocation(getX(), getY());
        }
    }
    
    /*
    public int getTimerBelow(){
        return getOneObjectAtOffset(0, 15, CalamityTimer.class).getStreetFloodingRefNr();
    }
    
    public int getStreetFloodingRefNr(){
        return streetFloodingRefNr;
    }*/
}
