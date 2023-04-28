package com.example.lutemons;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrainingViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView tvName, tvHealth;
    Button btnTrain, btnHeal;
    public TrainingViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        tvName = itemView.findViewById(R.id.tvName);
        tvHealth = itemView.findViewById(R.id.tvHealth);
        btnTrain = itemView.findViewById(R.id.btnTrain);
        btnHeal = itemView.findViewById(R.id.btnHeal);
    }
}
