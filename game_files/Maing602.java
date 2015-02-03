import java.applet.Applet;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JApplet;


public class Maing602 extends Applet implements Runnable,MouseListener,MouseMotionListener,KeyListener
{   

//----------------------------------------MENU-----variables-------------------		
	
	
	 int x,y;	String mes =""; boolean pwSucces=true;String m="";
		
	 public String username = "";
	 public String password = "";  
	 
	 MyLogin passwordMenu;
	
//----------------------------------------MENU------------------------	
	
	
	
	Image dbImage;
	Graphics taustAlue;
	
	double tankAngle=0;
	
	Pallo tank;
	Thread gameLoopThread;
	Thread delay;
	
	InitialationObject io;
	
	Rectangle startGameBox;
	Rectangle startNewGameBox;
	Rectangle stopGameBox;
	
	boolean gamePressed= false;
    boolean newGamePressed = false;
    boolean stopGamePressed = false;
    
    boolean isInitScreen = true;
	
    MainTimer timer;
	

    piirtoPaneeli pirtoPa;
	
    
    
   //  --MENU init----------------------------------------------------- 
	
    public void init()
	{
    	this.addMouseListener(this);
	    this.addMouseMotionListener(this);
	    this.addKeyListener(this);     
    	

    	this.setSize(999,666);
   	

   	//------------tilapäisesti pois ----------------------------- 
    	
    	
	 
    if (!passwordMenu())
      {
   	  mes ="ID is not OK";
        
      }
      else { mes ="ID is OK"; }
    	
    	
    
    	
    init22Objects();	
    
	}
    
    
    
    
    
	 
	public void init22Objects()
	{
		
		delay=new Thread(this);
		
		tank=new Pallo(this);
		

		 
		startGameBox= new Rectangle(0,500,120,50);
		
	    startNewGameBox= new Rectangle(0,600,160,50);
	    stopGameBox= new Rectangle(550,500,120,50);
				
		
	    io =new InitialationObject();
	    
	    gameLoopThread=new Thread(this);
		
		pirtoPa=new piirtoPaneeli(tank,stopGameBox,startGameBox,startNewGameBox,
				                  gamePressed,newGamePressed,isInitScreen,io,timer,stopGamePressed);
		
		
        timer = new MainTimer();
        
        
	    
//	    this.addKeyListener(this);                   //  MOVE
	
	}
	
	
//	public void start() {			}
	
	
	public void update(Graphics g)
	{		
		dbImage = createImage(getWidth(),getHeight()); 
		taustAlue = dbImage.getGraphics();      // kopio pallokuva
		
		
		pirtoPa.paint(taustAlue);
		
		g.drawImage(dbImage, 0, 0, this);  // maalaa tausta
	}
	
	
	
	public void paint(Graphics g)
	{	
	update(g);	

	g.drawString("pallo ",0, 55);
	}

	
	
	
	
	
	@Override
	public void run()
	{
		Thread thisThread = Thread.currentThread();
		
		
		
		tank.start();
		
		io.talo.start();
		
		
//		repaint();
		
		while(gameLoopThread==thisThread)
		
		{
			repaint();
			
			System.out.println("gggggggggggggggggggggggggggggggggggggggggggggggggggg");

			try
			{
				Thread.sleep(49);
			}
			catch(Exception e)
			{
				System.out.println(" \n \n VIRHE getMessage  :" + e.getMessage() + 
						            "\n    virhe getStackTrace :" + e.getStackTrace() );
			}
			
		}
	
	}


