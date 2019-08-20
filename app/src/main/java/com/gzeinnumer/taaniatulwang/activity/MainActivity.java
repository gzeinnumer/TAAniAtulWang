package com.gzeinnumer.taaniatulwang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gzeinnumer.taaniatulwang.R;
import com.gzeinnumer.taaniatulwang.adapter.AdapterUser;
import com.gzeinnumer.taaniatulwang.helper.SessionManager;
import com.gzeinnumer.taaniatulwang.model.ResponseReadDataUser;
import com.gzeinnumer.taaniatulwang.model.ResultDataUsersItem;
import com.gzeinnumer.taaniatulwang.network.RetroServer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  MainActivity extends AppCompatActivity {

    RecyclerView rvUser;
    SessionManager sessionManager;

    AdapterUser adapterUser;
    List<ResultDataUsersItem> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvUser = findViewById(R.id.rv_user);

        sessionManager = new SessionManager(this);

        //cek status login
        if (sessionManager.getKEY_USERNAME().equals("")){
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }

        fetchDataFromServer();



    }

    private void fetchDataFromServer() {
        RetroServer.getInstance().getDataUser().enqueue(new Callback<ResponseReadDataUser>() {
            @Override
            public void onResponse(Call<ResponseReadDataUser> call, Response<ResponseReadDataUser> response) {
                if (response.isSuccessful()){
                    if(response.body().isStatus()){
                        List<ResultDataUsersItem> list = response.body().getResultDataUsers();
                        if (list.size()>0){
                            adapterUser = new AdapterUser(getApplicationContext(), list);
                            adapterUser.notifyDataSetChanged();
                            rvUser.setAdapter(adapterUser);
                            rvUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        } else {
                            Toast.makeText(MainActivity.this, "data tidak ada", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseReadDataUser> call, Throwable t) {

            }
        });
    }
}