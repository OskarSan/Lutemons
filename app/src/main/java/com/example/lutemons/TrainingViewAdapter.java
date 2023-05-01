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

            holder.ivTrainFighter.setImageResource(lutemons.get(position).getImage());
            holder.tvName.setText(lutemons.get(position).getName() + "    Lvl: " + lutemons.get(position).getLevel() + "        Exp: " + lutemons.get(position).getExperience());
            holder.tvHealth.setText(String.valueOf("Elämä: " + lutemons.get(position).getHealth() + "/" + lutemons.get(position).getMaxHealth()));
            holder.tvAttack.setText(String.valueOf("Hyökkäys: " + lutemons.get(position).getAttack()));
            holder.tvDefence.setText(String.valueOf("Puolustus: " + lutemons.get(position).getDefense()));
            holder.tvWins.setText(String.valueOf("Voitot: " + lutemons.get(position).getWins()));
            holder.btnTrain.setOnClickListener(view -> {
                lutemons.get(position).trainLutemon();
                if(lutemons.get(position).getExperience() >= lutemons.get(position).getLevel() * 10 + 20){
                    lutemons.get(position).levelUp();
                }
                notifyDataSetChanged();
            //Todo Tähän training metodin kutsu
            });
            holder.btnHeal.setOnClickListener(view -> {
                //Healing
                lutemons.get(position).heal(lutemons.get(position).getExperience());
                lutemons.get(position).setExperience(0);
                notifyDataSetChanged();
                Storage.getInstance().saveLutemons(context);
            });


    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

}

