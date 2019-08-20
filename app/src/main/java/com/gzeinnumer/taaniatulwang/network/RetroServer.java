package com.gzeinnumer.taaniatulwang.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//todo 2 buat untuk koneksi server
public class RetroServer {
    private static final String base_url = "http://192.168.43.52/json-ta--ani-atul-wang/api/";

    private static Retrofit setInit(){
        return new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstance(){
        return setInit().create(ApiService.class);
    }
}
