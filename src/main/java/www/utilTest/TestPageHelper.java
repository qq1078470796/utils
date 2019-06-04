package www.utilTest;

import java.util.ArrayList;

import www.entity.TestEntity;
import www.utils.PageHelper;

public class TestPageHelper {
	public static void main(String[] args) {
		 TestService ts = new TestService();
		 ArrayList<TestEntity> list ;
		 PageHelper.startPage(null, null);
		 list=ts.getAll();
	     PageHelper.Page CendPage = PageHelper.endPage();
	     
	     System.out.println(list.get(0).getName());
	     
	}
}
