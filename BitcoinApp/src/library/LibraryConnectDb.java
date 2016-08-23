package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LibraryConnectDb {
    private Connection conn = null;
    String db = "bitcoin";
    String url = "jdbc:mysql://localhost:3306/"+db+"?useUnicode=true&characterEncoding=UTF-8";
    String user = "root"; 
    String password = "";

    
    public LibraryConnectDb(){
    }
    

    public Connection getConnectMySQL(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Không thể load driver");
        }
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai thông số kết nối");
        }        
        return conn;
    }
}
