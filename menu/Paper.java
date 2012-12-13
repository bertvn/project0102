import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Paper extends Materials{
    public Paper(){
        super.setDissolveRate(5);
        super.setSpeedReducement(0);
        super.setBaseHealth(20);
        super.setWeight(0);
        setImage("dijkdoorbraak/paper.png");
    }

    public void act(){
        
    }
    
    public void select(){
        setImage("dijkdoorbraak/selectedpaper.png");
    }
    
    public void deselect(){
        setImage("dijkdoorbraak/paper.png");
    }
}
