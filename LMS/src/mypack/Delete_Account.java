package mypack;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class Delete_Account extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3;
	JTextField t2,t3,t4,t5;
	Choice t1;
	JButton b1,b2,b3,b4;
	JPanel p,p1;
	
	
	Delete_Account()
	{
		super("Delete_Account");
		setSize(600,250);
		setLocationRelativeTo(null);
		setResizable(false);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		add(p);
		
		p1=new JPanel();
		p1.setBorder(new TitledBorder(new LineBorder(new Color(34,89,134),2),
				             "Delete_Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(110,218,128)));
		p1.setBounds(20,40,525,150);
		p1.setLayout(null);
		p.add(p1);
		
		
		
		l1=new JLabel("Username :");
		l1.setBounds(40,30,100,30);
		l1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l1);
		
		l2=new JLabel("Password :");
		l2.setBounds(40,90,100,30);
		l2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l2);
		
		l3=new JLabel("Back");
		l3.setBounds(510,5,90,30);
		l3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p.add(l3);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/tenth.png"));
		Image im1=i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(im1);
        l3.setIcon(i2);		
		
		l3.addMouseListener(new MouseAdapter()
		{
	       public void mouseClicked(MouseEvent et)
	       {
	    	   setVisible(false);
	    	  new Home().setVisible(true);
	       }
		});
	
		
		t1=new Choice();
		t1.setBounds(140,32,190,25);
		t1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t1);
		
		
		try
		{
			Conn cc = new Conn();
			String sql="select * from account";
			ResultSet rs=cc.s.executeQuery(sql);
			
			while(rs.next())
			{
				t1.add(rs.getString("username"));
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		t2=new JTextField();
		t2.setBounds(140,92,190,25);
		t2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t2);
	
		
		
		b1=new JButton("Delete");
		b1.setBounds(350,60,140,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(b1);
		b1.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ee)
	{
		Conn cc=new Conn();
		try
		{
			if(ee.getSource()==b1)
			{
				String sql="delete from account where username = '"+t1.getSelectedItem()+"'"
						                                 + " and password = '"+t2.getText()+"'";
				
				int i=cc.s.executeUpdate(sql);
				
			    if(i>0)
				{
					JOptionPane.showMessageDialog(null,"Account Deleted Successfully");
					this.setVisible(false);
					new Login_user().setVisible(true);
				}
			    else
			    {
					JOptionPane.showMessageDialog(null,"Error");

			    }
			}
			
		}
		catch(Exception ev)
		{
			ev.printStackTrace();
		}
	}
	
  public static void main(String[] args)
  {
	  new Delete_Account().setVisible(true);
  }
}