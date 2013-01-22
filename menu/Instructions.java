import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends Actor
{
    /**
     * Act - do whatever the Highscore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /* image attributes -> */
    private GreenfootImage textImage;
    private GreenfootImage image; 
    private Color outerColor;
    private Color textColor;
    private Color innerColor;
    private String text = "";
    private String[] pages = new String[10];
    private int lineLength;
    private int padding;
    private int height;
    private int width;
    private int fontSize;
    private int borderSize;
   
    /* <---- */
    
    public Instructions() {
        
        /* prepare highscores */
        getPages();
        
        // preparing variables
        lineLength = 51; 
        fontSize = 24; 
        textColor = new Color(0, 0, 0); 
        
        // preparing the text string
        for(int i = 0; i < lineLength; i++) { /* For every character in the line go through the loop 
                                               * the line will always be 51 characters (/digits) long
                                               * knowing that: INSTRUCTIONS = 14 caracters long 
                                               * means that after charactar 18 has been reached in the line
                                               * then the header: HIGHSCORES need to be printed to be 
                                               * exactly in the middle. 
                                               * (51 - 14) / 2 = 18;
                                               */
            if(i < 18 || i > 31) {
                text = text + "\b";
            } else if(i == 19) {
                text = text + " INSTRUCTIONS ";
            }
        }
        text = text + "\n\n"; // go to next line

        // placing the text of the current page
        text = text + pages[0];        
        
        text = text + "\n\n"; // skip 2 lines
        for(int i = 0; i < lineLength; i++) {
            if(i < 17 || i > 34) {
                text = text + "\b";
            } else if(i == 17) {
                text = text + " CLICK TO CLOSE ";
            }
        }       
               
        // make the image 
        textImage = new GreenfootImage(text, fontSize, textColor, new Color(0, 0, 0, 0)); 
        
        // preparing variables
        padding = 60;
        width = textImage.getWidth() + padding; 
        height = textImage.getHeight() + padding; 
        
        // make the image
        image = new GreenfootImage(width, height);  

        // update image
        outerColor = new Color(0, 0, 0, 160);   
        image.setColor(outerColor);  
        image.fill();  
        innerColor = new Color(255, 255, 255); 
        image.setColor(innerColor);  
        
        // prepare variables
        borderSize = fontSize/8;
        image.fillRect(borderSize, borderSize, image.getWidth()-fontSize/4, image.getHeight()-fontSize/4);   
        image.drawImage(textImage, (image.getWidth()-textImage.getWidth())/2, (image.getHeight()-textImage.getHeight())/2);  
        
        // place the image
        setImage(image);
    }
    
    private void getPages() {
         // first page tekst
         pages[0] = "Rotterdam verkeerd in zwaar weer met veel regen en \n " +
                    "een harde wind. Het water stijgt snel en niets lijkt \n "+
                    "het water te kunnen stoppen voor het rotterdam in stroomd. \n\n" +
                    "Het spel bestaat uit 5 dagen. In deze 5 dagen is het de bedoeling  \n" +
                    "dat je calamiteiten oplost door elke dag 1 tot 3 minigames  \n" +
                    "te voltooien. \n\n" +
                    "Druk op een icoontje op de kaart om het spel te starten.\n" +
                    "Elk spel draait om 1 onderwerp: voorkom slachtoffers! ";
        
    } 
}


