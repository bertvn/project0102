import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * GravelBags are 1 of the materials that can be used to stop a dike from breaking
 * it extends Materials
 * 
 * @author  RU development 
 * @version 1.0
 */
public class GravelBag extends Materials{  
    
    /**
     * constructor, it sets all info about the material in it's parent class
     */
    public GravelBag(){
        super.setDissolveRate(2);
        super.setSpeedReducement(3);
        super.setBaseHealth(20);
        super.setWeight(2);
        super.setScoreDecrease(150);

        imageCreater(1,501);

    }
    
    /**
     * sets image
     * @param x this decides which image is used
     * @param location this decides wheter or not the amount is printed on the image.
     */
    public void imageCreater(int x, int location){
        GreenfootImage creation;
        //selects image
        if(x == 0){
            creation = new GreenfootImage("dijkdoorbraak/bigGravelBag.png");
        }else{
            if(x==1){
                creation = new GreenfootImage("dijkdoorbraak/greyBigGravelBag.png");
            }else{
                creation = new GreenfootImage("dijkdoorbraak/selectedbigGravelBag.png");
            }
        }
        //if the object is in startposition
        if(location > 500){
            Color fontColor = new Color(0, 0, 0, 255);
            //Color backgroundColor = new Color(255, 255, 255, 255);
            //Color BorderColor = new Color(176, 176, 176, 255);
            Font font = creation.getFont();
            font = font.deriveFont(20.0f);
            creation.setFont(font);
            creation.setColor(fontColor);
            creation.drawString("" + Dijkdoorbraak.getItemsLeft(1),19,42);
        }
        setImage(creation);
    }
}
