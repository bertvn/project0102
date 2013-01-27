import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * TheMessage class is used to print a string
 * 
 * @author RU Development 
 * @version 1.0
 */
public class TheMessage extends TextDisplay{
    
    /**
     * prints string
     * @param input string that is printed
     */
    public TheMessage(String input){
        setBackgroundColor(255, 255, 255, 160);
        setBorderColor(0, 0, 0, 160);
        setField(480, 150);
        setFontSize(30.0f);
        setBorder(5, 5);
        setDrawString(50, 90);
        setInput(input);
        setHasBackground(true);
      
        createTextBox();
    }    
}
