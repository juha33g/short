import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;


public class Pallo implements Runnable
{

	
Thread tankThread;
double x=10,y=333,velx=1,vely=0;	

double tankAngle,xv1,xv2,xv3,xv4,yv1,yv2,yv3,yv4,
                 xt1,xt2,xt3,xt4,yt1,yt2,yt3,yt4,
                 xg1,xg2,xg3,xg4,yg1,yg2,yg3,yg4;

Polygon tank,turret,gun;

	public Pallo(Maing602 mc)    // mc...applet  no need
	{
		

		

	
	}
	
	
	public void start() 
	{	
		tankThread=new Thread(this);
		tankThread.start();	
		
	}
	
	
	
	
	public void rotateTank(double ta){this.tankAngle=ta;}
	
	
	
	
	
	public void move()
	{
  
		
		
		
	
	    
	   if(tankAngle > 2*Math.PI){tankAngle = tankAngle - 2*Math.PI;}      // 380- 20
       if(tankAngle < -2*Math.PI){tankAngle = tankAngle + 2*Math.PI;}     //-380 -20
	    
       
       if(0 <tankAngle && tankAngle <  Math.PI/2){velx = 1;}               //  90 ....0
       if(Math.PI/2 <tankAngle && tankAngle < 1.5 *Math.PI){velx = -1;}    //  270 .....90
       if(1.5*Math.PI <tankAngle && tankAngle < 2*Math.PI){velx = 1;}      //  270 .....360
       
       
       
       
       if(-2*Math.PI <tankAngle && tankAngle < -1.5*Math.PI/2){velx = 1;}   // - 360 ....270
       if(-1.5*Math.PI <tankAngle && tankAngle < -Math.PI/2){velx = -1;}    // - 270 .....90
       if(-Math.PI/2 <tankAngle && tankAngle < 0){velx = 1;}                // - 90 ....0
       

		
		x = x +velx;
		
		vely = (velx*Math.tan(tankAngle));
		
		
		if(vely>2){vely=2;}         //  special 90,270
		if(vely <-2){vely=-2;}
		
		
		y=y+vely;
		
		
		
		
		
		

		
		
	}
	
	
	
	
	
	
	
	
	public void run()
	{
		Thread thisThread = Thread.currentThread();
		
		while(tankThread==thisThread)
		
		{
			move();
			
//			
			try
			{
				Thread.sleep(111);
			}
			catch(Exception e)
			{
				
			}
			
		}
	
	}
	
	
	public void paint(Graphics g)
	{

	
		Font fnt = new Font("arial",Font.BOLD,15);
		g.setFont(fnt);
		
		String v= "tankAngle" + tankAngle+"         angle  :" + tankAngle/0.0174;
		
		
		String k= "x : " + x +"   y : " +y    + "   velx  " +velx+  "   vely  "+vely;
		
		
		
		g.setColor(Color.red);
		
		g.fillOval((int)x,(int) y,32,5);
		
		g.fillRect((int)x,(int) y,33, 7);
		
		
		
		
		
		g.drawString(k,333,386);
		
	
		g.drawString(v,455,444);
		
		
		
		
		

		
		
//		long beg =System.nanoTime();
		
		tank = new Polygon();
		
		
		
		yv1 = 50*Math.sin(Math.PI/8.57 +tankAngle);	    // tank
		xv1 = 50*Math.cos(Math.PI/8.57 +tankAngle);
		
		yv2 = 50*Math.sin(Math.PI-Math.PI/8.57 +tankAngle);	
		xv2 = 50*Math.cos(Math.PI-Math.PI/8.57 +tankAngle);
		
		yv3 = 50*Math.sin(Math.PI+Math.PI/8.57 +tankAngle);	
		xv3 = 50*Math.cos(Math.PI+Math.PI/8.57 +tankAngle);
		
		yv4 = 50*Math.sin(2*Math.PI-Math.PI/8.57 +tankAngle);	
		xv4 = 50*Math.cos(2*Math.PI-Math.PI/8.57+tankAngle);
		
//		long end =System.nanoTime();

		
		tank = new Polygon();
		
	
		
		xv1 = xv1 +x;
		xv2 = xv2 +x;
		xv3 = xv3 +x;
		xv4 = xv4 +x;
		
		yv1 = yv1 +y;
		yv2 = yv2 +y;
		yv3 = yv3 +y;
		yv4 = yv4 +y;
		
		xv1 = (int)Math.round(xv1);
		xv2 = (int)Math.round(xv2);
		xv3 = (int)Math.round(xv3);
		xv4 = (int)Math.round(xv4);
		
		yv1 = (int)Math.round(yv1);
		yv2 = (int)Math.round(yv2);
		yv3 = (int)Math.round(yv3);
		yv4 = (int)Math.round(yv4);
		
		
		
		
		tank.addPoint((int)xv1,(int) yv1);
		tank.addPoint((int)xv2,(int) yv2);		
		tank.addPoint((int)xv3,(int) yv3);
		tank.addPoint((int)xv4,(int) yv4);
		
//------------------------------------------------------------------------		

		turret = new Polygon();
		
		yt1 = 22.4*Math.sin(Math.PI/14 +tankAngle);	    // turret
		xt1 = 22.4*Math.cos(Math.PI/14 +tankAngle);
		
		yt2 = 15*Math.sin(Math.PI-Math.PI/4 +tankAngle);	
		xt2 = 15*Math.cos(Math.PI-Math.PI/4 +tankAngle);
		
		yt3 = 15*Math.sin(Math.PI+Math.PI/4 +tankAngle);	
		xt3 = 15*Math.cos(Math.PI+Math.PI/4 +tankAngle);
		
		yt4 = 22.4*Math.sin(2*Math.PI-Math.PI/14 +tankAngle);	
		xt4 = 22.4*Math.cos(2*Math.PI-Math.PI/14+tankAngle);
		
//		long end =System.nanoTime();

		
		
		
	
		
		xt1 = xt1 +x;
		xt2 = xt2 +x;
		xt3 = xt3 +x;
		xt4 = xt4 +x;
		
		yt1 = yt1 +y;
		yt2 = yt2 +y;
		yt3 = yt3 +y;
		yt4 = yt4 +y;
		
		xt1 = (int)Math.round(xt1);
		xt2 = (int)Math.round(xt2);
		xt3 = (int)Math.round(xt3);
		xt4 = (int)Math.round(xt4);
		
		yt1 = (int)Math.round(yt1);
		yt2 = (int)Math.round(yt2);
		yt3 = (int)Math.round(yt3);
		yt4 = (int)Math.round(yt4);
		
		
		
		
		turret.addPoint((int)xt1,(int) yt1);
		turret.addPoint((int)xt2,(int) yt2);		
		turret.addPoint((int)xt3,(int) yt3);
		turret.addPoint((int)xt4,(int) yt4);
		
		
//--------------------------------------------------------------------------------
		
		
       gun = new Polygon();
		
		yg1 = 40*Math.sin(Math.PI/65 +tankAngle);	    // gun
		xg1 = 40*Math.cos(Math.PI/65 +tankAngle);
		
		yg2 = 4*Math.sin(Math.PI-Math.PI/65 +tankAngle);	
		xg2 = 4*Math.cos(Math.PI-Math.PI/65 +tankAngle);
		
		yg3 = 4.8*Math.sin(Math.PI+Math.PI/4 +tankAngle);	
		xg3 = 4.8*Math.cos(Math.PI+Math.PI/4 +tankAngle);
		
		yg4 = 40*Math.sin(2*Math.PI-Math.PI/65 +tankAngle);	
		xg4 = 40*Math.cos(2*Math.PI-Math.PI/65+tankAngle);
		
//		long end =System.nanoTime();

		
		
		
	
		
		xg1 = xg1 +x;
		xg2 = xg2 +x;
		xg3 = xg3 +x;
		xg4 = xg4 +x;
		
		yg1 = yg1 +y;
		yg2 = yg2 +y;
		yg3 = yg3 +y;
		yg4 = yg4 +y;
		
		xg1 = (int)Math.round(xg1);
		xg2 = (int)Math.round(xg2);
		xg3 = (int)Math.round(xg3);
		xg4 = (int)Math.round(xg4);
		
		yg1 = (int)Math.round(yg1);
		yg2 = (int)Math.round(yg2);
		yg3 = (int)Math.round(yg3);
		yg4 = (int)Math.round(yg4);
		
		
		
		
		gun.addPoint((int)xg1,(int) yg1);
		gun.addPoint((int)xg2,(int) yg2);		
		gun.addPoint((int)xg3,(int) yg3);
		gun.addPoint((int)xg4,(int) yg4);
		
		
		
		g.setColor(Color.yellow);
	
		long beg =System.nanoTime();
		
		
     	g.fillPolygon(tank);      // 33ms 
		
		g.setColor(Color.black);
		
		g.fillPolygon(turret);
		
		g.fillPolygon(gun);                   
		
		
 	  long end =System.nanoTime();
		
		
		
		
		long dif =end -beg;
		
//		System.out.println(" time "+  dif);
		
	}
	
	
	
	
	

	
	
	
}
