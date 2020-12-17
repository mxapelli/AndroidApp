package edu.upc.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {
    APIInterface apiInterface;
    public static final String MY_PREFS_NAME = "user_pass_pref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        //Inicio guardado directo
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        String username = prefs.getString("username", "");
        String password = prefs.getString("password", "");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Call<Usuario> call=apiInterface.loginUser(new Usuario(username,password,"",""));
                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        Log.d("TAG",response.code()+"");
                        if(response.code()==201){
                            Usuario usuario = response.body();
                            String pswrd=usuario.getPswrd();
                            String uname=usuario.getUname();
                            Log.d("Usuario",uname+" "+pswrd);
                            openApp(uname);
                        }
                        else{
                            Log.d("Error","No shared preference");
                            Intent intent = new Intent(SplashScreen.this, Login.class);
                            startActivity(intent);
                        }
                    }
                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        call.cancel();
                        Log.d("Error","Failure");
                    }
                });
            }
        },2000);

    }

    public void openApp(String uname) {
        Intent intent = new Intent(this, App.class);
        intent.putExtra("usuario", uname);
        startActivity(intent);
    }
}