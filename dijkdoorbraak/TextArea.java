import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

public class TextArea extends Actor{
    private int stringLength;
    
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 200;
    public static final int HEIGHT = 150;
    
    public TextArea(String input){
        makeImage(input);
    }

    private void makeImage(String input){
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(input, 45, 90);
        setImage(image);
    }
}