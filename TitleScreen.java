import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (Felix Peng) 
 * @version (May 18th 2023)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("The Elephant", 80);

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(titleLabel, 250, 100);
        prepare();
    }

    /*
     * The going to the main world act loop 
     */

    public void act(){
        if(Greenfoot.isKeyDown("space")){
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,440,95);
        elephant.setLocation(503,103);

        Label label = new Label("Press <Space> to start", 40);
        addObject(label,244,240);
        label.setLocation(298,227);
        Label label2 = new Label("<A> to move right, <D> to move left", 40);
        addObject(label2,248,332);
        label2.setLocation(296,295);
    }
}
