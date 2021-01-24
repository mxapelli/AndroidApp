package edu.upc.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
    APIInterface apiInterface;
    TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        apiInterface = APIClient.getClient().create(APIInterface.class);

    }

    public void sendRegister(View view) {
        EditText uname= (EditText) findViewById(R.id.user);
        EditText pswrd = (EditText) findViewById(R.id.password);
        EditText emailAddress = (EditText) findViewById(R.id.emailAddress);
        String usuario=uname.getText().toString();
        String password=pswrd.getText().toString();
        String email =emailAddress.getText().toString();
        Call<Usuario> call=apiInterface.createUser(new Usuario(usuario,password,email, ""));
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Log.d("TAG",response.code()+"");
                if (response.code()==201){
                    Usuario usuario = response.body();
                    String pswrd=usuario.getPswrd();
                    String uname=usuario.getUname();
                    Log.d("Usuario",uname+" "+pswrd);
                    Toast toast = Toast.makeText(getApplicationContext(),"Registration succesfull! Go back and sign in", Toast.LENGTH_LONG);
                    toast.show();
                }
                else{
                    Log.d("Error","Register failed");
                    Toast toast = Toast.makeText(getApplicationContext(),"Register failed! Please try again", Toast.LENGTH_LONG);
                    toast.show();
                }

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                call.cancel();
                Log.d("Error","Failure");

            }
        });

    }
    public void goBack(View view) {
        finish();

    }
}