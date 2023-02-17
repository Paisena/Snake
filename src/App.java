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
import java.awt.event.ActionEvent;


public class App extends JFrame implements ActionListener, KeyListener {

    Timer myTimer = new Timer(100, this);

    boolean OnorOff = false;

    SnakeUnit snakeUnit = new SnakeUnit(100, 100);

    // DefineObject Circles[]= new DefineObject[50];

    // create the init method
    // the init is the first method to run

    public App() {

        super("Button Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        // pnlInput.setLayout(new GridLayout(0,2));

        addKeyListener(this);

        

        repaint();



    }

    public static void main(String[] args) {

        // Place components on the applet panel
        final int FRAME_WIDTH = 500;
        final int FRAME_HEIGHT = 500;

        //this is a edit
        App frame = new App();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);

    }

    // when you push the button it comes this method
    public void actionPerformed(ActionEvent event) {

        // declare variable to hold which button is called
        Object objSource = event.getSource();
        // requestFocus();

        repaint();
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 65:
                System.out.print("a");
                snakeUnit.x -= 10;
                repaint();
                break;
            case 68:
                System.out.print("d");
                snakeUnit.x += 10;
                repaint();
                break;
            case 83:
                System.out.print("s");
                snakeUnit.y += 10;
                repaint();
                break;
            case 87:
                System.out.print("w");
                snakeUnit.y -= 10;
                repaint();
                break;
            case 32:
                if(!OnorOff){
                    startTheTimer();
                }
                if(OnorOff){
                    stopTheTimer();
                }
            default:
                System.out.print(e.getKeyCode());
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
        g.fillOval(snakeUnit.x, snakeUnit.y, 10, 10);

    }

    public void Update(Graphics gr) {

        // call the paint method
        paint(gr);
        repaint();
    }

    public void startTheTimer() {

        //thasdas
        myTimer.start();
        OnorOff = true;
    }

    public void stopTheTimer() {

        myTimer.stop();
        OnorOff = false;
    }

}