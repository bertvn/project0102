import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DisplayTopPanel extends TextDisplay{

    public DisplayTopPanel(int DAY){
        super();
        setTheGreenfootImage("opmaak/topPanel.png");
        setFontColor(255, 255, 255, 0);
        setDrawString(40, 28);
        setInput("Dag " + DAY);
        
        createTextBox();
    }    
}
