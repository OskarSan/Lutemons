package com.example.lutemons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

public class TrainingViewAdapter extends RecyclerView.Adapter<TrainingViewHolder> {
    private Context context;
    private HashMap<Integer, Lutemon> lutemons = new HashMap<>();

    public TrainingViewAdapter(Context context, HashMap<Integer, Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public TrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TrainingViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_training_view,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingViewHolder holder, int position) {
        holder.tvName.setText(lutemons.get(position).getName());
        holder.tvHealth.setText(String.valueOf(lutemons.get(position).getHealth()));
        holder.btnTrain.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            System.out.println("Toimii train");
            //Todo Tähän training metodin kutsu
        });
        holder.btnHeal.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            System.out.println("Toimii heal");
            //Todo Tähän heal metodin kutsu
        });
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}

