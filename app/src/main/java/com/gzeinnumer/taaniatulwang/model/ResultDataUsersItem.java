package com.gzeinnumer.taaniatulwang.model;

import com.google.gson.annotations.SerializedName;

public class ResultDataUsersItem{

	@SerializedName("nama")
	private String nama;

	@SerializedName("pass")
	private String pass;

	@SerializedName("id")
	private String id;

	@SerializedName("username")
	private String username;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setPass(String pass){
		this.pass = pass;
	}

	public String getPass(){
		return pass;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}