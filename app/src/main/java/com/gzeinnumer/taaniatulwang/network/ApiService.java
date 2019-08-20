package com.gzeinnumer.taaniatulwang.network;

import com.gzeinnumer.taaniatulwang.model.ResponseLogin;
import com.gzeinnumer.taaniatulwang.model.ResponseReadDataUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

//todo 3 buat class
public interface ApiService {
    //todo 4 buat fungtion untuk login
    @FormUrlEncoded
    @POST("json/login")
    Call<ResponseLogin> login(@Field("username") String var1,
                              @Field("pass") String var2);
    //todo 5 buat respons

    @GET("json/getDataUser")
    Call<ResponseReadDataUser> getDataUser();
}
