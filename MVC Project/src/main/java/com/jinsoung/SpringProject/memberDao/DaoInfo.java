package com.jinsoung.SpringProject.memberDao;

import com.jinsoung.SpringProject.myInfo;

public interface DaoInfo {
	public int Insert(String NAME, int NUM, int AGE);
	public myInfo Read(String NAME);
	public int Update(int NUM, String NAME);
	public int Drop(String NAME);
}