	@Override
	public void mousePressed(MouseEvent e)
	{
		System.out.println("koordinaatit  x: " +e.getX() +"  "
					+ "y :" +e.getY());
	
		 int mx=e.getX();int my=e.getY();
		 
		 if( mx>startGameBox.x && mx<startGameBox.x +startGameBox.width  &&
			 my>startGameBox.y && my<startGameBox.y +startGameBox.height )
			 
		 {
			 

			 pirtoPa.gamePressed=true;						 
			 pirtoPa.isInitScreen =false;  // poistaa aloitusscreenin
			 
			 pirtoPa.stopGamePressed =false;
			
//			 stopGamePressed =false;
			 gameLoopThread.start();
			 
     		 
			 
		 }
		 
		 
		 
		 if( mx>startNewGameBox.x && mx<startNewGameBox.x +startNewGameBox.width  &&
		   	my>startNewGameBox.y && my<startNewGameBox.y +startNewGameBox.height )
		 {
		 
		  System.out.println("\n_STOP__STOP__STOP__STOP__STOP__STOP_"); 	
		 		
		  tank.x=10;
		  tank.y=10;
		  
		  
//		  pirtoPa.gamePressed=false;
		 
		
		  stopGamePressed =false;
		  
		  gameLoopThread.interrupt();  
	      
		  tank=null;
		  
		  startInitalation() ;
	
   	     
		 }
		 
		 
		 
		 if( mx>stopGameBox.x && mx<stopGameBox.x +stopGameBox.width  &&
			 my>stopGameBox.y && my<stopGameBox.y +stopGameBox.height )
				 {
				 
				  System.out.println("\n_STOP GAME:::::::::::::_"); 	
				 		
				 				  
				  

				  
				  stopGamePressed =true;
				 
				  gameLoopThread.interrupt();  
	      
				  tank=null;
				  
			      startInitalation() ;
				  
				  
			
		   	     
				 }
				 	 
		 
		 
		 
		 
	
		
		 
	}

	


	 public void startInitalation() 
	 {
		 try {
	    	  delay.sleep(500);
	    	  
		  	  } 
		  	catch (InterruptedException e1)
		      {
			
		  		String v ="   e1.printStackTrace()"; System.out.println("\n_ST :" +v);
		  	  }
	      
	      init22Objects();
			
	
	 }




	public void mouseMoved(MouseEvent e) 	{  	}
	public void mouseDragged(MouseEvent arg0) {}
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0){} 
	
	
	

	
	
	
	public void keyPressed(KeyEvent e)
	{
		
		
		
		if(tankAngle> 2*Math.PI){ tankAngle=  tankAngle - 2*Math.PI;}
		
			
		
        int key=e.getKeyCode();
				

		if (key==KeyEvent.VK_RIGHT)
		{
//			
			
			
			tankAngle =tankAngle + 0.0086;
			System.out.println("rorr");
			tank.rotateTank(tankAngle);
		}
		
		
		
		
		if (key==KeyEvent.VK_LEFT){
			

			
			tankAngle =tankAngle - 0.0086;
			tank.rotateTank(tankAngle);}
		
		
		
      if (key==KeyEvent.VK_N){System.out.println("\n_NNNNNNNNNNN");}
			

			
			
		
      
      
      
		
		
		
		
		
	}
	
	
	
	
	
	
	public void keyReleased(KeyEvent e)
	{
		int key=e.getKeyCode();
		

	



	

	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
//----------------------------------------LOGIN MENU---------------------------------
	
	
	public boolean passwordMenu() 
	 {
	  
		boolean isLoginValid = false;
	  
	  
	  passwordMenu = new MyLogin (new Frame(""),pwSucces);
	  
	    
	  
	  requestFocus();
	   
	  
	   
	   
	   
	  if (passwordMenu.buttonStatus == false)   { passwordMenu.dispose(); }
	  
	  
	  if (passwordMenu.buttonStatus == true) 
	  {
		  
	    username = passwordMenu.username.getText();
//	    password = passwordMenu.password.getText().trim();
//	    
	  char[] passt =  passwordMenu.password.getPassword();
	    
	  password = new String(passt);
	    
	    
	    
	    
	    if((username.equals("q") && password.equals("a")))
	    {
	    	isLoginValid=true;
	    }
	    else 
	    {   

	    	pwSucces =false;
	    	    	
	    	System.out.print("KjjjW");
	    	

	    	
	    	init();
	    	
	    } 
	    
	    
	    }
	  

	    
	  passwordMenu.dispose();
	  
	 
	  
	  return isLoginValid;
	  
	  }
	
	
	
	
	

}
