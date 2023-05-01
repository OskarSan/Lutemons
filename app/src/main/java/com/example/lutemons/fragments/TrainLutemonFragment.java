package com.example.lutemons.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lutemons.LutemonListAdapter;
import com.example.lutemons.R;
import com.example.lutemons.Storage;
import com.example.lutemons.TrainingViewAdapter;

public class TrainLutemonFragment extends Fragment {

    private String mParam1;
    private String mParam2;
    private Storage storage;
    private RecyclerView recyclerView;

    public TrainLutemonFragment() {
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
        View view = inflater.inflate(R.layout.fragment_train_lutemon, container, false);
        storage = Storage.getInstance();
        recyclerView = view.findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new TrainingViewAdapter(getContext(), storage.getLutemonArrayList()));

        return view;
    }
    public void onResume(){
        super.onResume();
        recyclerView.setAdapter(new TrainingViewAdapter(getContext(), storage.getLutemonArrayList()));
    }



}