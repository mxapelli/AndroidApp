package edu.upc.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class App extends AppCompatActivity {
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        welcome =(TextView) findViewById(R.id.welcome);
        String valor = getIntent().getExtras().getString("usuario");
        welcome.setText("Welcome: "+ valor);

    }
}