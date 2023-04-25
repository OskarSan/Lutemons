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

import com.example.lutemons.LutemonListAdapter;
import com.example.lutemons.R;
import com.example.lutemons.Storage;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FightLutemonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FightLutemonFragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private Storage storage;
    private RecyclerView recyclerView;
    private View headerView;
    private Button fightButton;



    public FightLutemonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FightLutemonFragment.
     */

    public static FightLutemonFragment newInstance(String param1, String param2) {
        FightLutemonFragment fragment = new FightLutemonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fight_lutemon, container, false);
        storage = Storage.getInstance();
        recyclerView = view.findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new LutemonListAdapter(getContext(), storage.getLutemonHashMap()));

        fightButton = view.findViewById(R.id.fightButton);
        return view;
    }

    public void onResume(){
        super.onResume();
        recyclerView.setAdapter(new LutemonListAdapter(getContext(), storage.getLutemonHashMap()));
    }

}