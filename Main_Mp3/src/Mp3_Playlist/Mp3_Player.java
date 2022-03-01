package Mp3_Playlist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import javazoom.jl.decoder.JavaLayerException;




public class Mp3_Player extends LinkedList implements ActionListener,Runnable{
	
	
	
	static Mp3_Player p;
	Thread t;
	
	
	JButton play = new JButton("Turn On");
	JButton stop = new JButton("Stop It");
	JButton pause = new JButton("Pause");
	JButton resume = new JButton("Resume");
	
	Mp3_Player(){
		
		JLabel background;
	
	//Creating my frame and setting the Layout for my Frame
	  
	  JFrame frame = new JFrame();
	  frame.setTitle("MusiQ Player");
	  ImageIcon logo = new ImageIcon("E:\\Main_Mp3\\Logo.png");
	  frame.setIconImage(logo.getImage());
	  
	  
	//Creating boundries for buttons in my Frame and performing acuqired actions for the buttons and threading is done
	 
	  t=new Thread();
	  
	  play.setBounds(425, 75, 100, 30);
	  frame.add(play);
	  play.addActionListener(this);
	  
	  
	  stop.setBounds(425, 115, 100, 30);
	  frame.add(stop);
	  stop.addActionListener(this);
	  
	  pause.setBounds(425, 275, 100, 30);
	  frame.add(pause);
	  pause.addActionListener(this);
	  
	  resume.setBounds(425, 315, 100, 30);
	  frame.add(resume);
	  resume.addActionListener(this);
	
	  
	  //Showing and closing the Frame
	  
	  frame.setSize(555,419);
	  frame.setLayout(null);
	  frame.setVisible(true);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  ImageIcon img = new ImageIcon("F:\\Wallpapers\\Music.jpeg");
	  background = new JLabel("",img,JLabel.LEFT);
	  background.setBounds(0,0,555,419);
	  frame.add(background);
	  
	}

	  public static void main(String[] args) throws JavaLayerException{
		
		   p	= new Mp3_Player();
	  }
	  
	@SuppressWarnings({ "deprecation", "removal" })
	@Override
	  public void actionPerformed(ActionEvent e) {
		  
		  if(e.getSource()==play) {
			  t=new Thread(p);
			  t.start();
		  }
		  else if(e.getSource()==stop){
			  
			  t.stop();
				  
			  }
          else if(e.getSource()==pause){
        	  
        	  t.suspend();
				  
			  }
          else if(e.getSource()==resume){
			  
			  t.resume();
				  
			  }
		  
		  }
	  @Override
	  public void run() {
		  
		  play();
		  
		  }
		  
	  
		  }
	  


