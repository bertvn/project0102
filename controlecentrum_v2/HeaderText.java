import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class HeaderText extends TextDisplay{
   
    public HeaderText(String input){
        setFontColor(0, 0, 0, 0);
        setBackgroundColor(255, 255, 255, 255);
        setBorderColor(176, 176, 176, 255);
        setField(30, 220);
        setDrawString(6, 22);
        setInput(input);
        createTextBox();
    }
}
