package com.example.lutemons.fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import com.example.lutemons.Lutemon;
import com.example.lutemons.LutemonListAdapter;
import com.example.lutemons.R;
import com.example.lutemons.Storage;

import java.util.HashMap;


public class FightLutemonFragment extends Fragment {


    private String mParam1;
    private String mParam2;

    private Storage storage;
    private RecyclerView recyclerView;
    private View headerView;
    private Button fightButton;



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
        /*recyclerView = view.findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new LutemonListAdapter(getContext(), storage.getLutemonHashMap()));*/
        fightButton = view.findViewById(R.id.fightButton);
        CheckBox cb1 = view.findViewById(R.id.cb1);
        CheckBox cb2 = view.findViewById(R.id.cb2);
        fightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fight(view);
            }
        });
        return view;
    }

    public void onResume(){
        super.onResume();
        /*recyclerView.setAdapter(new LutemonListAdapter(getContext(), storage.getLutemonHashMap()));*/    }
    public void fight(View view){
        CheckBox cb1 = view.findViewById(R.id.cb1);
        CheckBox cb2 = view.findViewById(R.id.cb2);

        if(cb1.isChecked() & cb2.isChecked()){
            storage = Storage.getInstance();
            HashMap<Integer, Lutemon> lutemons = storage.getLutemonHashMap();
            Lutemon fighter1 = lutemons.get(0);
            Lutemon fighter2 = lutemons.get(1);
            while(fighter1.getHealth() > 0 & fighter2.getHealth() > 0){
                //todo attack ja defense metodikutsut tähän
                fighter2.defense(fighter1.attack());
                System.out.println(fighter2.getHealth());
            }
        }
    }

}