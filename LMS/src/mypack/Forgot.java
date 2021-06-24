package mypack;

import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class Forgot extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3,l4,l5;
	JTextField t2,t3,t4,t5;
	Choice t1;
	JButton b1,b2,b3,b4;
	JPanel p,p1;
	
	
	Forgot()
	{
		super("Forgot Password");
		setSize(600,450);
		setLocationRelativeTo(null);
		setResizable(false);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		add(p);
		
		p1=new JPanel();
		p1.setBorder(new TitledBorder(new LineBorder(new Color(34,89,134),2),
				             "Forgot Password",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(110,218,128)));
		p1.setBounds(20,40,525,350);
		p1.setLayout(null);
		p.add(p1);
		
		l1=new JLabel("Username :");
		l1.setBounds(40,30,100,30);
		l1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l1);
		
		/*l2=new JLabel("Name :");
		l2.setBounds(40,90,100,30);
		l2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l2);*/
		
		l3=new JLabel("Your Security Question :");
		l3.setBounds(40,90,190,30);
		l3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l3);
		
		l4=new JLabel("Answer :");
		l4.setBounds(40,150,120,30);
		l4.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l4);
		
		l5=new JLabel("Password :");
		l5.setBounds(40,210,150,30);
		l5.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l5);
		
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
		
		/*t2=new JTextField();
		t2.setBounds(140,92,190,25);
		t2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t2);*/
		
		t3=new JTextField();
		t3.setBounds(240,92,220,25);
		t3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t3);
		
		t4=new JTextField();
		t4.setBounds(140,152,190,25);
		t4.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t4);
		
		
		t5=new JTextField();
		t5.setBounds(140,212,190,25);
		t5.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t5);
		
		
		b1=new JButton("Search");
		b1.setBounds(350,30,140,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(b1);
		b1.addActionListener(this);
		
		
		b2=new JButton("Retrieve");
		b2.setBounds(350,150,160,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(b2);
		b2.addActionListener(this);

		
		b3=new JButton("Back");
		b3.setBounds(330,270,160,30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(b3);
		b3.addActionListener(this);
		
		
		b4=new JButton("SignIn");
		b4.setBounds(70,270,160,30);
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(b4);
		b4.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ee)
	{
		Conn cc=new Conn();
		try
		{
			if(ee.getSource()==b1)
			{
				String sql="select * from account where username = '"+t1.getSelectedItem()+"'";
				
				ResultSet rs=cc.s.executeQuery(sql);
				
				while(rs.next())
				{
					t3.setText(rs.getString("sec_q"));
				}
				rs.close();		
			}
			else if(ee.getSource()==b2)
			{
				String sq="select * from account where sec_ans = '"+t4.getText()+"'";
				
				ResultSet rs1=cc.s.executeQuery(sq);
				
				if(rs1.next())
				{
					t5.setText(rs1.getString("password"));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect Answer");
				}
			}
			else if(ee.getSource()==b3)
			{
				this.setVisible(false);
				new Login_user().setVisible(true);
			}
			else if(ee.getSource()==b4)
			{
				String sq="select * from account where username = '"+t1.getSelectedItem()+"' "
						           + "and password = '"+t5.getText()+"'";
				
				ResultSet rs=cc.s.executeQuery(sq);
				
				if(rs.next())
				{
				this.setVisible(false);
				new Home().setVisible(true);}
			}
		}
		catch(Exception ev)
		{
			ev.printStackTrace();
		}
	}
	
  public static void main(String[] args)
  {
	  new Forgot().setVisible(true);
  }
}