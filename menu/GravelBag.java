import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GravelBag extends Materials{  
    
    public GravelBag(){
        super.setDissolveRate(2);
        super.setSpeedReducement(3);
        super.setBaseHealth(20);
        super.setWeight(2);
        super.setScoreDecrease(150);
        setImage("dijkdoorbraak/greyBigGravelBag.png");
    }

    public void act(){
    }
    
    public void select(){
        setImage("dijkdoorbraak/selectedbigGravelBag.png");
    }
    
    public void deselect(){
        setImage("dijkdoorbraak/bigGravelBag.png");
    }
    
    public void selectable(){
        setImage("dijkdoorbraak/bigGravelBag.png");
    }
    
    public void unselectable(){
        setImage("dijkdoorbraak/greyBigGravelBag.png");
    }
}