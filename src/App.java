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

    // SnakeUnit snakeUnit = new SnakeUnit(200, 100);

    ArrayList<SnakeUnit> snakeUnitArray = new ArrayList<SnakeUnit>();

    boolean isPlaying = true;

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

        if (!isPlaying) {
            return;
        }

        if (!apple.isSpawned) {
            apple.spawn();
        }
        // declare variable to hold which button is called
        Object objSource = event.getSource();
        if (OnorOff) {

            createNewSnake();
            removeBackSnake();

            if (snakeUnitArray.get(snakeUnitArray.size() - 1).isOverApple(apple.x, apple.y)) {
                createNewSnake();
                apple.spawn();
                // snakeUnit.grow();
            }
        }

        // end game detecction

        //hit wall
        for (int i = 0; i < snakeUnitArray.size(); i++) {
            if(snakeUnitArray.get(i).x < 20 || snakeUnitArray.get(i).y < 20){
                System.out.println("game over hit wall");
                isPlaying = false;
            }
            if(snakeUnitArray.get(i).x >= 600 || snakeUnitArray.get(i).y >= 600){
                System.out.println("game over hit wall");
                isPlaying = false;
            }
        }

        //hit yourself
        for (int i = 0; i < snakeUnitArray.size(); i++) {
            for (int j = i + 1; j < snakeUnitArray.size(); j++) {
                if (snakeUnitArray.get(i).x == snakeUnitArray.get(j).x
                        && snakeUnitArray.get(i).y == snakeUnitArray.get(j).y) {
                    System.out.println("game over");
                    System.out.println(
                            "first part x: " + snakeUnitArray.get(i).x + "second part x: " + snakeUnitArray.get(j).x);
                    System.out.println(
                            "first part y: " + snakeUnitArray.get(i).y + "second part y: " + snakeUnitArray.get(j).y);
                    isPlaying = false;

                }
            }
        }

        // requestFocus();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 65:
            if(SnakeUnit.xDir == 0){
                SnakeUnit.changeXDir(-20);
                }
                break;
            case 68:
            if(SnakeUnit.xDir == 0)
                SnakeUnit.changeXDir(20);
                break;
            case 83:
            if(SnakeUnit.yDir == 0)
                SnakeUnit.changeYDir(20);
                break;
            case 87:
            if(SnakeUnit.yDir == 0){
                SnakeUnit.changeYDir(-20);
            }
                break;
            default:
                System.out.print("key code: " + e.getKeyCode());
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

        g.setColor(new Color(32, 145, 40));
        for (int i = 0; i < snakeUnitArray.size(); i++) {
            g.fillRect(snakeUnitArray.get(i).x, snakeUnitArray.get(i).y, 20, 20);
        }
        g.setColor(Color.red);
        if (apple.isSpawned)
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

    public void createNewSnake() {
        snakeUnitArray.add(new SnakeUnit(
                snakeUnitArray.get(snakeUnitArray.size() - 1).x
                        + snakeUnitArray.get(snakeUnitArray.size() - 1).getXDir(),
                snakeUnitArray.get(snakeUnitArray.size() - 1).y
                        + snakeUnitArray.get(snakeUnitArray.size() - 1).getYDir()));
    }

    public void removeBackSnake() {
        snakeUnitArray.remove(0);
    }
}