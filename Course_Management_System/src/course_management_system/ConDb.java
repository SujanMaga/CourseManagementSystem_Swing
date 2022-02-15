package course_management_system;

import java.sql.*;  

public class ConDb{
//	object of this class can be used to connect to db
    public Connection connection;
    public Statement statement;
    public ConDb(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");    
            statement =connection.createStatement();  
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
