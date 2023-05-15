import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world our hero livev
 * 
 * @author Felix
 * @May 15th 2023
 */
public class MyWorld extends World
{
    
    public Apple apple; 
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200); // instance, x, y
        
        apple = new Apple();
        addObject(apple, 300, 0);
    }
    
    
    /*
     * create a new apple at random location at
     */
    public void createApple(){
        apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
            // int y 99= 
        addObject(apple, x, y);
    }
}
