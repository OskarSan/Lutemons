package com.example.lutemons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {
    private Context context;
    private HashMap<Integer, Lutemon> lutemons = new HashMap<>();

    public LutemonListAdapter(Context context, HashMap<Integer, Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.tvName.setText(lutemons.get(position).getName());
        holder.tvHealth.setText(String.valueOf( "Elämä: " + lutemons.get(position).getHealth()));
        holder.tvWins.setText(String.valueOf("Voitot: " + lutemons.get(position).getWins()));
        holder.tvAttack.setText(String.valueOf(": " + lutemons.get(position).getAttack()));
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
