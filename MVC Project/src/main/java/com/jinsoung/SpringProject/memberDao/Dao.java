package com.jinsoung.SpringProject.memberDao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.jinsoung.SpringProject.myInfo;
import com.mchange.v2.c3p0.DriverManagerDataSource;

public class Dao implements DaoInfo{
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userid = "scott";
	private String userpw = "tiger";
	
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
		System.out.println("Insert ¸Þ¼­µå run");
		final String sql = "insert into member2 values(?,?,?)";
		result = template.update(sql,NAME,NUM,AGE);
		
		return result;
	}

	@Override
	public myInfoDto Read(final String NAME) {
		List<myInfoDto> members = null;
		final String sql = "SELECT * FROM member2 where NAME = ?";
		
		members = template.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, NAME);
				
			}
		}, new RowMapper<myInfoDto>() {

			@Override
			public myInfoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				myInfoDto myinfoSelf = new myInfoDto();
				myinfoSelf.setSelfNAME(rs.getString("NAME"));
				myinfoSelf.setSelfNUM(rs.getInt("NUM"));
				myinfoSelf.setSlefAGE(rs.getInt("AGE"));
				
				System.out.println(rs.getString("NAME"));
				System.out.println(rs.getInt("NUM"));
				System.out.println(rs.getInt("AGE"));
				return myinfoSelf;
			}
		});
		
		if(members.isEmpty()) {
			return null;
		}else {
			return members.get(0);
		}
		
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
