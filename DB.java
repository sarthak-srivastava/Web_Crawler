import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
/**
 * Write a description of DB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DB {
    public Connection conn = null;
    public DB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Crawler";
            conn = DriverManager.getConnection(url,"root","admin213");
            System.out.println("Connection has been established");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch ( ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public ResultSet runSql(String sql) throws SQLException{
        Statement sta = conn.createStatement();
        return sta.execute(sql);
    }
    public boolean runSql2(String sql) throws SQLException {
        Statement sta = conn.createStatement();
        return sta.execute(sql);
    }
    @Override
    protected void finalize() throws Throwable{
        if (conn!=null || !conn.isClosed()){
            conn.close();
        }
    }
}
            
            
            


