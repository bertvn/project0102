import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Paper extends Materials{
    public Paper(){
        super.setDissolveRate(5);
        super.setSpeedReducement(0);
        super.setBaseHealth(20);
        super.setWeight(0);
        super.setScoreDecrease(10);
        setImage("dijkdoorbraak/greyPaper.png");
    }

    public void act(){
        
    }
    
    public void select(){
        setImage("dijkdoorbraak/selectedpaper.png");
    }
    
    //next 2 methods do the same?
    public void deselect(){
        setImage("dijkdoorbraak/paper.png");
    }
    
    public void selectable(){
        setImage("dijkdoorbraak/paper.png");
    }
    
    public void unselectable(){
        setImage("dijkdoorbraak/greyPaper.png");
    }
    
}
