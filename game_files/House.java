import java.awt.Color;
import java.awt.Graphics;


public class House implements Runnable
{

	
Thread ta;
int x=0,y=0,velx=0,vely=0;	

	public House()
	{
		

		
		
	}
	
	
	public void start() 
	{	
		ta=new Thread(this);
		ta.start();	
		
	}
	
	
	public void paint(Graphics g)
	{
		g.setColor(Color.red);	g.fillOval(x, y,33,22);
		
	}
	
	
	
	
	
	public void run()
	{
		Thread thisThread = Thread.currentThread();
		
		while(ta==thisThread)
		
		{
			x = x +1;
			
			x = x +velx;
			y = y +vely;
			
//			System.out.println("talo");
			try
			{
				Thread.sleep(55);
			}
			catch(Exception e)
			{
				
			}
			
		}
	
	}
	
	
	
	
	
	
}
