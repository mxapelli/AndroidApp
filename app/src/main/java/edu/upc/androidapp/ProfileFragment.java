package edu.upc.androidapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {
    APIInterface apiInterface;
    Inventory inventory= new Inventory();
    Achievements achievements= new Achievements();
    Usuario user=new Usuario();
    String id;
    private static final String MY_PREFS_NAME = "user_pass_pref";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        apiInterface = APIClient.getClient().create(APIInterface.class);
        id = getArguments().getString("ID");
        View v= inflater.inflate(R.layout.fragment_profile, container,false);
        TextView text_me = v.findViewById(R.id.text_me);
        text_me.setText("Welcome: "+ id);
        TextView email=v.findViewById(R.id.email);
        email.setText(user.getEmail());
        TextView username=v.findViewById(R.id.username);
        username.setText(user.getUname());
        TextView cash=v.findViewById(R.id.coins);
        cash.setText("Coins:"+ user.getCash());
        Button inventoryButton= (Button) v.findViewById(R.id.Inventory);
        //CallInventory
        Call<Inventory> inventoryCall =apiInterface.getInventory(id);
        inventoryCall.enqueue(new Callback<Inventory>() {
            @Override
            public void onResponse(Call<Inventory> call, Response<Inventory> response) {
                Log.d("TAG",response.code()+"");
                if(response.code()==200){
                    inventory=response.body();
                }
            }
            @Override
            public void onFailure(Call<Inventory> call, Throwable t) {
                call.cancel();
                Log.d("Error","Failure");
            }
        });
        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Inventory");
                String[] listInventory= {"Turtle: "+ inventory.getTurtleQuantity(), "Coffee: " + inventory.getCoffQuantity(), "Redbull: "+ inventory.getRedbullQuantity(), "Pills: "+inventory.getPillsQuantity(), "Calculator: "+ inventory.getCalculatorQuantity(), "Rule: "+ inventory.getRuleQuantity(), "Compass: "+ inventory.getCompassQuantity(), "Pencil: " + inventory.getPencilQuantity(), "Glasses: "+ inventory.getGlassesQuantity(), "Puzzle: "+inventory.getPuzzleQuantity(),"Book: "+ inventory.getBookQuantity(),"Usb: "+ inventory.getUsbQuantity(),"Cheat: "+inventory.getCheatQuantity()};
                builder.setItems(listInventory, null);
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
        Button achievementsButton= (Button) v.findViewById(R.id.Achievements);
        //CallAchievements
        Call<Achievements> achievementsCall =apiInterface.getAchievements(id);
        achievementsCall.enqueue(new Callback<Achievements>() {
            @Override
            public void onResponse(Call<Achievements> call, Response<Achievements> response) {
                Log.d("TAG",response.code()+"");
                if(response.code()==200){
                    achievements=response.body();
                }
            }
            @Override
            public void onFailure(Call<Achievements> call, Throwable t) {
                call.cancel();
                Log.d("Error","Failure");
            }
        });
        achievementsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Achievements");
                String[] listAchievements = {"Calculus: "+ achievements.getCalcAch(), "Electronics: "+ achievements.getElectronicsAch(), "Communication: "+ achievements.getCommsAch(), "OESC: "+ achievements.getOescAch(), "DSA: "+ achievements.getDsaAch(),"Aerodynamics: "+ achievements.getAeroAch(),"TFG: "+ achievements.getTfgAch()};
                builder.setItems(listAchievements, null);
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


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        id = getArguments().getString("ID");
        Call<Usuario> userCall =apiInterface.getUser(id);
        userCall.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Log.d("TAG",response.code()+"");
                if(response.code()==200){
                    user=response.body();
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                call.cancel();
                Log.d("Error","Failure");
            }
        });




    }

}
