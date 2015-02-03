import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;





public class piirtoPaneeli extends JPanel

{  
	Rectangle stopGameBox,startGameBox;
	Rectangle startNewGameBox;

   boolean gamePressed;
   boolean newGamePressed;  
   boolean isInitScreen;
   boolean stopGamePressed;
   Font fnt;
   
   MainTimer timer;

   
   InitialationObject io;
	
	Pallo tank;
	
	public piirtoPaneeli(Pallo tank,Rectangle stopGameBox,Rectangle startGameBox,Rectangle startNewGameBox,
			             boolean gamePressed,boolean newGamePressed, boolean isInitScreen,
			             InitialationObject io,MainTimer timer,boolean stopGamePressed )
			             
	{
		this.tank=tank;
		this.gamePressed=gamePressed;
		this.newGamePressed= newGamePressed;
		
		this.stopGameBox = stopGameBox;
		this.startGameBox=startGameBox;
		this.startNewGameBox=startNewGameBox;
		
		this.isInitScreen =  isInitScreen;
		
		fnt = new Font("arial",Font.BOLD,15);
		
		
		this.io=io;
		
		this.timer = timer;
		
		this.stopGamePressed = stopGamePressed;
	}
	
	
	
	
	
	public void paint(Graphics g)
	{
		
		tank.paint(g);
	    io.talo.paint(g);       
		
		
	
     	if(isInitScreen)
		{
			g.setColor(Color.black);	            // total screen black
			g.fillRect(0,0, 700, 600);
			
			g.setFont(fnt);
			g.setColor(Color.yellow);
			g.drawString("document....",177,177);
			
		
		
		
		}
		
     	
     	
     	
     	
		
		if(!gamePressed)
		{
			g.setColor(Color.black);	      
			g.fillRect(0,480, 700, 600);             // lower part of screen
			
			
			
			g.setColor(Color.yellow);    			//  start screen
			
			
			g.fill3DRect(startGameBox.x, startGameBox.y, startGameBox.width, startGameBox.height,true);
			
//			
			g.setColor(Color.red);
			g.drawString("START GAME",startGameBox.x+5,startGameBox.y +15);
			
			
			
		}
		
		
			
		if(gamePressed)                                    // lower part of screen       
		{
			g.setColor(Color.black);	      
			g.fillRect(0,480, 700, 600);	
			
			
			g.setColor(Color.yellow);                     //  game is on 
			
			g.fill3DRect(startNewGameBox.x, startNewGameBox.y, startNewGameBox.width, startNewGameBox.height,true);
			g.setColor(Color.red);
			g.drawString("START NEW GAME",startNewGameBox.x+5,startNewGameBox.y +15);

		
			
			
		}
		
		
		

		if(stopGamePressed )
         {	
        	 

 			g.setColor(Color.yellow); 
			
			g.drawString("GAME WAS STOPPED....",177,117);
		
         }
		
		
        g.setColor(Color.yellow);   
		
		g.fill3DRect(stopGameBox.x, stopGameBox.y, stopGameBox.width, stopGameBox.height,true);
		g.setColor(Color.red);
		g.drawString("STOP GAME",stopGameBox.x+5,stopGameBox.y +15);  // allways on screen
		

		
		
		
		String h =Integer.toString(io.talo.x);   // conversion int --> String
		
	    g.setColor(Color.yellow);  
	    
	    g.fill3DRect(400,500,120,50,true);
	    
	    g.setColor(Color.red);
	    g.drawString(" TIME",400,515);    // allways on screen
	    
	    g.drawString(h,405,535);
			
		
	}

}
