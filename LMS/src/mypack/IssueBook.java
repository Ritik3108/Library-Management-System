package mypack;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class IssueBook extends JFrame implements ActionListener{
	
	JPanel p,p1,p2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
	JButton b1,b2,b3,b4,b5,b6;
	JDateChooser dc;
	Choice ch,ch1;

	IssueBook()
	{
		super("Issue Book");
		setSize(1100,600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		add(p);
		
		p1=new JPanel();
		p1.setBorder(new TitledBorder(new LineBorder(new Color(0,128,12),2),
				           "Add Books",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(128,126,128)));
		p1.setBounds(20,30,420,400);
		p1.setBackground(Color.WHITE);
		p1.setLayout(null);
		p.add(p1);
		
		l1=new JLabel("Book_id :");
		l1.setBounds(70,30,100,30);
		l1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l1);
		
		l2=new JLabel("Name :");
		l2.setBounds(70,80,100,30);
		l2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l2);
		
		l3=new JLabel("ISBN :");
		l3.setBounds(70,130,100,30);
		l3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l3);
		
		l4=new JLabel("Publisher :");
		l4.setBounds(70,180,100,30);
		l4.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l4);
		
		l5=new JLabel("Edition :");
		l5.setBounds(70,230,100,30);
		l5.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l5);
		
		l6=new JLabel("Price :");
		l6.setBounds(70,280,100,30);
		l6.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l6);
		
		l7=new JLabel("Pages :");
		l7.setBounds(70,330,100,30);
		l7.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l7);
		
		
		ch=new Choice();
		ch.setBounds(180,35,100,20);
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
		t2.setBounds(180,85,150,20);
		t2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t2);
		
		t3=new JTextField();
		t3.setBounds(180,135,150,20);
		t3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t3);
		
		t4=new JTextField();
		t4.setBounds(180,185,150,20);
		t4.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t4);
		
		t10=new JTextField();
		t10.setBounds(180,235,150,20);
		t10.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t10);
		
		t5=new JTextField();
		t5.setBounds(180,285,150,20);
		t5.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t5);
		
		t6=new JTextField();
		t6.setBounds(180,335,150,20);
		t6.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t6);
		
		b1=new JButton("Search");
		b1.setBounds(300,30,100,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		p1.add(b1);
		b1.addActionListener(this);
		
		l15=new JLabel("Date Of Issue :");
		l15.setBounds(40,440,130,30);
		l15.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p.add(l15);
		
		dc=new JDateChooser();
		dc.setBounds(170,440,140,28);
		dc.setForeground(Color.BLACK);
		p.add(dc);
		
		
		b2=new JButton("Issue");
		b2.setBounds(60,490,100,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		p.add(b2);
		b2.addActionListener(this);
		
		b3=new JButton("Back");
		b3.setBounds(240,490,100,30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		p.add(b3);
		b3.addActionListener(this);
		
		b5=new JButton("Add Book");
		b5.setBounds(120,00,150,30);
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.setFont(new Font("Trebuchet MS",Font.BOLD,16));
      	p.add(b5);
		b5.addActionListener(this);
		
		b6=new JButton("Add Student");
		b6.setBounds(570,0,150,30);
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		b6.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p.add(b6);
		b6.addActionListener(this);
		
		
		
		
		
		
		
		p2=new JPanel();
		p2.setBorder(new TitledBorder(new LineBorder(new Color(0,128,12),2),
				           "Add Student",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(128,126,128)));
		p2.setBounds(450,30,420,450);
		p2.setBackground(Color.WHITE);
		p2.setLayout(null);
		p.add(p2);
		
		l8=new JLabel("Student_id :");
		l8.setBounds(70,30,100,30);
		l8.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p2.add(l8);
		
		l9=new JLabel("Name :");
		l9.setBounds(70,80,100,30);
		l9.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p2.add(l9);
		
		l10=new JLabel("Father's Name :");
		l10.setBounds(70,130,100,30);
		l10.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p2.add(l10);
		
		l11=new JLabel("Course :");
		l11.setBounds(70,180,100,30);
		l11.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p2.add(l11);
		
		l12=new JLabel("Branch :");
		l12.setBounds(70,230,100,30);
		l12.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p2.add(l12);
		
		l13=new JLabel("Year :");
		l13.setBounds(70,280,100,30);
		l13.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p2.add(l13);
		
		l14=new JLabel("SEMESTER :");
		l14.setBounds(70,330,100,30);
		l14.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p2.add(l14);
		
		
		ch1=new Choice();
		ch1.setBounds(180,35,100,20);
		ch1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p2.add(ch1);
		
		
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
		
		t8=new JTextField();
		t8.setBounds(180,85,150,20);
		t8.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p2.add(t8);
		
		t9=new JTextField();
		t9.setBounds(180,135,150,20);
		t9.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p2.add(t9);
		
		t11=new JTextField();
		t11.setBounds(180,185,150,20);
		t11.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p2.add(t11);
		
		t12=new JTextField();
		t12.setBounds(180,235,150,20);
		t12.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p2.add(t12);
		
		t13=new JTextField();
		t13.setBounds(180,285,150,20);
		t13.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p2.add(t13);
		
		t14=new JTextField();
		t14.setBounds(180,335,150,20);
		t14.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p2.add(t14);
		
		b4=new JButton("Search");
		b4.setBounds(295,30,100,30);
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		p2.add(b4);
		b4.addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent ee)
	{
	   Conn cc=new Conn();
	   try
	   {
		   if(ee.getSource()==b1)
	          {
		   
			   String q="select * from book where book_id = '"+ch.getSelectedItem()+"'";
			  ResultSet rs= cc.s.executeQuery(q);
			  while(rs.next())
			  {
				  t2.setText(rs.getString("name"));
				  t3.setText(rs.getString("isbn"));
				  t4.setText(rs.getString("publisher"));
				  t10.setText(rs.getString("edition"));
				  t5.setText(rs.getString("price"));
				  t6.setText(rs.getString("pages"));

			  }
			  rs.close();
		   }
		   else if(ee.getSource()==b2)
		   {
			   String a=ch.getSelectedItem();
			   String b=ch1.getSelectedItem();
			   String c=t2.getText();
			   String d=t8.getText();
			   String e=t11.getText();
			   String f=t12.getText();
			   String g = ((JTextField)dc.getDateEditor().getUiComponent()).getText();
			   

			   String s="insert into issueBook values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')";
			   cc.s.executeUpdate(s);
			   JOptionPane.showMessageDialog(null, "Book Issued Successfully");
			   setVisible(false);
			   new Home().setVisible(true);
		   }
		   else if(ee.getSource()==b3)
		   {
			 this.setVisible(false);
			 new Home().setVisible(true);
		   }
		   else if(ee.getSource()==b4)
		   {
			   String st="select * from student where student_id = '"+ch1.getSelectedItem()+"'";
			   ResultSet rs=cc.s.executeQuery(st);
			   
			   while(rs.next())
			   {
				   t8.setText(rs.getString("name"));
				   t9.setText(rs.getString("father"));
				   t11.setText(rs.getString("course"));
				   t12.setText(rs.getString("branch"));
				   t13.setText(rs.getString("year"));
				   t14.setText(rs.getString("semester"));

			   }
			   rs.close();
		   }
		   else if(ee.getSource()==b5)
		   {
			   new AddBook().setVisible(true);
		   }
		   
		   else if(ee.getSource()==b6)
		   {
			   new AddStudent().setVisible(true);
		   }
	   }
	   catch(Exception et)
	   {
		   et.printStackTrace();
	   }
	}
	public static void main(String[] args) {

		new IssueBook().setVisible(true);
	}

}
