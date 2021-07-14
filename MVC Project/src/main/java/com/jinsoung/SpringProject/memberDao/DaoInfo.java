package com.jinsoung.SpringProject.memberDao;

public interface DaoInfo {
	public int Insert(String NAME, int NUM, int AGE);
	public int Read();
	public int Update();
	public int Drop();
}
