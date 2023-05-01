package com.example.lutemons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class TrainingViewAdapter extends RecyclerView.Adapter<TrainingViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public TrainingViewAdapter(Context context, ArrayList<Lutemon> lutemons) {
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
            holder.tvAttack.setText(String.valueOf(lutemons.get(position).getAttack()));
            holder.tvDefence.setText(String.valueOf(lutemons.get(position).getDefense()));
            holder.tvWins.setText(String.valueOf(lutemons.get(position).getWins()));
            holder.btnTrain.setOnClickListener(view -> {
                int pos = holder.getAdapterPosition();
                System.out.println("Toimii train");
                //Todo Tähän training metodin kutsu
            });
            holder.btnHeal.setOnClickListener(view -> {
                //Healing
                lutemons.get(position).heal(lutemons.get(position).getMaxHealth());
                System.out.println("Toimii heal");
                notifyDataSetChanged();
                Storage.getInstance().saveLutemons(context);
            });


    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

}

