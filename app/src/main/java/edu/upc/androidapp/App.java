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
    Bundle args= new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        String usuario = getIntent().getExtras().getString("usuario");
        BottomNavigationView bottomNav = findViewById(R.id.nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        // Colocamos el String
        args.putString("usuario", usuario);
        // Supongamos que tu Fragment se llama TestFragment. Colocamos este nuevo Bundle como argumento en el fragmento.
        Fragment selectedFragment = new ProfileFragment();
        selectedFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

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
                    selectedFragment.setArguments(args);
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