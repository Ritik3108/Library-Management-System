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

public class AddBook extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6;
	JComboBox c1;
	JPanel p,p1;
	JButton b1,b2;
	
	public void random()
	{
		Random rd=new Random();
		t1.setText("" + rd.nextInt(1000+1));
		t3.setText(rd.nextInt(1000000000+1)+"1234");
	}
	
	AddBook()
	{
		super("Add Book");
		setSize(500,530);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		p=new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		add(p);
		
		p1=new JPanel();
		p1.setBorder(new TitledBorder(new LineBorder(new Color(0,128,12),2),
				           "Add Books",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(128,126,128)));
		p1.setBounds(20,30,420,450);
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
		
		
		l8=new JLabel("Book Details >");
		l8.setBounds(180,2,170,30);
		l8.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p.add(l8);
		
		l8.addMouseListener(new MouseAdapter()
		{
	      public void mouseClicked(MouseEvent er)
	      {
	    	  //setVisible(false);
	    	  new BookDetails().setVisible(true);
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
		
		t4=new JTextField();
		t4.setBounds(180,185,150,20);
		t4.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t4);
		
		String Arr[]= {"1","2","3","4","5","6","7","8"};
		c1=new JComboBox(Arr);
		c1.setBounds(180,235,150,20);
		c1.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(c1);
		
		t5=new JTextField();
		t5.setBounds(180,285,150,20);
		t5.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t5);
		
		t6=new JTextField();
		t6.setBounds(180,335,150,20);
		t6.setFont(new Font("Trebuchet MS",Font.BOLD,16));
		p1.add(t6);
		
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
		Conn ccq=new Conn();
		
		String a=t1.getText();
		String b=t2.getText();
		String c=t3.getText();
		String d=t4.getText();
		String e=(String)c1.getSelectedItem();
		String f=t5.getText();
		String g=t6.getText();

		try
		{
			if(ev.getSource()==b1)
		    {
			
				String q="insert into book values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')";
				ccq.s.executeUpdate(q);
				JOptionPane.showMessageDialog(null, "Book Added Successfully");
				setVisible(false);
				new Home().setVisible(true);
			}
			else if(ev.getSource()==b2)
			{
				this.setVisible(false);
				new Home().setVisible(true);
			}
		}
		catch(Exception ee)
			{
				ee.printStackTrace();
			}
		
	}
	

	public static void main(String[] args) {

		new AddBook().setVisible(true);
	}

}
