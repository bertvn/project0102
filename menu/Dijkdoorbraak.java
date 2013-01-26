import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Dijkdoorbraak extends World{

    private boolean gameIsRunning;
    
    private Timer gameTimer;
    private TextDisplay theMessage;
    
    private Policeman policeman;
    private Soldier soldier;
    private Civilian civilian;
    
    private CementBag cementBag;
    private GravelBag gravelBag;
    private SandBag sandBag;
    private Cardboard cardboard;
    private Paper paper;
    private static int[] itemsLeft;

    private Helpers selectedActor = null;
    private Materials selectedMaterials = null;
                    
    private int waitWithDikeSpawns;
    
    private int[] breakingSpots;
    private int[] usedSpots;
    
    private int spotsLeft;
    private int newSpotName;
    private int newSpotX;
    private int newSpotY;
    
    private static int breakThroughPart;
    public static int score;

    /**
     * Constructor of the class WorldSpawner.
     */
    public Dijkdoorbraak(){    
        // Create a new world with 640x640 cells with a cell size of 1x1 pixels.
        super(640, 640, 1);
        gameIsRunning = false;
        
        // Fill the world with objects.
        setBackground("dijkdoorbraak/background.png");
        createItemsLeft();
        startPopulating();
        createSpots();
        breakThroughPart = 0;
        waitWithDikeSpawns = 0;
        spotsLeft = 9;
        
        setPaintOrder(Instructions.class,TextDisplay.class,ScoreDisplayer.class,Civilian.class,Soldier.class,Policeman.class,CementBag.class,SandBag.class,GravelBag.class,Cardboard.class,Paper.class,Dike.class);
        score = 3500;
    }
    
    /**
     * method that is run every act, this is contains everything that makes the class do what it does
     */
    public void act(){
        if(gameIsRunning == true){
            if(waitWithDikeSpawns <= 0){
                if(createDikeObject()){
                    if(anySpotsLeft() && !Timer.done){
                        createNewDike();
                    }else{
                        // Set the waitWithDikeSpawns till after the game, there are no spots left.
                        waitWithDikeSpawns = 10800; // Amount of acts in 3 minutes.
                    }
                }
            }else{
                waitWithDikeSpawns--;
            }
            
            if(breakThroughPart > 0){
                if(breakThroughPart == 1){
                    List<Helpers> allHelpers = getObjects(Helpers.class);
                    List<Materials> allMaterials = getObjects(Materials.class);
                    removeObjects(allHelpers);
                    removeObjects(allMaterials);
                }
                
                if(breakThroughPart == 8){
                    createMessage(320, 320, "Je hebt verloren! Keer terug..");
                    Score.addScore(-500);
                    removeObject(gameTimer);
                    MiniGameMemory.gameFinished();
                    Timer.done = true;
                    gameIsRunning = false;
                }
                
                if(breakThroughPart >= 9){
                    gameTimer.changeWorld();
                }else{
                    setBackground("dijkdoorbraak/background" + breakThroughPart + ".png");
                }
            }
            
            //movement Persona's
            if(Greenfoot.mouseClicked(null)) {
                moveCharacters();
            }
        }
        
        if(Greenfoot.mouseClicked(null)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            List<Instructions> instr = getObjectsAt(mouse.getX(), mouse.getY(), Instructions.class);
            if(!instr.isEmpty()){
                removeObject(instr.get(0));
                gameIsRunning = true;
                
                gameTimer = new Timer("Tijd over: ");
                // Player must prevent the dike from breaking for 1 minute and 30 seconds.
                // Therefor we set the timer to 90 seconds.
                gameTimer.setCurrentValue(90);
                addObject(gameTimer, 320, 25);
                addObject(new ScoreDisplayer(), 579, 25);
            }
            List<TextDisplay> textDisplays = getObjectsAt(mouse.getX(), mouse.getY(), TextDisplay.class);
            if(!textDisplays.isEmpty()){
                Greenfoot.setWorld(new Menu());
            }
        }
    }
    
    /**
     * This method will populate our world with objects.
     */ 
    private void startPopulating(){
        civilian = new Civilian();
        addObject(civilian, 80, 510);
       
        policeman = new Policeman();
        addObject(policeman, 170, 510);
        
        soldier = new Soldier();
        addObject(soldier, 260, 510);
        
        sandBag = new SandBag();
        addObject(sandBag, 70, 605);
        
        gravelBag = new GravelBag();
        addObject(gravelBag, 110, 605);
        
        cementBag = new CementBag();
        addObject(cementBag, 150, 605);
        
        cardboard = new Cardboard();
        addObject(cardboard, 205, 609);
                
        paper = new Paper();
        addObject(paper, 265, 609);
        
        //createMessage(320, 320, "Get ready! Click to start..");
        addObject(new Instructions(1),320,320);
    }
    
    /**
     * creates message image
     * @param xCoord The x coord of where the image will spawn
     * @param yCoord The y coord of where the image will spawn
     * @param message The message that will be shown
     */
    private void createMessage(int xCoord, int yCoord, String message){
        theMessage = new TextDisplay();
        theMessage.setBackgroundColor(255, 255, 255, 160);
        theMessage.setBorderColor(0, 0, 0, 160);
        theMessage.setField(480, 150);
        theMessage.setFontSize(30.0f);
        theMessage.setBorder(5, 5);
        theMessage.setDrawString(50, 90);
        theMessage.setInput(message);
        theMessage.setHasBackground(true);
        
        theMessage.createTextBox();
        addObject(theMessage, xCoord, yCoord);
    }
    
    /**
     * creates spots for Dike objects to spawn
     */
    private void createSpots(){
        // breakingSpots: # of dike, x-Coordinate, y-Coordinate
        breakingSpots = new int[]{
            1, 40, 366,
            2, 101, 365,
            3, 163, 363,
            4, 225, 362,
            5, 327, 363,
            6, 389, 364,
            7, 453, 368,
            8, 517, 372,
            9, 580, 377
        };
        
        // Spots in breakingSpots Array where to start.
        usedSpots = new int[]{
            0, 3, 6, 9, 12, 15, 18, 21, 24
        };
    }
    
    /**
     * creates amount of items left
     */
    public void createItemsLeft(){
        // Items left by default: cementbags, gravelbags, sandbags, cardboxes and papers.
        itemsLeft = new int[]{2, 4, 7, 10, 15};
    }
    
    /**
     * sets the itemsleft for a certain material.
     * @param arrayKey this represents the material: 
     * 0 = cementbags 
     * 1 = gravelbags
     * 2 = sandbags
     * 3 = cardboard
     * 4 = paper
     * @param value sets amount of material arrayKey that is available
     */
    public void setItemsLeft(int arrayKey, int value){
        // set the itemsleft for certain time of material.
        // 5 entries: 0 = cement, 1 = gravel, 2 = sand, 3 = cardboxes and 4 = paper
        itemsLeft[arrayKey] += value;
    }
    
    /**
     * get the itemsleft for a certain material.
     * @param arrayKey this represents the material: 
     * 0 = cementbags 
     * 1 = gravelbags
     * 2 = sandbags
     * 3 = cardboard
     * 4 = paper
     * @return the amount of the specified material that is left
     */
    public static int getItemsLeft(int arrayKey){
        if(arrayKey < 5 && arrayKey >= 0){
            return itemsLeft[arrayKey];
        }else{
            System.out.println("itemsLeft array has only 5 entries: 0 = cementbags, 1 = gravelbags, 2 = sandbags, 3 = cardboxes and 4 = papers.");
            return 0;
        }
    }
    
    /**
     * This will return wheter we will create a dike or not.
     */
    private boolean createDikeObject(){
        if((int) (Math.random()*500)+1 == 1){
            return true;
        }else{    
            return false;
        }
    }

    
    /**
     * Checks if there are spots left to spawn a new breaking dike.
     */
    private boolean anySpotsLeft(){
        if(spotsLeft <= 0){
            return false;
        }else{ // Still spots left.
            findANewSpot();
            spotsLeft--;
            return true;
        }
    }
    
    /**
     * looks for spot to place a new Dike
     */
    private void findANewSpot(){
        int randomSpot;
        boolean foundSpot = false;
        do{
            randomSpot = (int) (Math.random() * 9);
            if(usedSpots[randomSpot] != -1){
                newSpotName = breakingSpots[usedSpots[randomSpot]];
                newSpotX = breakingSpots[usedSpots[randomSpot] + 1];
                newSpotY = breakingSpots[usedSpots[randomSpot] + 2];
                
                usedSpots[randomSpot] = -1;
                
                foundSpot = true;
            }
        }while(!foundSpot);
    }
    
    /**
     * places a new dike at a 'random' coordinate.
     */
    private void createNewDike(){
        // Set the amount of acts to wait for new spawn.
        waitWithDikeSpawns = 300;
        
        // Add the dike-object on the newSpot.
        addObject(new Dike(), newSpotX, newSpotY);
    }
    /**
     * counts up breakThroughPart
     */
    public static void endGame(){
        breakThroughPart++;
    }
    
    /**
     * character, material and dike selection handeling
     */
    public void moveCharacters(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        List<Helpers> hlp = getObjectsAt(mouse.getX(), mouse.getY(), Helpers.class);
        if(!hlp.isEmpty() && !hlp.get(0).isBusy()){
            //select 1
            if(selectedActor != null){
                selectedActor.deselect();
                resetSelectable();
            }
            if(selectedMaterials != null){
                selectedMaterials.unselectable();
                resetSelectable();
            }
            selectedMaterials = null;
            selectedActor = hlp.get(0);
            selectedActor.select();
            selectable(selectedActor.getPower());
            return;
        }
        
        List<Materials> mat = getObjectsAt(mouse.getX(),mouse.getY(), Materials.class);
        if(!mat.isEmpty()&& selectedActor != null){
            //select 1
            if(mat.get(0).getWeight() <= selectedActor.getPower() && mat.get(0).getY() > 500){
                if(selectedMaterials != null){
                    selectedMaterials.selectable();
                }
                selectedMaterials = mat.get(0);
                selectedMaterials.select();
                return;
            }
        }
        
        //select all dike objects on current mouse x and y
        List<Dike> dk = getObjectsAt(mouse.getX(), mouse.getY(), Dike.class);
        if(!dk.isEmpty() && selectedMaterials != null){
            //select 1
            Dike selectedDike = dk.get(0);
            selectedActor.startMovement(selectedDike.getX(), selectedDike.getY()+40);
            selectedActor.ScoreDecrease();
            selectedMaterials.ScoreDecrease();
            selectedActor.setHolding(selectedMaterials);
            
            if(CementBag.class.isInstance(selectedMaterials) && !(getItemsLeft(0) <= 1)){
                addObject(new CementBag(), 150, 605);
                setItemsLeft(0, -1);
            }
                
            if(GravelBag.class.isInstance(selectedMaterials) && !(getItemsLeft(1) <= 1)){
                addObject(new GravelBag(), 110, 605);
                setItemsLeft(1, -1);
            }
                
            if(SandBag.class.isInstance(selectedMaterials) && !(getItemsLeft(2) <= 1)){
                addObject(new SandBag(), 70, 605);
                setItemsLeft(2, -1);
            }

            if(Cardboard.class.isInstance(selectedMaterials) && !(getItemsLeft(3) <= 1)){
                addObject(new Cardboard(), 205, 609);
                setItemsLeft(3, -1);
            }
               
            if(Paper.class.isInstance(selectedMaterials) && !(getItemsLeft(4) <= 1)){
                addObject(new Paper(), 265, 609);
                setItemsLeft(4, -1);
            }
            selectedMaterials.deselect();
            removeObject(selectedMaterials);
            
            selectedActor.deselect();
            selectedMaterials.deselect();
            selectedActor = null;
            selectedMaterials = null;
            resetSelectable();
            return;
        }
    }
    
    /**
     * gives all material, that have less of equal weight to int weight, the selectable image
     * @param weight Max weight the helper can carry
     */
    private void selectable(int weight){
        List<Materials> mat = getObjects(Materials.class);
        //for each material
        for(Materials mater : mat){
            //that weighs less or equal to weight
            if(mater.getWeight() <= weight){
                mater.selectable();
            }
        }
    }
    
    /**
     * removes selectable image from all materials
     */
    private void resetSelectable(){
       List<Materials> mat = getObjects(Materials.class);
       //for each material
        for(Materials mater : mat){
            //that's in the selectable area
            if(mater.getY() > 500){
                mater.unselectable();
            }
        } 
    }
}