package mypack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener{
	
	JPanel p,p1;
	JTable t;
	JLabel l1,l2,l3;
	JTextField t1;
	JButton b1,b2;
	
	public void Student()
	{
		try
		{
			Conn cc=new Conn();
		
		String sq="select * from student";
		ResultSet rs=cc.s.executeQuery(sq);
		
		t.setModel(DbUtils.resultSetToTableModel(rs));
		rs.close();
		cc.s.close();
		}
		catch(Exception ec)
		{
			ec.printStackTrace();
		}
	}
	
	StudentDetails()
	{
		super("Student Details");
		setSize(1000,580);
		setLocationRelativeTo(null);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		add(p);
		
		p1=new JPanel();
		p1.setBorder(new TitledBorder(new LineBorder(new Color(45,67,22),2),
				                 "Student-Details",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(110,99,89)));
		p1.setBounds(10,40,950,460);
		p1.setBackground(Color.WHITE);
		p1.setLayout(null);
		p.add(p1);
		
		JScrollPane sp = new JScrollPane(); 
		sp.setBounds(10,90,930,355);	
		p1.add(sp);
		
		
		
		
		t=new JTable();
		t.setFont(new Font("Trebuchet MS",Font.BOLD,14));
		t.addMouseListener(new MouseAdapter()
				{
			        public void mouseClicked(MouseEvent ev)
			        {
			        	int row=t.getSelectedRow();
			        	t1.setText(t.getModel().getValueAt(row, 1).toString());
			        }
				});
		sp.setViewportView(t);
		Student();
		
		JLabel l1 = new JLabel("Student Details");
		l1.setForeground(new Color(107, 142, 35));
		l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		l1.setBounds(300, 2, 400, 47);
		p.add(l1);
		
		JLabel l2= new JLabel("Back");
		l2.setForeground(new Color(107, 142, 35));
		l2.setBounds(70, 40, 110, 30);
		l2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC,19));
		
		l2.addMouseListener(new MouseAdapter()
				{
			       public void mouseClicked(MouseEvent et)
			       {
			    	   setVisible(false);
			    	  new Home().setVisible(true);
			       }
				});
			
		
		p1.add(l2);
		
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("mypack/icons/tenth.png"));
		Image im1=i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(im1);
        l2.setIcon(i2);	
        
        
        l3= new JLabel("Add Student >");
		l3.setBounds(800, 40, 110, 30);
		l3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC,16));
		p1.add(l3);
		
		l3.addMouseListener(new MouseAdapter()
				{
			       public void mouseClicked(MouseEvent et)
			       {
			    	   //setVisible(false);
			    	  new AddStudent().setVisible(true);
			       }
				});
		
		t1 = new JTextField();
		t1.setBackground(new Color(255, 240, 245));
		t1.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
		t1.setForeground(new Color(40, 19, 79));
		t1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		t1.setBounds(165, 39, 357, 33);
		p1.add(t1);
		//t1.setColumns(10);
		
		
		/*b1 = new JButton("Search");
		b1.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));	
		b1.setForeground(new Color(199, 21, 133));
		b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		b1.setBounds(564, 39, 138, 33);
		p1.add(b1);
		b1.addActionListener(this);
		
		ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/eight.png"));
	    Image im2 = i3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
	    ImageIcon i4 = new ImageIcon(im2);
	    b1.setIcon(i4);*/
	    
	    
	    
	    b2 = new JButton("Delete");
		b2.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));	
		b2.setForeground(new Color(199, 21, 133));
		b2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		b2.setBounds(624, 39, 138, 33);
		p1.add(b2);
		b2.addActionListener(this);
		
		ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("mypack/icons/nineth.png"));
	    Image im3 = i5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
	    ImageIcon i6 = new ImageIcon(im3);
	    b2.setIcon(i6);

		
		
		
				                 		
	}
	
	public void actionPerformed(ActionEvent ee)
	{
		Conn cc=new Conn();
		try
		{
			
			if(ee.getSource()==b2)
			{
				
				String sql="delete from student where name = '"+t1.getText()+"'";
				


				
				JDialog.setDefaultLookAndFeelDecorated(true);

				int rs=JOptionPane.showConfirmDialog(null, "Do You Confirm?",
						             "Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if(rs==JOptionPane.YES_OPTION)
				{
					cc.s.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Student Deleted Successfully");
					setVisible(false);
					new Home().setVisible(true);
				}
				
				else if(rs==JOptionPane.NO_OPTION)
				{
					
				}
				setVisible(false);
			}
			
		}
		catch(Exception er)
		{
			er.printStackTrace();
		}
	}

	public static void main(String[] args) {

		new StudentDetails().setVisible(true);
	}

}
