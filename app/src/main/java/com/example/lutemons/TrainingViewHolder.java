package com.example.lutemons;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrainingViewHolder extends RecyclerView.ViewHolder{
    ImageView ivTrainFighter;
    TextView tvName, tvHealth, tvAttack, tvDefence, tvWins;
    Button btnTrain, btnHeal;
    public TrainingViewHolder(@NonNull View itemView) {
        super(itemView);
        ivTrainFighter = itemView.findViewById(R.id.ivTrainFighterImage);
        tvName = itemView.findViewById(R.id.tvName);
        tvHealth = itemView.findViewById(R.id.tvHealth);
        tvAttack = itemView.findViewById(R.id.tvAttack);
        tvDefence = itemView.findViewById(R.id.tvDefence);
        tvWins = itemView.findViewById(R.id.tvWins);

        btnTrain = itemView.findViewById(R.id.btnTrain);
        btnHeal = itemView.findViewById(R.id.btnHeal);
    }
}
