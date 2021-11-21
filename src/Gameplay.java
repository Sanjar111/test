package brickBrocker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
  private boolean play = false;
  private int score = 0;

  private int totalBricks = 21;

  private Timer time;
  private int delay = 8;

  private int playerX = 310;

  private int ballposX = 120;
  private int ballposY = 350;
  private int ballXdir = -1;
  private int ballYdir = -2;

  public Gameplay() {
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    timer=new Timer(delay, this);
    timer.start();
  }

  public void paint(Graphics g) {
    // background
    g.setColor(Color.black);
    g.fillRect(1, 1, 692, 592);

    // borders
    g.setColor(Color.yellow);
    g.fillRect(0, 0, 3, 592);
    g.fillRect(0, 0, 692, 3);
    g.fillRect(691, 0, 3, 592);

    // the paddle
    g.setColor(Color.green);
    g.fillRect(playerX, 550, 100, 8);

    // the ball
    g.setColor(Color.yellow);
    g.fillOval(ballposX, ballposY, 20, 20);

    g.dispose();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    timer.start();
    repaint();
  }

    if (play) {
      if (new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
        ballYdir = -ballYdir;
      }
    
      ballposX = -ballXdir;
      ballposY += ballYdir;
      if (ballposX < 0) {
        ballXdir = -ballXdir;
      }
      if (ballposY < 0) {
        ballYdir = -ballYdir;
      }
      if (ballposX > 670) {
        ballXdir = -ballXdir;
      }

    }
  
  }
}
