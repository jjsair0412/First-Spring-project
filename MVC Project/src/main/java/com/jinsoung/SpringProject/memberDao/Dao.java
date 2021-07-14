package com.jinsoung.SpringProject.memberDao;

import java.sql.DriverManager;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jinsoung.SpringProject.myInfo;
import com.mchange.v2.c3p0.DriverManagerDataSource;

public class Dao implements DaoInfo{
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userid = "scott";
	private String userpw = "tiger";
	
	private myInfo myinfo;
	
	private DriverManagerDataSource dataSource;
	private JdbcTemplate template;

	
	public Dao() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClass(driver);
		dataSource.setJdbcUrl(url);
		dataSource.setUser(userid);
		dataSource.setPassword(userpw);
		
		template = new JdbcTemplate();
		template.setDataSource(dataSource);
	}

	@Override
	public int Insert(String NAME, int NUM, int AGE) {
		int result = 0;
		
		myinfo = new myInfo();
		final String sql = "INSERT INTO member2 (NAME,NUM,AGE) values (?,?,?)";
		result = template.update(sql,NAME,NUM,AGE);

		return result;
	}

	@Override
	public int Read() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Update() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Drop() {
		// TODO Auto-generated method stub
		return 0;
	}

}
