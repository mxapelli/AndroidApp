package edu.upc.androidapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileFragment extends Fragment {
    private static final String MY_PREFS_NAME = "user_pass_pref";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_profile, container,false);
        String usuario = getArguments().getString("usuario");
        TextView text_me = v.findViewById(R.id.text_me);
        text_me.setText("Welcome: "+ usuario);
        return v;


    }

}
