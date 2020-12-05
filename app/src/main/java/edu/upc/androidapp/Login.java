package edu.upc.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity  {
    APIInterface apiInterface;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login =(TextView) findViewById(R.id.loginMessage);

        apiInterface = APIClient.getClient().create(APIInterface.class);


    }
    public void sendLogin(View view) {
        EditText uname= (EditText) findViewById(R.id.user);
        EditText pswrd = (EditText) findViewById(R.id.password);
        String usuario=uname.getText().toString();
        String password=pswrd.getText().toString();
        Call<Usuario> call=apiInterface.loginUser(new Usuario(usuario,password,"",""));
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
                    Log.d("Error","Login failed");
                    login.setText("Login failed! Please try again");
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                call.cancel();
                Log.d("Error","Failure");
            }
        });
    }

    public void openRegister(View view) {
        login.setText("");
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
    public void openApp(String uname) {
        login.setText("");
        Intent intent = new Intent(this, App.class);
        intent.putExtra("usuario", uname);
        startActivity(intent);
    }


}