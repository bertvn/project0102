import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class Highscore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Highscore extends Actor
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
    private String[] highScoreName = new String[10];
    private int[] highScoreScore = new int[10];
    private int lineLength;
    private int padding;
    private int height;
    private int width;
    private int fontSize;
    private int borderSize;
   
    /* <---- */
    
    public Highscore() {
        
        /* prepare highscores */
        getHighscores();
        
        // preparing variables
        lineLength = 51; 
        fontSize = 24; 
        textColor = new Color(0, 0, 0); 
        
        // preparing the text string
        for(int i = 0; i < lineLength; i++) { /* For every character in the line go through the loop 
                                               * the line will always be 51 characters (/digits) long
                                               * knowing that: HIGHSCORES = 12 caracters long 
                                               * means that after charactar 19 has been reached in the line
                                               * then the header: HIGHSCORES need to be printed to be 
                                               * exactly in the middle. 
                                               * (51 - 12) / 2 = 19;
                                               */
            if(i < 19 || i > 32) {
                text = text + "\b";
            } else if(i == 19) {
                text = text + " HIGHSCORES ";
            }
        }
        text = text + "\n\n"; // go to next line

        // preparing all the highscores
        for(int i = 0; i < 10; i++) { /* For every character in the line go through the loop 
                                       * the line will always be 51 caracters (/digits) long
                                       * Calculation PSEUDO
                                       * PRINT highscoreName
                                       * PRINT /b as long as lineLenght - amount of digits in score
                                       * is not reach
                                       * PRINT score
                                       * go to next line
                                       * 
                                       * calculation:
                                       * i > highScoreName = startPrinting spaces (/b)
                                       * (lineLenght - scoreLenght) = stopPrinting spaces (/b);
                                       */
            
            text = text + highScoreName[i]; // add the name to the string
            text = text + highScoreName[i].length();
            for(int j = 0; j < lineLength; j++) {
                
                // this should normally be enough but not for greenfoot
                int startPrint = highScoreName[i].length(); 
                
                /* greenfoot ajustment only -> */
                if(startPrint == 11) {
                    startPrint = 10;
                } else if(startPrint == 12) {
                    startPrint = 11;
                } else if(startPrint == 17) {
                    startPrint = 15;
                }
                
                /* <-------------------------  */
                // if i > highscorename amount of caracters  AND smaller then linelength minus the amount of digits
                if(j > startPrint                            &&  j < (lineLength - String.valueOf(highScoreScore[0]).length())) {
                    text = text + "\b";
                }
            }
            
            text = text + highScoreScore[i]; // add the score to the string
            text = text + "\n"; // go to next line
        }
        // add last line 
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
    
    private void getHighscores() {
        highScoreName[0] = "RU development"; 
        highScoreScore[0] = 9804;
        
        highScoreName[1] = "Bob Joziasse"; 
        highScoreScore[1] = 9204;

        highScoreName[2] = "Stelian Paraschiv"; 
        highScoreScore[2] = 8804;
        
        highScoreName[3] = "Bob Eleveld"; 
        highScoreScore[3] = 8803;

        highScoreName[4] = "Jesse Tjang"; 
        highScoreScore[4] = 8012;
        
        highScoreName[5] = "RU development"; 
        highScoreScore[5] = 7004;
        
        highScoreName[6] = "RU development"; 
        highScoreScore[6] = 6904;
        
        highScoreName[7] = "RU development"; 
        highScoreScore[7] = 5807;
        
        highScoreName[8] = "Wendy Kleij"; 
        highScoreScore[8] = 4301;
        
        highScoreName[9] = "RU development"; 
        highScoreScore[9] = 3784;       
        
    } 
}
