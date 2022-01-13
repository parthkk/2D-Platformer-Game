/* Endframe.java
 * Authors: Gordon Duan & Parth Kotecha
 * Date: January 22, 2019
 * Description: This is the end frame that displays when you win
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class EndFrame extends JFrame {
  JFrame thisFrame;
  int gems;
  boolean star;
  int index;
  private static final long serialVersionUID = 7526472295622776147L;  // unique id
  EndFrame(int gems,boolean star){
    super("End Screen");
    this.thisFrame = this;
    this.gems = gems;
    this.star = star;
    int maxX = Toolkit.getDefaultToolkit().getScreenSize().width;
    int maxY = (int)Math.round(Toolkit.getDefaultToolkit().getScreenSize().height*0.957);
    this.setSize(maxX,maxY);
    this.setLocationRelativeTo(null); //start the frame in the center of the screen
    this.setResizable (false);
    this.setVisible(true);
    JPanel mainPanel = new MainPanel();
    mainPanel.setLayout(null);
    JLabel win = new JLabel("Winner Winner Chicken Dinner");
    win.setFont(win.getFont ().deriveFont (35.0f));
    JButton playAgain = new JButton("PLAY AGAIN");
    playAgain.addActionListener(new PlayAgainListener());
    JButton quit = new JButton("QUIT");
    quit.addActionListener(new QuitListener());
    win.setBounds(700,140,800,300);
    playAgain.setBounds(50,600,200,200);
    quit.setBounds(1600,600,200,200);
    
    mainPanel.add(win);
    mainPanel.add(playAgain);
    mainPanel.add(quit);
    
    
    this.add(mainPanel);
  }
  class MainPanel extends JPanel{
    private static final long serialVersionUID = 7526472295622776147L;  // unique id
    Image background = Toolkit.getDefaultToolkit().getImage("endScreen.png");
    Image gemImage = Toolkit.getDefaultToolkit().getImage("gem2.png");
    Image starImage = Toolkit.getDefaultToolkit().getImage("star0.png");
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.drawImage(background,325,0,1200,1000,this);
      if(index>=50){
        g.drawImage(gemImage,757,380,75,75,this);
      }
      if(index>=70){
        g.drawImage(gemImage,915,380,75,75,this);
      }
      if(index>=90){
        g.drawImage(gemImage,1073,380,75,75,this);
      }
      if(index>=110){
        g.drawImage(gemImage,757,500,75,75,this);
      }
      if(index>=130){
        g.drawImage(gemImage,915,500,75,75,this);
      }
      if(index>=150){
        g.drawImage(gemImage,1073,500,75,75,this);
      }
      if(index <=(gems*20)+30){
        index++;
      }else{
        if(star){
          g.drawImage(starImage,1065,640,75,75,this);
        }
      }
      repaint();
    }
  }
  class PlayAgainListener implements ActionListener{  //this is the required class definition
    public void actionPerformed(ActionEvent event){  
      System.out.println("Starting new Game");
      thisFrame.dispose();
      new GameFrame();//create a new FunkyFrame (another file that extends JFrame)
    }
  }
  class QuitListener implements ActionListener{  //this is the required class definition
    public void actionPerformed(ActionEvent event){  
      System.exit(0);
    }
  } 
}