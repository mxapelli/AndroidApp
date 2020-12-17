package edu.upc.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class App extends AppCompatActivity {
    private static final String MY_PREFS_NAME = "user_pass_pref";
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        welcome =(TextView) findViewById(R.id.welcome);
        String valor = getIntent().getExtras().getString("usuario");
        welcome.setText("Welcome: "+ valor);

    }
    public void sendLogout(View view){
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("username", "");
        editor.putString("password", "");
        editor.commit();
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();

    }
}