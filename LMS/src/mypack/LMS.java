package mypack;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LMS extends JFrame implements Runnable{
	
	Thread th;
	
	
	LMS()
	{
		super("Library Management System");
		setBounds(-5,100,1370,500);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/first.jpg"));
		Image i=i1.getImage().getScaledInstance(1400, 500, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i);
		JLabel l=new JLabel(i2);

		l.setBounds(0,100,1400,500);
		add(l);
		
		th=new Thread(this);
		th.start();
		
	}
	
	public void run()
	{
		try
		{
			Thread.sleep(3000);
			this.setVisible(false);
			new Login_user().setVisible(true);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
	}

	public static void main(String[] args) {

		new LMS().setVisible(true);
	}

}
