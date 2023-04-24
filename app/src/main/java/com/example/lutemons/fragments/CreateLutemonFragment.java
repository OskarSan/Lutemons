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
import com.example.lutemons.MainActivity;
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
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "White", "Tank", 1, 1, 1, 1, 1, 0, 0));
                        break;
                    case R.id.rbWarrior:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "White", "Warrior", 1, 1, 1, 1, 1, 0, 0));
                        break;
                    case R.id.rbMonk:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "White", "Monk", 1, 1, 1, 1, 1, 0, 0));
                        break;
                }
                break;
            case R.id.rbGreen:
                switch (rgLutemonClass.getCheckedRadioButtonId()) {
                    case R.id.rbTank:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Green", "Tank", 1, 1, 1, 1, 1, 0, 0));
                        break;
                    case R.id.rbWarrior:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Green", "Warrior", 1, 1, 1, 1, 1, 0, 0));
                        break;
                    case R.id.rbMonk:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Green", "Monk", 1, 1, 1, 1, 1, 0, 0));
                        break;
                }
                break;
            case R.id.rbPink:
                switch (rgLutemonClass.getCheckedRadioButtonId()) {
                    case R.id.rbTank:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Pink", "Tank", 1, 1, 1, 1, 1, 0, 0));
                        break;
                    case R.id.rbWarrior:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Pink", "Warrior", 1, 1, 1, 1, 1, 0, 0));
                        break;
                    case R.id.rbMonk:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Pink", "Monk", 1, 1, 1, 1, 1, 0, 0));
                        break;
                }
                break;
            case R.id.rbOrange:
                switch (rgLutemonClass.getCheckedRadioButtonId()) {
                    case R.id.rbTank:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Orange", "Tank", 1, 1, 1, 1, 1, 0, 0));
                        break;
                    case R.id.rbWarrior:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Orange", "Warrior", 1, 1, 1, 1, 1, 0, 0));
                        break;
                    case R.id.rbMonk:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Orange", "Monk", 1, 1, 1, 1, 1, 0, 0));
                        break;
                }
                break;
            case R.id.rbBlack:
                switch (rgLutemonClass.getCheckedRadioButtonId()) {
                    case R.id.rbTank:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Black", "Tank", 1, 1, 1, 1, 1, 0, 0));
                        break;
                    case R.id.rbWarrior:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Black", "Warrior", 1, 1, 1, 1, 1, 0, 0));
                        break;
                    case R.id.rbMonk:
                        Storage.getInstance().addLutemon(new Lutemon(etLutemonName.getText().toString(), "Black", "Monk", 1, 1, 1, 1, 1, 0, 0));
                        break;
                }
                break;
        }
        Storage.getInstance().saveLutemons(mContext);
    }
}