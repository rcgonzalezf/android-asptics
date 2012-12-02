package org.asptics.sqlitetest.model;

import java.io.Serializable;

public class HiScore implements Serializable {

	public HiScore(String email, Integer hiScore, String userName) {
		super();
		this.email = email;
		this.hiScore = hiScore;
		this.userName = userName;
	}
	
	public HiScore(){}
	/**
	 * 
	 */
	private static final long serialVersionUID = -1394207852623124181L;
	
	private String email;
	private Integer hiScore;
	private String userName;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getHiScore() {
		return hiScore;
	}
	public void setHiScore(Integer hiScore) {
		this.hiScore = hiScore;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Mail:" +email);
		sb.append(", Score:"+hiScore);
		sb.append(", userName:"+userName);
		return sb.toString();
		

	}

}
