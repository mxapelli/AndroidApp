package edu.upc.androidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class App extends AppCompatActivity {
    private static final String MY_PREFS_NAME = "user_pass_pref";
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        //welcome =(TextView) findViewById(R.id.welcome);
        String valor = getIntent().getExtras().getString("usuario");
        //welcome.setText("Welcome: "+ valor);
        BottomNavigationView bottomNav = findViewById(R.id.nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

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
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment=null;
            switch (item.getItemId()){
                case R.id.navigation_me:
                    selectedFragment =new ProfileFragment();
                    break;
                case R.id.navigation_shop:
                    selectedFragment =new ShopFragment();
                    break;
                case R.id.navigation_info:
                    selectedFragment =new InfoFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };
}