package com.example.lutemons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class LBPageAdapter extends BaseAdapter {

    private Storage storage;
    Context context;
    ArrayList<Lutemon> lutemonArrayList;

    LayoutInflater inflater;

    public LBPageAdapter(Context context, ArrayList<Lutemon> lutemonArrayList){
        this.context = context;

        this.lutemonArrayList = lutemonArrayList;

        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return lutemonArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.leaderboard_view, null);
        TextView LBName = view.findViewById(R.id.LBName);
        TextView LBHealth = view.findViewById(R.id.LBHealth);
        TextView LBWins = view.findViewById(R.id.LBWins);
        TextView LBAttack = view.findViewById(R.id.LBAttack);
        ImageView LBPicture = view.findViewById(R.id.LBImageView);
        LBName.setText(lutemonArrayList.get(i).getName());
        LBHealth.setText(String.valueOf(lutemonArrayList.get(i).getHealth()));
        LBWins.setText(String.valueOf(lutemonArrayList.get(i).getWins()));
        LBAttack.setText(String.valueOf(lutemonArrayList.get(i).getAttack()));
        LBPicture.setImageResource(lutemonArrayList.get(i).getImage());
        System.out.println(lutemonArrayList.get(i).getName());
        return view;
    }
}
