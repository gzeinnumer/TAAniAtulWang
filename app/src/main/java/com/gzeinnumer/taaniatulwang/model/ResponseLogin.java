package com.gzeinnumer.taaniatulwang.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseLogin{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("result_data_login_users")
	private List<ResultDataLoginUsersItem> resultDataLoginUsers;

	@SerializedName("status")
	private boolean status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setResultDataLoginUsers(List<ResultDataLoginUsersItem> resultDataLoginUsers){
		this.resultDataLoginUsers = resultDataLoginUsers;
	}

	public List<ResultDataLoginUsersItem> getResultDataLoginUsers(){
		return resultDataLoginUsers;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}