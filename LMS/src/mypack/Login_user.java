package mypack;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login_user extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3;
	Choice t1;
	JPasswordField pf;
	JButton b1,b2,b3;
	JPanel p1;
	
	Login_user()
	{
		super("Login");
		//setBackground(new Color(169, 169, 169));	

		setSize(500,450);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
				
		p1=new JPanel();
		p1.setBounds(0,0,500,450);
		p1.setBackground(new Color(176,224,230));
        setContentPane(p1);
        p1.setLayout(null);
        
        
		l1=new JLabel("Username:");
		l1.setBounds(100,90,100,30);
		add(l1);
		
		t1=new Choice();
		t1.setBounds(200,95,200,20);
		add(t1);
		
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
		
		l2=new JLabel("Password:");
		l2.setBounds(100,140,100,30);
		add(l2);
		
	    pf=new JPasswordField();
		pf.setBounds(200,145,200,20);
		add(pf);
		
		b1=new JButton("SignIn");
		b1.setBounds(120,210,100,30);
		add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("SignUp");
		b2.setBounds(250,210,100,30);
		add(b2);
		b2.addActionListener(this);

		
		l3=new JLabel("Trouble in Login?");
		l3.setBounds(80,280,100,30);
		l3.setForeground(Color.RED);
		add(l3);
		
		l3.addMouseListener(new MouseAdapter()
				{
			      public void mouseClicked(MouseEvent er)
			      {
			    	  setVisible(false);
			    	  new Forgot().setVisible(true);
			      }
				});
		
		b3=new JButton("Forgot Password");
		b3.setBounds(200,280,200,30);
		add(b3);
		b3.addActionListener(this);

		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ev)
	{
		Conn cc=new Conn();
		try
		{
			if(ev.getSource()==b1)
		
		       {
				
				String r="select * from account where username=? and password=?";
				
				PreparedStatement ps=cc.c.prepareStatement(r);
				
				ps.setString(1, t1.getSelectedItem());
				ps.setString(2, pf.getText());

				
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					this.setVisible(false);
					new Loading().setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Login!");
				}
				
			}
			else if(ev.getSource()==b2)
			{
				this.setVisible(false);
				new Signup().setVisible(true);
			
		    }
			else if(ev.getSource()==b3)
			{
				this.setVisible(false);
				new Forgot().setVisible(true);
			}
			
		}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}

	public static void main(String[] args) {
		
		

		new Login_user();
	}

}
