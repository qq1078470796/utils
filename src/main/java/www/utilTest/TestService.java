package www.utilTest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import www.entity.TestEntity;
import www.utils.DbUtil;


public class TestService {
	public ArrayList<TestEntity> getAll(){
		ArrayList<TestEntity> list = new ArrayList<TestEntity>();
		try {
			PreparedStatement pstat = DbUtil.getConnection()
					.prepareStatement("select * from test");
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()){
				TestEntity temp = new TestEntity();
				temp.setName(rs.getString("name"));
				temp.setSex(rs.getString("sex"));
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return list;
	}
	public static void main(String[] args) {
		TestService ts = new TestService();
		ArrayList<TestEntity> list= ts.getAll();
		System.out.println(list.get(0).getName());
	}
}
