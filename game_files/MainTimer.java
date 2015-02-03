
public class MainTimer extends Thread
{

	
	int time=0;
	
	String gameTime=Integer.toString(time);

	public void run()
	{
		
		try 
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		while(true)
		{	
		
		try 
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
		
		time=time+1;
		
	     
		
		System.out .println(gameTime);
		
		}
	}
	
	
	
	
	
}
