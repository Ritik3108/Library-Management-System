package mypack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Home extends JFrame implements ActionListener{
	
	JLabel l1,l2;
	JMenuBar m;
	JMenu m1,m2,m3;
	JMenuItem m11,m12,m21,m22,m31,m32;
	JButton b1,b2,b3,b4,b5,b6;
	JPanel p,p1,p2;
	
	Home()
	{
	 super("Home");	
	 setBounds(200,0,1100,800);
	 
	 p=new JPanel();
	 add(p);
	 p.setBackground(Color.WHITE);
	 p.setLayout(null);
	 
	 m=new JMenuBar();
	 m.setBorder(new EtchedBorder(EtchedBorder.LOWERED,new Color(0,128,0),new Color(128,128,128)));
	 m.setBounds(0,0,1100,35);
	 m.setBackground(Color.CYAN);
	 p.add(m);
	 
	 m1=new JMenu("Record");
	 m1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
	 m.add(m1);
	 	 
     m11=new JMenuItem("Book Details");   
     m11.setMnemonic('B');
     m11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
     
     m12=new JMenuItem("Student Details");
     
     m12.setMnemonic('B');
     m12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
     

     m1.add(m11);
     m1.add(m12);
     
     m11.addActionListener(this);
     m12.addActionListener(this);

     

     
	 
     m2=new JMenu("Help");
	 m2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
	 m.add(m2);
	 
	 
     m21=new JMenuItem("Read Me");  
     
     m21.setMnemonic('A');
     m21.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
     
     m22=new JMenuItem("About US"); 
     
     m22.setMnemonic('A');
     m22.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
     

     m2.add(m21);
     m2.add(m22);
     
     m21.addActionListener(this);
     m22.addActionListener(this);

     
     
     m3=new JMenu("Exit");
	 m3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
	 m.add(m3);
	 
	 
     m31=new JMenuItem("Logout");  
     
     m31.setMnemonic('A');
     m31.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
     
     m32=new JMenuItem("Exit");  
     
     m32.setMnemonic('A');
     m32.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
     

     m3.add(m31);
     m3.add(m32);
     
     m31.addActionListener(this);
     m32.addActionListener(this);

     
     
     l1=new JLabel("Library Management System");
     l1.setFont(new Font("Trebuchet MS",Font.BOLD,30));
     l1.setForeground(Color.PINK);
     l1.setBounds(350,40,400,50);
     p.add(l1);
     
     
     l2=new JLabel("Delete Account ?");
     l2.setFont(new Font("Trebuchet MS",Font.BOLD,15));
     l2.setBounds(950,40,400,50);
     p.add(l2);
     
     l2.addMouseListener(new MouseAdapter()
		{
	      public void mouseClicked(MouseEvent er)
	      {
	    	  setVisible(false);
	    	  new Delete_Account().setVisible(true);
 	      }
		});

     
     
     
     p1=new JPanel();
     p1.setBorder(new TitledBorder(new LineBorder(new Color(128,0,34),2),"Operation",
    		        TitledBorder.LEADING,TitledBorder.TOP,null,new Color(34,145,223)));
     p1.setBounds(20,100,1050,300);
     p.add(p1);
     
     
     p2=new JPanel();
     p2.setBorder(new TitledBorder(new LineBorder(new Color(128,0,34),2),"Action",
    		        TitledBorder.LEADING,TitledBorder.TOP,null,new Color(34,145,223)));
     p2.setBounds(20,410,1050,280);
     p.add(p2);
     
     
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/second.png"));
     Image im=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
     ImageIcon i2=new ImageIcon(im);
     JLabel j=new JLabel(i2);
     p1.setLayout(null);
     j.setBounds(20,20,250,200);
     p1.add(j);
     
     ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/third.png"));
     Image im1=i3.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
     ImageIcon i4=new ImageIcon(im1);
     JLabel j1=new JLabel(i4);
     j1.setBounds(300,10,350,250);
     p1.add(j1);
     
     ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/fourth.png"));
     Image im2=i5.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
     ImageIcon i6=new ImageIcon(im2);
     JLabel j2=new JLabel(i6);
     j2.setBounds(700,20,250,200);
     p1.add(j2);
	 
     
     
     ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/fifth.png"));
     Image im3=i7.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
     ImageIcon i8=new ImageIcon(im3);
     JLabel j3=new JLabel(i8);
     p2.setLayout(null);
     j3.setBounds(20,20,250,200);
     p2.add(j3);
     
     ImageIcon i9=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/sixth.png"));
     Image im4=i9.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
     ImageIcon i10=new ImageIcon(im4);
     JLabel j4=new JLabel(i10);
     j4.setBounds(360,20,250,200);
     p2.add(j4);
	 
     
     ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/seventh.png"));
     Image im5=i11.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
     ImageIcon i12=new ImageIcon(im5);
     JLabel j5=new JLabel(i12);
     j5.setBounds(700,20,250,200);
     p2.add(j5);
	 
     
     b1=new JButton("Add Books");
     b1.setBounds(70,240,120,35);
     b1.setBackground(Color.BLACK);
     b1.setForeground(Color.WHITE);
     b1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
     p1.add(b1);
     b1.addActionListener(this);
     
     b2=new JButton("Statistics");
     b2.setBounds(425,240,120,35);
     b2.setBackground(Color.BLACK);
     b2.setForeground(Color.WHITE);
     b2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
     p1.add(b2);
     b2.addActionListener(this);

     
     b3=new JButton("Add Student");
     b3.setBounds(740,240,150,35);
     b3.setBackground(Color.BLACK);
     b3.setForeground(Color.WHITE);
     b3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
     p1.add(b3);
     b3.addActionListener(this);

	 
     
     b4=new JButton("Issue Book");
     b4.setBounds(70,230,120,35);
     b4.setBackground(Color.BLACK);
     b4.setForeground(Color.WHITE);
     b4.setFont(new Font("Trebuchet MS",Font.BOLD,16));
     p2.add(b4);
     b4.addActionListener(this);

     
     b5=new JButton("Return Book");
     b5.setBounds(420,230,150,35);
     b5.setBackground(Color.BLACK);
     b5.setForeground(Color.WHITE);
     b5.setFont(new Font("Trebuchet MS",Font.BOLD,16));
     p2.add(b5);
     b5.addActionListener(this);

     
     b6=new JButton("About US");
     b6.setBounds(750,230,120,35);
     b6.setBackground(Color.BLACK);
     b6.setForeground(Color.WHITE);
     b6.setFont(new Font("Trebuchet MS",Font.BOLD,16));
     p2.add(b6);
     b6.addActionListener(this);

	 
	 
	 
	}
	
	public void actionPerformed(ActionEvent ec)
	{
		
		String msg=ec.getActionCommand();
		if(msg.equals("Book Details"))
		{
			setVisible(false);
			new BookDetails().setVisible(true);
		}	
		
		else if(msg.equals("Student Details"))
		{
			setVisible(false);

			new StudentDetails().setVisible(true);
			
		}	
		
		else if(msg.equals("Read Me"))
		{
			setVisible(false);

			new AboutUs().setVisible(true);
			
		}	
		
		else if(msg.equals("Exit"))

			System.exit(ABORT);
		
		else if(msg.equals("About US"))
		{
			setVisible(false);

			new AboutUs().setVisible(true);
		}
		
		else if(msg.equals("Logout"))
		{
			setVisible(false);

			new Login_user().setVisible(true);
			
		}	
		
		if(ec.getSource()==b1)
		{
			new AddBook().setVisible(true);
			this.setVisible(false);
		}
		else if(ec.getSource()==b2)
		{
			new Statistics().setVisible(true);
			this.setVisible(false);

		}
		else if(ec.getSource()==b3)
		{
			new AddStudent().setVisible(true);
			this.setVisible(false);

		}
		else if(ec.getSource()==b4)
		{
			new IssueBook().setVisible(true);
			this.setVisible(false);

		}
		else if(ec.getSource()==b5)
		{
			new ReturnBook().setVisible(true);
			this.setVisible(false);

		}
		else if(ec.getSource()==b6)
		{
			new AboutUs().setVisible(true);
			this.setVisible(false);

		}
	}

	public static void main(String[] args) {
		
		new Home().setVisible(true);
	}

}
