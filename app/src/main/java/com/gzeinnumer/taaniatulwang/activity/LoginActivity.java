package com.gzeinnumer.taaniatulwang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.taaniatulwang.R;
import com.gzeinnumer.taaniatulwang.helper.SessionManager;
import com.gzeinnumer.taaniatulwang.model.ResponseLogin;
import com.gzeinnumer.taaniatulwang.network.RetroServer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//todo 1 buat activity baru

public class LoginActivity extends AppCompatActivity {

    EditText edUsername, edPass;
    Button btnLogin, btnToRegis;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.ed_username);
        edPass = findViewById(R.id.ed_pass);
        btnLogin = findViewById(R.id.btn_login);
        btnToRegis = findViewById(R.id.btn_to_regis);

        sessionManager = new SessionManager(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchLogin();
            }
        });

        btnToRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void fetchLogin() {
        String username = edUsername.getText().toString().trim();
        String pass = edPass.getText().toString().trim();

        if (!username.equals("") && ! pass.equals("")){
            RetroServer.getInstance().login(username, pass).enqueue(new Callback<ResponseLogin>() {
                @Override
                public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                    if (response.isSuccessful()){
                        if (response.body().isStatus()){
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                            sessionManager.setKEY_ID(response.body().getResultDataLoginUsers().get(0).getId());
                            sessionManager.setKEY_NAME(response.body().getResultDataLoginUsers().get(0).getNama());
                            sessionManager.setKEY_USERNAME(response.body().getResultDataLoginUsers().get(0).getUsername());

                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Password salah", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseLogin> call, Throwable t) {

                }
            });
        } else {
            Toast.makeText(this, "silahkan masukan pass word", Toast.LENGTH_SHORT).show();
        }
    }
}
