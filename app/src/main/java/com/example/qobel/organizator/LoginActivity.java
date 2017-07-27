package com.example.qobel.organizator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.qobel.organizator.entity.OrganizationEntity;
import com.example.qobel.organizator.entity.UserEntity;
import com.example.qobel.organizator.network.ServisGenerater;
import com.example.qobel.organizator.network.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    UserService userService;
    EditText email,password;
    Button loginButton,registerButton;
    UserEntity userEntity;
    ServisGenerater servisGenerater;
    UserLocalStore userLocalStore;
    Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.loginButton);
        registerButton = (Button) findViewById(R.id.registerIntent);
        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
        userService  = ServisGenerater.createService(UserService.class);
        userLocalStore = new UserLocalStore(getApplicationContext());
        intent =  new Intent(this,OrganizationListActivity.class);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()  == registerButton.getId()) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }else if(v.getId() == loginButton.getId()){
            doLogin();
        }
    }
    public void doLoginWithValley(){
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest  = new StringRequest(Request.Method.GET, "http://10.0.2.2/Oraga", new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.print("Response is " + response);
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.print("Response is "+ error);
            }
        });
        queue.add(stringRequest);
    }
    public void doLogin(){

        String name = this.email.getText().toString();
        String password = this.password.getText().toString();
        Call<UserEntity> userEntityCall = userService.userLogin(name,password);
        userEntityCall.enqueue(userEntityCallback);

        System.out.println("@login started");
    }
    private Callback<UserEntity> userEntityCallback = new Callback<UserEntity>(){

        @Override
        public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
            if(response.isSuccessful()){
                userEntity = response.body();
                if(userEntity.getResponse().equalsIgnoreCase("False")){
                    Toast.makeText(getApplicationContext(),userEntity.getError(),Toast.LENGTH_SHORT).show();
                }else{

                    userLocalStore.storeUserData(userEntity);
                    userLocalStore.setUserLoggedIn(true);

                    startActivity(intent);

                }
            }
        }

        @Override
        public void onFailure(Call<UserEntity> call, Throwable t) {
            Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            System.out.println("Caner ;ERROR : "+t.getMessage());
        }
    };
}
