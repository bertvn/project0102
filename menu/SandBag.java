import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Sandbags are 1 of the materials that can be used to stop a dike from breaking
 * it extends Materials
 * 
 * @author  RU development 
 * @version 1.0
 */
public class SandBag extends Materials{
    
    /**
     * constructor, it sets all info about the material in it's parent class
     */
    public SandBag(){
        super.setDissolveRate(3);
        super.setSpeedReducement(2);
        super.setBaseHealth(20);
        super.setWeight(2);
        super.setScoreDecrease(100);

        imageCreater(1,501);
    }

    /**
     * sets image
     * @param x this decides which image is used
     * @param location this decides wheter or not the amount is printed on the image.
     */
    @Override
    public void imageCreater(int x, int location){
        GreenfootImage creation;
        //selects image
        if(x == 0){
            creation = new GreenfootImage("dijkdoorbraak/bigSandBag.png");
        }else{
            if(x==1){
                creation = new GreenfootImage("dijkdoorbraak/greyBigSandBag.png");
            }else{
                creation = new GreenfootImage("dijkdoorbraak/selectedbigSandBag.png");
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
            creation.drawString("" + Dijkdoorbraak.getItemsLeft(2),19,42);
        }
        setImage(creation);
    }
}

