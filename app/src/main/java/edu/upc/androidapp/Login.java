package edu.upc.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    public static final String MY_PREFS_NAME = "user_pass_pref";
    EditText uname;
    EditText pswrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        apiInterface = APIClient.getClient().create(APIInterface.class);
        //Shared preferences
        uname= (EditText) findViewById(R.id.user);
        pswrd = (EditText) findViewById(R.id.password);
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        String username = prefs.getString("username", "");
        String password = prefs.getString("password", "");
        uname.setText(username);
        pswrd.setText(password);

    }

    public void sendLogin(View view) {
        uname= (EditText) findViewById(R.id.user);
        pswrd = (EditText) findViewById(R.id.password);
        String username = uname.getText().toString();
        String password = pswrd.getText().toString();

        Call<Usuario> call=apiInterface.loginUser(new Usuario(username,password,"", ""));
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Log.d("TAG",response.code()+"");
                if(response.code()==201){
                    Usuario usuario = response.body();
                    String pswrd=usuario.getPswrd();
                    String uname=usuario.getUname();
                    String id=usuario.getID();
                    Log.d("Usuario",uname+" "+pswrd+" "+id);
                    //Guardando en Shared
                    guardarSharedPreferences(uname, pswrd);
                    openApp(id);
                }
                else{
                    Log.d("Error","Login failed");
                    Toast toast = Toast.makeText(getApplicationContext(),"Login failed! Please try again", Toast.LENGTH_LONG);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            toast.show();
                        }
                    });
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
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
    public void openApp(String id) {
        Intent intent = new Intent(this, App.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
    public void guardarSharedPreferences(String username, String password){
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();
    }


}