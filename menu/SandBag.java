import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

public class SandBag extends Materials{
    public SandBag(){
        super.setDissolveRate(3);
        super.setSpeedReducement(2);
        super.setBaseHealth(20);
        super.setWeight(2);
        super.setScoreDecrease(100);
        imageCreater(1,501);
    }

    public void act(){
        
    }
    
    public void select(){
        imageCreater(2, 501);
    }
    
    //next 2 methods do the same?
    public void deselect(){
        imageCreater(0, 409);
    }
    
    public void selectable(){
        imageCreater(0, getY());
    }
    
    public void unselectable(){
        imageCreater(1, 501);
    }
     
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
            creation.drawString("" + Dijkdoorbraak.getItemsLeft(2),20,37);
        }
        setImage(creation);
    }
}

