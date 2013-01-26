import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

public class Cardboard extends Materials{

    /**
     * constructor, it sets all info about the material in it's parent class
     */
    public Cardboard(){
        super.setDissolveRate(4);
        super.setSpeedReducement(1);
        super.setBaseHealth(20);
        super.setWeight(1);
        super.setScoreDecrease(20);

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
            creation = new GreenfootImage("dijkdoorbraak/cardboard.png");
        }else{
            if(x==1){
                creation = new GreenfootImage("dijkdoorbraak/greyCardboard.png");
            }else{
                creation = new GreenfootImage("dijkdoorbraak/selectedcardboard.png");
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
            creation.drawString("" + Dijkdoorbraak.getItemsLeft(3),19,35);
        }
        setImage(creation);
    }
}
