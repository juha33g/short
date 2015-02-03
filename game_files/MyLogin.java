import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyLogin extends JDialog implements ActionListener {
	
	boolean pwSucces=true;	
	
	
 boolean buttonStatus = false;
 JButton okButton,cancelButton;
 
 JTextField username;
 JPasswordField password;
 
 
 
 JTextArea tArea;


 MyLogin(Frame frame,boolean pwSucces)
 {

	 super(frame, "Welcome", true);
  
  this.pwSucces =  pwSucces;
  
  this.setSize(999,733);
  
  
  
  tArea = new JTextArea(15,32);

  
  tArea.setBackground(Color.yellow);
  tArea.setForeground(Color.BLUE);
 
   
   Font ft = new Font("Impact",Font.PLAIN,33);

   
   tArea.setFont(ft);
   tArea.setEnabled(false);


   username = new JTextField(9);
   password = new JPasswordField(9);
   
   
   
 //  password.setEchoChar('*');
   
  
    String text1 =   "   aaaa  "
    		      + "\n  aaaa "
    		      + "\n  bbb  ";
  
  
  
  
    String text2 =   "\n try again  ";
  
  
    String t3 = text1 +text2;
  
 
  

  

  
 
   
  
  if(pwSucces== true)  tArea.setText(text1 );
  
  if(pwSucces== false)
  {
	  tArea.setForeground(Color.red);
	  tArea.setEnabled(true);
	  tArea.setText(t3);
	  tArea.setEnabled(false);
  }
  
  Panel n = new Panel();
  n.setLayout(new FlowLayout());
  n.add(tArea);
  
 
  
  this.add(n);
  
  
  Panel a = new Panel();  
  
  a.setLayout(new FlowLayout());
  
  a.add(new Label("User :"));
  a.add(username);
  a.add(new Label("Password :"));
  a.add(password);
  
  this.add(a);
  
    
  Panel p = new Panel();  
  p.setLayout(new FlowLayout());
  add( p );
  
 
  

  p.add(okButton = new JButton("okButton"));
  okButton.addActionListener(this);      // okButton JButton
   
  
  
  
  p.add(cancelButton = new JButton("cancelButtoncel"));  
  cancelButton.addActionListener(this);    // cancelButtoncel ok JButton
  
  

  
  BorderLayout f = new BorderLayout();
  f.setHgap(1);
  f.setVgap(1);
  this.setLayout(f);
  
  
  this.add(n,BorderLayout.NORTH);
  this.add(a,BorderLayout.CENTER);
  this.add(p,BorderLayout.SOUTH);
  
  
  Dimension d = getToolkit().getScreenSize();
//  setLocation(d.width/4,d.height/6);
  
  setLocation(d.width/22,d.height/32);  // total blanket
  

  setVisible(true);
  
  
  // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
//  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//  this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//  
  }


 public void actionPerformed(ActionEvent ae){
  if(ae.getSource() == okButton) {
    buttonStatus = true;
    setVisible(false);
    }
  else if(ae.getSource() == cancelButton) {
    buttonStatus = false;
    setVisible(false);  
    // away if cancel   ???????   ei toimi
    // toimiii kun init poissa
    
    }
  }
}