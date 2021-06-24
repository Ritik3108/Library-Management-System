package mypack;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Loading extends JFrame implements Runnable{
	
	JLabel l1,l2;
	JProgressBar p;
	Thread th;
	int s;
	
	public void setUploading()
	{
		setVisible(false);
		th.start();
		
	}
	
	public void run()
	{
	try
	{
		for(int i=0;i<200;i++)		  
		  {
		  int m=p.getMaximum();
		  int v=p.getValue();
		  if(v<m)
		  {
			  p.setValue(p.getValue()+1);
		  }
		  else
		  {
			  i=201;
			  setVisible(false);
			 new Home().setVisible(true);
		  }
		  Thread.sleep(50);
		  
		}
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
	}
	Loading()
	{
		super("Loading");
		th=new Thread((Runnable) this);
		
		setSize(500,380);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		l1=new JLabel("Smart Library v5.1");
		l1.setFont(new Font("Trebuchet MS",Font.BOLD,35));
		l1.setForeground(new Color(72, 209, 204));
		l1.setBounds(75,60,400,25);
		add(l1);
		
		p=new JProgressBar();
		p.setBounds(100,150,250,30);
		p.setFont(new Font("Tahoma", Font.BOLD, 12));
        p.setStringPainted(true);
        add(p);

		add(p);
		
		l2=new JLabel("Please Wait....");
		l2.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		l2.setForeground(new Color(160, 82, 45));
		l2.setBounds(160,200,400,25);
		add(l2);
		
		setUploading();
		
	}

	public static void main(String[] args) {

		new Loading().setVisible(true);
	}

}
