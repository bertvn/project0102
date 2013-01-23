import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

public class CementBag extends Materials{
    public CementBag(){
        super.setDissolveRate(1);
        super.setSpeedReducement(4);
        super.setBaseHealth(20);
        super.setWeight(3);
        super.setScoreDecrease(300);

        imageCreater(1,501);
    }

    public void act(){
        
    }
    
    public void imageCreater(int x, int location){
        GreenfootImage creation;
        //selects image
        if(x == 0){
            creation = new GreenfootImage("dijkdoorbraak/bigCementBag.png");
        }else{
            if(x==1){
                creation = new GreenfootImage("dijkdoorbraak/greyBigCementBag.png");
            }else{
                creation = new GreenfootImage("dijkdoorbraak/selectedbigCementBag.png");
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
            creation.drawString("" + Dijkdoorbraak.getItemsLeft(0),19,42);
        }
        setImage(creation);
    }
}

