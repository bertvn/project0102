import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

public class Paper extends Materials{

    /**
     * constructor, it sets all info about the material in it's parent class
     */
    public Paper(){
        super.setDissolveRate(5);
        super.setSpeedReducement(0);
        super.setBaseHealth(20);
        super.setWeight(0);
        super.setScoreDecrease(10);
        imageCreater(1,501);
    }

    public void act(){
        
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
            creation = new GreenfootImage("dijkdoorbraak/paper.png");
        }else{
            if(x==1){
                creation = new GreenfootImage("dijkdoorbraak/greyPaper.png");
            }else{
                creation = new GreenfootImage("dijkdoorbraak/selectedpaper.png");
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
            creation.drawString("" + Dijkdoorbraak.getItemsLeft(4),20,35);
        }
        setImage(creation);
    }
}
