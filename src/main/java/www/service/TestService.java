package www.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dao.TestMapper;
import www.entity.TestEntity;

@Service
public class TestService {
	@Autowired
	private TestMapper testMapper;
	
	public ArrayList<TestEntity> findAll(){
		ArrayList<TestEntity> list = new ArrayList<TestEntity>();
		list = (ArrayList<TestEntity>) testMapper.select(null);
		return list;
	}
}
