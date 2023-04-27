package com.example.lutemons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class LBPageAdapter extends BaseAdapter {

    private Storage storage;
    Context context;
    HashMap<Integer,Lutemon> lutemonHashMap;

    LayoutInflater inflater;

    public LBPageAdapter(Context context){
        this.context = context;

        storage = Storage.getInstance();
        this.lutemonHashMap = storage.getLutemonHashMap();

        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return lutemonHashMap.size();
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
        ImageView LBPicture = view.findViewById(R.id.LBImageView);
        LBName.setText(lutemonHashMap.get(i).getName());
        LBHealth.setText(String.valueOf(lutemonHashMap.get(i).getHealth()));

        System.out.println(lutemonHashMap.get(i).getName());
        return view;
    }
}
