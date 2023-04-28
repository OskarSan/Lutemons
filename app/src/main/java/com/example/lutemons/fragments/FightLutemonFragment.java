package com.example.lutemons.fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.lutemons.Lutemon;
import com.example.lutemons.LutemonListAdapter;
import com.example.lutemons.R;
import com.example.lutemons.SpinnerAdapter;
import com.example.lutemons.Storage;

import java.util.ArrayList;
import java.util.HashMap;


public class FightLutemonFragment extends Fragment {

    private Lutemon selectedLutemon1, selectedLutemon2;
    private Storage storage;
    private RecyclerView recyclerView;
    private View headerView;
    private Button fightButton;

    private ArrayList<Lutemon> lutemonsNameList;
    private SpinnerAdapter spinnerAdapter;
    private Spinner dropDown, dropDown2;


    public FightLutemonFragment() {
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
        View view = inflater.inflate(R.layout.fragment_fight_lutemon , container, false);
        storage = Storage.getInstance();
        initList();
        fightButton = view.findViewById(R.id.fightButton);
        dropDown = view.findViewById(R.id.dropDown);
        dropDown2 = view.findViewById(R.id.dropdown2);
        spinnerAdapter = new SpinnerAdapter(getContext(), lutemonsNameList);
        dropDown.setAdapter(spinnerAdapter);
        dropDown2.setAdapter(spinnerAdapter);

        fightButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fight(selectedLutemon1, selectedLutemon2);
            }
        });
        return view;
    }
    private void initList(){
        storage = Storage.getInstance();
        lutemonsNameList = new ArrayList<>();
        HashMap<Integer, Lutemon> lutemonHashMap = storage.getLutemonHashMap();
        for(HashMap.Entry<Integer, Lutemon> set :lutemonHashMap.entrySet()){
            lutemonsNameList.add(set.getValue());
        }
    }

    public void onResume(){
        super.onResume();
        initList();
        spinnerAdapter = new SpinnerAdapter(getContext(), lutemonsNameList);
        dropDown.setAdapter(spinnerAdapter);
        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedLutemon1 = (Lutemon)adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        dropDown2.setAdapter(spinnerAdapter);
        dropDown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedLutemon2 = (Lutemon)adapterView.getItemAtPosition(i);
                System.out.println(selectedLutemon2.getName() + " valittu");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void fight(Lutemon fighter1, Lutemon fighter2){
            while(fighter1.getHealth() > 0 & fighter2.getHealth() > 0){
                //todo attack ja defense metodikutsut tähän
                fighter2.defense(fighter1.attack());
                System.out.println(fighter2.getHealth());
            }
            if(fighter1.getHealth()>0){
                System.out.println(fighter1.getName() + " voittaa");
                fighter1.setExperience(fighter1.getExperience() + 10);
                Storage.getInstance().removeLutemon(fighter2);
            }else{
                System.out.println(fighter2.getName() + " voittaa");
                fighter2.setExperience(fighter2.getExperience() + 10);
                Storage.getInstance().removeLutemon(fighter1);
            }

        }
    }