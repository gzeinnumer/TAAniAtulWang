package com.gzeinnumer.taaniatulwang.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseReadDataUser{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("result_data_users")
	private List<ResultDataUsersItem> resultDataUsers;

	@SerializedName("status")
	private boolean status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setResultDataUsers(List<ResultDataUsersItem> resultDataUsers){
		this.resultDataUsers = resultDataUsers;
	}

	public List<ResultDataUsersItem> getResultDataUsers(){
		return resultDataUsers;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}