package course_management_system;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class DeleteInstructor {
//	takes id as parameter to delete the record from the database
	DeleteInstructor(String i){
		delIns(i);
	}
	public void delIns(String i){
		try{
			ConDb c5 = new ConDb();
//			delete from instructor where id = i;
			String q = "delete from instructor where id = ?";
        	PreparedStatement pst = c5.connection.prepareStatement(q);
        	pst.setString(1, i);
        	
        	pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Deleted Successfully");
            c5.connection.close();
            
        }
        catch(Exception ee){
        	JOptionPane.showMessageDialog(null,"Deletion Unsuccessful");
        }
		
		
	}
	

}
