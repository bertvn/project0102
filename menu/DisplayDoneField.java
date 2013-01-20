import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DisplayDoneField extends TextDisplay{
    
    public DisplayDoneField(int minigamesPlayed){
        super();

        setFontColor(0, 0, 0, 0);
        setBackgroundColor(255, 255, 255, 255);
        setBorderColor(176, 176, 176, 255);
        setField(30, 220);
        setBorder(2, 2);
        setDrawString(6, 22);
        setInput(String.valueOf(new Integer(minigamesPlayed)));
        setHasBackground(true);
        
        createTextBox();
    }
}
