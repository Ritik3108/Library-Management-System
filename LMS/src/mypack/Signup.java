package mypack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Signup extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2;
	JTextField t1,t2,t3;
	JPasswordField pf;
	JComboBox c1;
	JPanel p,p1;
	
	Signup()
	{
		super("Signup");
		setSize(500,500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setLayout(null);
        add(p1);
        		
		p=new JPanel();
		p.setForeground(new Color(39,127,30));
	    p.setBorder(new TitledBorder(new LineBorder(new Color(128,128,0),
				         2),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(34,139,34)));
	    p.setBounds(35,40,400,400);
	    p.setBackground(Color.WHITE);
        p1.add(p);
        p.setLayout(null);
        
        l1=new JLabel("Username :");
        l1.setBounds(55,60,100,30);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        p.add(l1);
        
        /*l2=new JLabel("Name :");
        l2.setBounds(55,110,100,30);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));

        p.add(l2);*/
        
        l3=new JLabel("Password :");
        l3.setBounds(55,110,100,30);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));

        p.add(l3);
        
        l4=new JLabel("Security Question :");
        l4.setBounds(55,160,150,30);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));

        p.add(l4);
        
        l5=new JLabel("Answer :");
        l5.setBounds(55,210,100,30);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));

        p.add(l5);
        
        /*t1=new JTextField();
        t1.setBounds(200,64,150,20);
        t1.setFont(new Font("Tahoma",Font.BOLD,12));
        p.add(t1);*/
        
        t2=new JTextField();
        t2.setBounds(200,64,150,20);
        t2.setFont(new Font("Tahoma",Font.BOLD,12));

        p.add(t2);
        
        pf=new JPasswordField();
        pf.setBounds(200,114,150,20);
        p.add(pf);
        
        String arr[]= {"Your Nickname?","Your Childhood Hero?","Your Favorite Movie?","Your Wish to Become?"};
        c1=new JComboBox(arr);
        c1.setBounds(200,164,150,20);
        p.add(c1);
        
        t3=new JTextField();
        t3.setBounds(200,214,150,20);
        t3.setFont(new Font("Tahoma",Font.BOLD,12));

        p.add(t3);
        
        b1=new JButton("Create");
        b1.setBounds(70,270,120,35);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        p.add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Back");
        b2.setBounds(200,270,120,35);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        p.add(b2);
        b2.addActionListener(this);
        
        
	}
	
	public void actionPerformed(ActionEvent ec)
	{
		
		String a=t2.getText();
		//String b=t2.getText();
		String c=pf.getText();
		String d=(String)c1.getSelectedItem();
		String e=t3.getText();
		
		if(ec.getSource()==b1)
		{
			try
			{
				
				Conn cc = new Conn();
				String st="insert into account values('"+a+"','"+c+"','"+d+"','"+e+"')";
				
				cc.s.executeUpdate(st);
				
				JOptionPane.showMessageDialog(null, "Account Created Successfully");
				
				this.setVisible(false);
				new Home().setVisible(true);
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
		else if(ec.getSource()==b2)
		{
			this.setVisible(false);
			new Login_user().setVisible(true);
		}
		
	}

	public static void main(String[] args) {

		new Signup().setVisible(true);
	}

}
