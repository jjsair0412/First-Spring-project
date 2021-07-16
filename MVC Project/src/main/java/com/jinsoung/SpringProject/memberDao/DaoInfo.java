package com.jinsoung.SpringProject.memberDao;

import java.util.List;

import com.jinsoung.SpringProject.myInfo;

public interface DaoInfo {
	public int Insert(String NAME, int NUM, int AGE);
	public myInfoDto Read(String NAME);
	public int Update();
	public int Drop();
}
