package www.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 数据库连接工具类
 * @author haoxinyu
 *
 */
public class DbUtil {
	private static Connection conn;
	private static String databaseName="test_util";
	private static String password="root";
	private static String username="root";
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	private static DbUtil dbutil=new DbUtil();
	private DbUtil(){}
	/**
	 * 获得数据库链接
	 * @return
	 */
	public static Connection getConnection(){
		try {
			conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/"+databaseName,username,password);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConnection(){
		try {
			if(conn!=null&&!conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("数据库关闭失败");
			e.printStackTrace();
		}
	}
	public static DbUtil getDbutil() {
		return dbutil;
	}
}
