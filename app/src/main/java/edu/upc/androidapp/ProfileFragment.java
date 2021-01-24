package edu.upc.androidapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    private static final String MY_PREFS_NAME = "user_pass_pref";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_profile, container,false);
        String usuario = getArguments().getString("usuario");
        TextView text_me = v.findViewById(R.id.text_me);
        text_me.setText("Welcome: "+ usuario);
        Button inventory= (Button) v.findViewById(R.id.Inventory);
        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Inventory");
                String[] animals = {"horse", "cow", "camel", "sheep", "goat"};
                builder.setItems(animals, null);
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                // Create the AlertDialog object and return it
                builder.show();

            }
        });
        Button achievements= (Button) v.findViewById(R.id.Achievements);
        achievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Achievements");
                String[] animals = {"horse", "cow", "camel", "sheep", "goat"};
                builder.setItems(animals, null);
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                // Create the AlertDialog object and return it
                builder.show();

            }
        });
        return v;
    }
    private void sendInventory (View view)
    {

    }

}
