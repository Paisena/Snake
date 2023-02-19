//Name: Jonathan Ng
//Date: 2/8/2023
/*
 * This project codes a timer
 * and animation
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class App extends JFrame implements ActionListener, KeyListener {

    Timer myTimer = new Timer(100, this);

    boolean OnorOff = true;

    Apple apple = new Apple();

    //SnakeUnit snakeUnit = new SnakeUnit(200, 100);

    ArrayList<SnakeUnit> snakeUnitArray = new ArrayList<SnakeUnit>();

    // DefineObject Circles[]= new DefineObject[50];

    // create the init method
    // the init is the first method to run

    public App() {

        super("Button Test");
        snakeUnitArray.add(new SnakeUnit(200, 200));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        // pnlInput.setLayout(new GridLayout(0,2));

        addKeyListener(this);


        // this is a very cool test
        myTimer.start();
        repaint();


    }

    public static void main(String[] args) {


        // Place components on the applet panel
        final int FRAME_WIDTH = 620;
        final int FRAME_HEIGHT = 620;

        // this is a edit
        App frame = new App();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);

    }

    // when you push the button it comes this method
    public void actionPerformed(ActionEvent event) {
        if(!apple.isSpawned){
            apple.spawn();
        }
        // declare variable to hold which button is called
        Object objSource = event.getSource();
        if(OnorOff){

            createNewSnake();
            removeBackSnake();

            if(snakeUnitArray.get(snakeUnitArray.size() - 1).isOverApple(apple.x, apple.y)){
                apple.spawn();
                //snakeUnit.grow();
            }
        }
        // requestFocus();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 65:
                SnakeUnit.changeXDir(-20);
                repaint();
                break;
            case 68:
                SnakeUnit.changeXDir(20);
                repaint();
                break;
            case 83:
                SnakeUnit.changeYDir(20);
                repaint();
                break;
            case 87:
                SnakeUnit.changeYDir(-20);
                repaint();
                break;
            default:
                System.out.print("key code: " + e.getKeyCode());
                repaint();
                break;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        repaint();
    }

    public void keyTyped(KeyEvent e) {
        repaint();
    }

    // create the paint method to show graphics
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.red);
        for(int i = 0; i < snakeUnitArray.size(); i++){
            g.fillRect(snakeUnitArray.get(i).x, snakeUnitArray.get(i).y, 20, 20);
        }
        if(apple.isSpawned)
        g.fillRect(apple.x, apple.y, 20, 20);

    }

    public void Update(Graphics gr) {

        // call the paint method
        paint(gr);
        repaint();
    }

    public void startTheTimer() {

        System.out.println("timer started");
        myTimer.start();
        OnorOff = true;
    }

    public void stopTheTimer() {

        myTimer.stop();
        OnorOff = false;
    }

    public void createNewSnake(){
        snakeUnitArray.add(new SnakeUnit(snakeUnitArray.get(snakeUnitArray.size()-1).x + snakeUnitArray.get(snakeUnitArray.size()-1).getXDir(), snakeUnitArray.get(snakeUnitArray.size()-1).y + snakeUnitArray.get(snakeUnitArray.size()-1).getYDir()));
    }

    public void removeBackSnake(){
        snakeUnitArray.remove(0);
    }
}