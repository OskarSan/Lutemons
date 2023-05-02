package com.example.lutemons.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.lutemons.Lutemon;
import com.example.lutemons.R;
import com.example.lutemons.Storage;


public class CreateLutemonFragment extends Fragment {
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    public CreateLutemonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_lutemon, container, false);
        Button btnCreateLutemon = view.findViewById(R.id.btnCreateLutemon);
        btnCreateLutemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createLutemon(view);

            }
        });
        return view;
    }
    public void createLutemon(View view){

        EditText etLutemonName = view.findViewById(R.id.etLutemonName);
        RadioGroup rgLutemonClass = view.findViewById(R.id.rgLutemonClass);
        RadioGroup rgLutemonColor = view.findViewById(R.id.rgLutemonColor);

        switch (rgLutemonColor.getCheckedRadioButtonId()) {
            case R.id.rbWhite:
                switch (rgLutemonClass.getCheckedRadioButtonId()) {
                    case R.id.rbTank:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "White", "Tank", 10, 15, 0, 100, 100, 0, 0, R.drawable.tankki_valkoinen, 0));
                        break;
                    case R.id.rbWarrior:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "White", "Warrior", 15, 12, 0, 90, 90, 0, 0, R.drawable.warrior_valkonen, 0));
                        break;
                    case R.id.rbScout:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "White", "Scout", 15, 10, 0, 80, 80, 0, 0, R.drawable.scout_valkoinen, 0));
                        break;
                }
                break;
            case R.id.rbGreen:
                switch (rgLutemonClass.getCheckedRadioButtonId()) {
                    case R.id.rbTank:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Green", "Tank", 12, 13, 0, 110, 110, 0, 0, R.drawable.tankki_vihre_, 0));
                        break;
                    case R.id.rbWarrior:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Green", "Warrior", 17, 10, 0, 100, 100, 0, 0, R.drawable.warrior_vihre_, 0));
                        break;
                    case R.id.rbScout:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Green", "Scout", 17, 8, 0, 70, 70, 0, 0, R.drawable.scout_vihre_, 0));
                        break;
                }
                break;
            case R.id.rbPink:
                switch (rgLutemonClass.getCheckedRadioButtonId()) {
                    case R.id.rbTank:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Pink", "Tank", 8, 18, 0, 90, 90, 0, 0, R.drawable.tankki_pinkki, 0));
                        break;
                    case R.id.rbWarrior:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Pink", "Warrior", 13, 15, 0, 80, 80, 0, 0, R.drawable.warrior_pinkki, 0));
                        break;
                    case R.id.rbScout:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Pink", "Scout", 18, 8, 0, 60, 60, 0, 0, R.drawable.scout_pinkki, 0));
                        break;
                }
                break;
            case R.id.rbOrange:
                switch (rgLutemonClass.getCheckedRadioButtonId()) {
                    case R.id.rbTank:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Orange", "Tank", 10, 14, 0, 120, 120, 0, 0, R.drawable.tankki_oranssi, 0));
                        break;
                    case R.id.rbWarrior:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Orange", "Warrior", 15, 11, 0, 110, 110, 0, 0, R.drawable.warrior_oranssi, 0));
                        break;
                    case R.id.rbScout:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Orange", "Scout", 15, 9, 0, 90, 90, 0, 0, R.drawable.scout_oranssi, 0));
                        break;
                }
                break;
            case R.id.rbBlack:
                switch (rgLutemonClass.getCheckedRadioButtonId()) {
                    case R.id.rbTank:
                        Storage.getInstance().addLutemon(new Lutemon("Ronnie Coleman", "Black", "Tank", 21, 20, 0, 300, 300, 0, 0, R.drawable.ronnie, 0));
                        break;
                    case R.id.rbWarrior:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Black", "Warrior", 16, 8, 0, 120, 120, 0, 0, R.drawable.warrior_musta, 0));
                        break;
                    case R.id.rbScout:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Black", "Scout", 16, 6, 0, 100, 100, 0, 0, R.drawable.scout_sininen, 0));
                        break;
                }
                break;
        }
        Storage.getInstance().saveLutemons(mContext);
    }
}