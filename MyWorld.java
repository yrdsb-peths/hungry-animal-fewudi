import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world our hero livev
 * 
 * @author Felix
 * @May 15th 2023
 */
public class MyWorld extends World
{
    public int score; 
    public Apple apple; 
    Label scoreLabel;
    
    //score label for P2
    Label scoreLabel1;
    
    int level = 1; 
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        //elephant
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300); // instance, x, y
        
        
        //pikachu
        Pikachu pikachu = new Pikachu();
        addObject(pikachu, 300, 300);
        
        
        //apple 
        createApple();
        
        //lable 
        scoreLabel = new Label(0,60);
        addObject(scoreLabel,50, 50);
        
        scoreLabel1 = new Label(0, 60);
        addObject(scoreLabel1, 50, 540);
        
    }
    
    //be called when the game ends, draw "GameOver"
    public void gameOver(){
        Label gameOverlabel = new Label ("Game Over", 100);
        addObject(gameOverlabel, 300, 200);
    }
    
    
    /*
     * Increase score
     */
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0){
            level += 1; 
        }
    }
    
    
    
    
    /*
     * create a new apple at random location at
     */
    public void createApple(){
        
        apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
    
    
}
