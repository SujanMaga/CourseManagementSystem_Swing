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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;



public class ViewModules extends JFrame{
	
	private JTable moduleTable;
	private JScrollPane scrollPane;
	private JLabel heading;
	
	public void loadDetail() {
        try {
            ConDb c7 = new ConDb();
           
            String q = "select module1, module2,module3,module4,module5,module6,course,year from modules where id is NULL";
            PreparedStatement st = c7.connection.prepareStatement(q);
            ResultSet rs = st.executeQuery();
            
//        load details and place it in the moduleTable
//        needs external jar file rs2xml
            moduleTable.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            c7.connection.close();
        } catch (Exception e) {
        	
        }

    }
	
	ViewModules(){
		setTitle("Course-Management-System");
		setBounds(100, 100, 1000, 550);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		

		heading = new JLabel("Module Details");
		heading.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 36));
		heading.setBounds(399, 10, 240, 55);
		add(heading);
		
		
		
		
		moduleTable = new JTable();
		
//		Scrolling effect on moduleTable
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(moduleTable);
		scrollPane.setBounds(0, 166, 986, 321);
		add(scrollPane);
		
		
		loadDetail();
		
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new ViewModules();
	}


	}

