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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class ReturnBook extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JDateChooser dc;
	JButton b1,b2,b3;
	JPanel p,p1;
	Choice ch,ch1;
	
	
	public void delete()
	{
		try
		{
			Conn con=new Conn();
		
		String st1="delete from issueBook where book_id = '"+ch.getSelectedItem()+"'";
		int i=con.s.executeUpdate(st1);
		if(i>0)
		{
			JOptionPane.showMessageDialog(null,"Book Returned Successfully");
			setVisible(false);
			new Home().setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Error");

		}	
		}
		catch(Exception ee) {
			
			ee.printStackTrace();
		}
		
	}
	
	ReturnBook()
	{
		super("Return Book");
		setSize(700,500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		add(p);
		
		p1=new JPanel();
		p1.setBorder(new TitledBorder(new LineBorder(new Color(34,89,134),2),
				             "Return Book",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(110,218,128)));
		p1.setBounds(20,40,625,400);
		p1.setLayout(null);
		p.add(p1);
		
		l1=new JLabel("Book_ID :");
		l1.setBounds(40,30,90,30);
		l1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l1);
		
		l2=new JLabel("Book :");
		l2.setBounds(40,90,100,30);
		l2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l2);
		
		l3=new JLabel("Course :");
		l3.setBounds(40,150,100,30);
		l3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l3);
		
		l4=new JLabel("Date Of Issue :");
		l4.setBounds(40,210,120,30);
		l4.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l4);
		
		l5=new JLabel("Date Of Return :");
		l5.setBounds(40,270,150,30);
		l5.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l5);
		
		ch=new Choice();
		ch.setBounds(130,32,110,25);
		ch.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(ch);
		
		try
		{
			Conn cc=new Conn();
			String st="select * from book";
			ResultSet rs=cc.s.executeQuery(st);
			while(rs.next())
			{
				ch.add(rs.getString("book_id"));
			}
		}
		catch(Exception ee)
		{
			
		}
		
		t2=new JTextField();
		t2.setBounds(130,92,130,25);
		t2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t2);
		
		t3=new JTextField();
		t3.setBounds(130,152,130,25);
		t3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t3);
		
		t4=new JTextField();
		t4.setBounds(155,212,150,25);
		t4.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t4);
		
		l6=new JLabel("Student_ID :");
		l6.setBounds(250,30,100,30);
		l6.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l6);
		
		l7=new JLabel("Name :");
		l7.setBounds(270,90,100,30);
		l7.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l7);
		
		l8=new JLabel("Branch :");
		l8.setBounds(270,150,100,30);
		l8.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l8);
		
		ch1=new Choice();
		ch1.setBounds(350,32,110,25);
		ch1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(ch1);
		
		
		l9=new JLabel("View Statistics");
		l9.setBounds(260,5,200,30);
		l9.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p.add(l9);
		
		
		l9.addMouseListener(new MouseAdapter()
		{
	      public void mouseClicked(MouseEvent er)
	      {
	    	  //setVisible(false);
	    	  new Statistics().setVisible(true);
	      }
		});
		
		
		
		
		try
		{
			Conn cc=new Conn();
			String st="select * from student";
			ResultSet rs=cc.s.executeQuery(st);
			while(rs.next())
			{
				ch1.add(rs.getString("student_id"));
			}
		}
		catch(Exception ee)
		{
			
		}
		
		t6=new JTextField();
		t6.setBounds(330,92,250,25);
		t6.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t6);
		
		t7=new JTextField();
		t7.setBounds(350,152,230,25);
		t7.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t7);
		
		b1=new JButton("Search");
		b1.setBounds(480,30,100,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(b1);
		b1.addActionListener(this);
		
		dc=new JDateChooser();
		dc.setBounds(170,270,150,30);
		p1.add(dc);
		
		b2=new JButton("Return");
		b2.setBounds(350,210,250,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(b2);
		b2.addActionListener(this);

		
		b3=new JButton("Back");
		b3.setBounds(340,270,250,30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(b3);
		b3.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ee)
	{
		Conn cc=new Conn();
		try
		{
			if(ee.getSource()==b1)
			{
				String q="select * from issueBook where book_id = '"+ch.getSelectedItem()+"' "
					                              	+ "and student_id = '"+ch1.getSelectedItem()+"'";
				
				ResultSet rs=cc.s.executeQuery(q);
				
				while(rs.next())
				{
					t2.setText(rs.getString("bname"));
					t3.setText(rs.getString("course"));
					t4.setText(rs.getString("dateOfIssue"));
					t6.setText(rs.getString("sname"));
					t7.setText(rs.getString("branch"));
			    }
				rs.close();

			}
			else if(ee.getSource()==b2)
			{
				String q1="insert into returnBook values(?,?,?,?,?,?,?,?)";
				
				PreparedStatement ps=cc.c.prepareStatement(q1);
				
				ps.setString(1,ch.getSelectedItem());
				ps.setString(2,ch1.getSelectedItem());
				ps.setString(3,t2.getText());
				ps.setString(4,t6.getText());
				ps.setString(5,t3.getText());
				ps.setString(6,t7.getText());
				ps.setString(7,t4.getText());
				
				ps.setString(8, ((JTextField)dc.getDateEditor().getUiComponent()).getText());
				
				int i=ps.executeUpdate();
				if(i>0)
				{
					JOptionPane.showMessageDialog(null, "Processing...");
					delete();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
			else if(ee.getSource()==b3)
			{
				this.setVisible(false);
				new Home().setVisible(true);
			}
		}
		catch(Exception ec)
		{
			ec.printStackTrace();
		}
	}
	

	public static void main(String[] args) {

		new ReturnBook().setVisible(true);
	}

}
