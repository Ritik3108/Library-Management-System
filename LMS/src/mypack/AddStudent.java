package mypack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AddStudent extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3;
	JComboBox c1,c2,c3,c4;
	JPanel p,p1;
	JButton b1,b2;
	
	public void random()
	{
		Random rd=new Random();
		t1.setText("" + rd.nextInt(10000+1));
		
	}
	
	AddStudent()
	{
		super("Add Student");
		setSize(500,530);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		p=new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		add(p);
		
		p1=new JPanel();
		p1.setBorder(new TitledBorder(new LineBorder(new Color(0,128,12),2),
				           "Add Student",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(128,126,128)));
		p1.setBounds(20,30,420,450);
		p1.setBackground(Color.WHITE);
		p1.setLayout(null);
		p.add(p1);
		
		l1=new JLabel("Student_id :");
		l1.setBounds(70,30,100,30);
		l1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l1);
		
		l2=new JLabel("Name :");
		l2.setBounds(70,80,100,30);
		l2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l2);
		
		l3=new JLabel("Father's Name :");
		l3.setBounds(70,130,100,30);
		l3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l3);
		
		l4=new JLabel("Course :");
		l4.setBounds(70,180,100,30);
		l4.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l4);
		
		l5=new JLabel("Branch :");
		l5.setBounds(70,230,100,30);
		l5.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l5);
		
		l6=new JLabel("Year :");
		l6.setBounds(70,280,100,30);
		l6.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l6);
		
		l7=new JLabel("SEMESTER :");
		l7.setBounds(70,330,100,30);
		l7.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(l7);
		
		l8=new JLabel("Student Details >");
		l8.setBounds(160,2,170,30);
		l8.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p.add(l8);
		
		l8.addMouseListener(new MouseAdapter()
		{
	      public void mouseClicked(MouseEvent er)
	      {
	    	  //setVisible(false);
	    	  new StudentDetails().setVisible(true);
	      }
		});
		
		
		t1=new JTextField();
		t1.setBounds(180,35,150,20);
		t1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t1);
		
		t2=new JTextField();
		t2.setBounds(180,85,150,20);
		t2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t2);
		
		t3=new JTextField();
		t3.setBounds(180,135,150,20);
		t3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t3);
		
		String Arr[]= {"B.TECH","M.TECH","BBA","MBA","BCA","MCA","BSc"};
		c1=new JComboBox(Arr);
		c1.setBounds(180,185,150,20);
		c1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(c1);
		
		String Arr1[]= {"CSE","ME","Civil","Electronics","IT","Electrical"};
		c2=new JComboBox(Arr1);
		c2.setBounds(180,235,150,20);
		c2.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(c2);
		
		String Arr2[]= {"1st","2nd","3rd","4th"};
		c3=new JComboBox(Arr2);
		c3.setBounds(180,285,150,20);
		c3.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(c3);
		
		String Arr3[]= {"1st","2nd","3rd","4th","5th","6th","7th","8th"};
		c4=new JComboBox(Arr3);
		c4.setBounds(180,335,150,20);
		c4.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(c4);
		
		b1=new JButton("ADD");
		b1.setBounds(90,390,100,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		p1.add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("BACK");
		b2.setBounds(230,390,100,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		p1.add(b2);
		b2.addActionListener(this);
		random();

		
		
	}
	
	public void actionPerformed(ActionEvent ev)
	{
		Conn cc=new Conn();
		
		String a=t1.getText();
		String b=t2.getText();
		String c=t3.getText();
		String d=(String)c1.getSelectedItem();
		String e=(String)c2.getSelectedItem();
		String f=(String)c3.getSelectedItem();
		String g=(String)c4.getSelectedItem();

		if(ev.getSource()==b1)
		{
			try
			{
				String q="insert into student values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')";
				cc.s.executeUpdate(q);
				JOptionPane.showMessageDialog(null, "Student Added Successfully");
				setVisible(false);
				new Home().setVisible(true);
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
		else if(ev.getSource()==b2)
		{
			this.setVisible(false);
			new Home().setVisible(true);
		}
	}
	

	public static void main(String[] args) {

		new AddStudent().setVisible(true);
	}

}
