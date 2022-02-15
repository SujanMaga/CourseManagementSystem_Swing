package course_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;



public class ViewInstructor extends JFrame implements ActionListener {
//	admin can view all the info. of instructor by the help of this class
	
	private JTable instructorTable;
	private JScrollPane scrollPane;
	private JLabel label1, heading;
	private JTextField idTextField;
	private JButton del;
	
	public void loadDetail() {
        try {
            ConDb c7 = new ConDb();
            String q = "select * from instructor";
            PreparedStatement st = c7.connection.prepareStatement(q);
//            load details and place it in the instructorTable
//          needs external jar file rs2xml
            ResultSet rs = st.executeQuery();

            instructorTable.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            c7.connection.close();
        } catch (Exception e) {
        	
        }

    }
	
	ViewInstructor(){
		setTitle("Course-Management-System");
		setBounds(100, 100, 1000, 550);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		

		
		label1 = new JLabel("Enter Id to delete");
		label1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		label1.setBackground(Color.BLACK);
		label1.setBounds(69, 92, 285, 40);
		add(label1);
		
		heading = new JLabel("Instructor Details");
		heading.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 36));
		heading.setBounds(399, 10, 400, 55);
		add(heading);
		
		idTextField = new JTextField();
		idTextField.setBounds(364, 92, 240, 32);
		idTextField.setColumns(10);
		add(idTextField);
		
		del = new JButton("Delete");
		del.setForeground(Color.WHITE);
		del.setBackground(Color.BLUE);
		del.setFocusable(false);
		del.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		del.setBounds(649, 92, 100, 33);
		del.addActionListener(this);
		add(del);
		
		
		instructorTable = new JTable();
		
		
//		overriding mouseClicked only to use that method
		instructorTable.addMouseListener(new MouseAdapter() {
//			getting particular id when row is clicked
            public void mouseClicked(MouseEvent arg) {
               int row = instructorTable.getSelectedRow();
               idTextField.setText(instructorTable.getModel().getValueAt(row, 0).toString());
            }
        });
		
//		Scrolling effect on instructorTable
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(instructorTable);
		scrollPane.setBounds(0, 166, 986, 321);
		add(scrollPane);
		
		
		loadDetail();
		
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new ViewInstructor();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			ConDb c5 = new ConDb();
//			admins delete instructor
            if(e.getSource() == del){            
                new DeleteInstructor(idTextField.getText());
                dispose();
                new ViewInstructor();
                c5.connection.close();
            };
        }
        catch(Exception ee){
        	
        }
    }
	}

